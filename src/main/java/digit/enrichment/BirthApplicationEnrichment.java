package digit.enrichment;

//import digit.models.UserService;
import digit.util.IdgenUtil;
import digit.util.UserUtil;
import digit.web.models.*;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.user.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
@Slf4j
public class BirthApplicationEnrichment {

    @Autowired
    private IdgenUtil idgenUtil;

//    @Autowired
//    private UserService userService;

    @Autowired
    private UserUtil userUtils;



    public void enrichBirthApplicationUponUpdate(BirthRegistrationRequest birthRegistrationRequest) {
        // Enrich lastModifiedTime and lastModifiedBy in case of update
        birthRegistrationRequest.getBirthRegistrationApplications().get(0).getAuditDetails().setLastModifiedTime(System.currentTimeMillis());
        birthRegistrationRequest.getBirthRegistrationApplications().get(0).getAuditDetails().setLastModifiedBy(birthRegistrationRequest.getRequestInfo().getUserInfo().getUuid());
    }

    public void enrichFatherApplicantOnSearch(BirthRegistrationApplication application) {
//        UserDetailResponse fatherUserResponse = userService.searchUser(userUtils.getStateLevelTenant(application.getTenantId()),application.getFather().getId(),null);
//        User fatherUser = fatherUserResponse.getUser().get(0);
//        log.info(fatherUser.toString());
//        FatherApplicant fatherApplicant = FatherApplicant.builder().aadhaarNumber(fatherUser.getAadhaarNumber())
//                .accountLocked(fatherUser.getAccountLocked())
//                .active(fatherUser.getActive())
//                .altContactNumber(fatherUser.getAltContactNumber())
//                .bloodGroup(fatherUser.getBloodGroup())
//                .correspondenceAddress(fatherUser.getCorrespondenceAddress())
//                .correspondenceCity(fatherUser.getCorrespondenceCity())
//                .correspondencePincode(fatherUser.getCorrespondencePincode())
//                .gender(fatherUser.getGender())
//                .id(fatherUser.getUuid())
//                .name(fatherUser.getName())
//                .type(fatherUser.getType())
//                .roles(fatherUser.getRoles()).build();
//        application.setFather(fatherApplicant);
    }

    public void enrichMotherApplicantOnSearch(BirthRegistrationApplication application) {
//        UserDetailResponse motherUserResponse = userService.searchUser(userUtils.getStateLevelTenant(application.getTenantId()),application.getFather().getId(),null);
//        User motherUser = motherUserResponse.getUser().get(0);
//        log.info(motherUser.toString());
//        MotherApplicant motherApplicant = MotherApplicant.builder().aadhaarNumber(motherUser.getAadhaarNumber())
//                .accountLocked(motherUser.getAccountLocked())
//                .active(motherUser.getActive())
//                .altContactNumber(motherUser.getAltContactNumber())
//                .bloodGroup(motherUser.getBloodGroup())
//                .correspondenceAddress(motherUser.getCorrespondenceAddress())
//                .correspondenceCity(motherUser.getCorrespondenceCity())
//                .correspondencePincode(motherUser.getCorrespondencePincode())
//                .gender(motherUser.getGender())
//                .id(motherUser.getUuid())
//                .name(motherUser.getName())
//                .type(motherUser.getType())
//                .roles(motherUser.getRoles()).build();
//        application.setMother(motherApplicant);
    }
}