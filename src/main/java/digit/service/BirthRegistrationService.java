package digit.service;


import digit.config.BTRConfiguration;
import digit.enrichment.BirthApplicationEnrichment;
import digit.kafka.Producer;
import digit.repository.BirthRegistrationRepository;
import digit.validators.BirthApplicationValidator;
import digit.web.models.*;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class BirthRegistrationService {

    @Autowired
    private BirthApplicationValidator validator;

    @Autowired
    private BirthApplicationEnrichment enrichmentUtil;

//    @Autowired
//    private User userService;
//
//    @Autowired
//    private Workflow workflowService;

    @Autowired
    private BirthRegistrationRepository birthRegistrationRepository;

    @Autowired
    private Producer producer;

    public List<BirthRegistrationApplication> registerBtRequest(BirthRegistrationRequest birthRegistrationRequest) {
        // Validate applications
        validator.validateBirthApplication(birthRegistrationRequest);

        // Enrich applications
        enrichmentUtil.enrichBirthApplication(birthRegistrationRequest);

        // Enrich/Upsert user in upon birth registration
//        userService.callUserService(birthRegistrationRequest);

        // Initiate workflow for the new application
//        workflowService.updateWorkflowStatus(birthRegistrationRequest);

        // Push the application to the topic for persister to listen and persist
        producer.push("save-bt-application", birthRegistrationRequest);

        // Return the response back to user
        return birthRegistrationRequest.getBirthRegistrationApplications();
    }

    public List<BirthRegistrationApplication> searchBtApplications(RequestInfo requestInfo, BirthApplicationSearchCriteria birthApplicationSearchCriteria) {
        // Fetch applications from database according to the given search criteria
        List<BirthRegistrationApplication> applications = birthRegistrationRepository.getApplications(birthApplicationSearchCriteria);

        // If no applications are found matching the given criteria, return an empty list
        if(CollectionUtils.isEmpty(applications))
            return new ArrayList<>();

        // Enrich mother and father of applicant objects
        applications.forEach(application -> {
            enrichmentUtil.enrichFatherApplicantOnSearch(application);
            enrichmentUtil.enrichMotherApplicantOnSearch(application);
        });

        // Otherwise return the found applications
        return applications;
    }

    public BirthRegistrationApplication updateBtApplication(BirthRegistrationRequest birthRegistrationRequest) {
        // Validate whether the application that is being requested for update indeed exists
        BirthRegistrationApplication existingApplication = validator.validateApplicationExistence(birthRegistrationRequest.getBirthRegistrationApplications().get(0));
//        existingApplication.setWorkflow(birthRegistrationRequest.getBirthRegistrationApplications().get(0).getWorkflow());
        log.info(existingApplication.toString());
        birthRegistrationRequest.setBirthRegistrationApplications(Collections.singletonList(existingApplication));

        // Enrich application upon update
        enrichmentUtil.enrichBirthApplicationUponUpdate(birthRegistrationRequest);

//        workflowService.updateWorkflowStatus(birthRegistrationRequest);

        // Just like create request, update request will be handled asynchronously by the persister
        producer.push("update-bt-application", birthRegistrationRequest);

        return birthRegistrationRequest.getBirthRegistrationApplications().get(0);
    }

    @Slf4j
    @Service
    public static class NotificationService {

        @Autowired
        private Producer producer;

        @Autowired
        private BTRConfiguration config;

        @Autowired
        private RestTemplate restTemplate;

        private static final String smsTemplate = "Dear {FATHER_NAME} and {MOTHER_NAME} your birth registration application has been successfully created on the system with application number - {APPNUMBER}.";

        public void prepareEventAndSend(BirthRegistrationRequest request){
            List<SMSRequest> smsRequestList = new ArrayList<>();
            request.getBirthRegistrationApplications().forEach(application -> {
                SMSRequest smsRequestForFather = SMSRequest.builder().mobileNumber(application.getFatherMobileNumber()).message(getCustomMessage(smsTemplate, application)).build();
                SMSRequest smsRequestForMother = SMSRequest.builder().mobileNumber(application.getMotherMobileNumber()).message(getCustomMessage(smsTemplate, application)).build();
                smsRequestList.add(smsRequestForFather);
                smsRequestList.add(smsRequestForMother);
            });
            for (SMSRequest smsRequest : smsRequestList) {
                producer.push(config.getSmsNotificationTopic(), smsRequest);
                log.info("Messages: " + smsRequest.getMessage());
            }
        }

        private String getCustomMessage(String template, BirthRegistrationApplication application) {
            template = template.replace("{APPNUMBER}", application.getApplicationNumber());
            template = template.replace("{FATHER_NAME}", application.getFatherOfApplicant());
            template = template.replace("{MOTHER_NAME}", application.getMotherOfApplicant());
            return template;
        }

    }
}
