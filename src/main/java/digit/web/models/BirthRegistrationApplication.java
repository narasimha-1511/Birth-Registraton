package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.Address;
import digit.web.models.Applicant;
import digit.web.models.AuditDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * A Object holds the basic data for a Birth Registration Application
 */
@Schema(description = "A Object holds the basic data for a Birth Registration Application")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-03-24T07:06:09.888255110Z[Etc/UTC]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BirthRegistrationApplication   {
        @JsonProperty("id")

        @Size(min=2,max=64)         private String id = null;

        @JsonProperty("tenantId")
          @NotNull

        @Size(min=2,max=128)         private String tenantId = null;

        @JsonProperty("applicationNumber")

        @Size(min=2,max=128)         private String applicationNumber = null;

        @JsonProperty("babyFirstName")
          @NotNull

        @Size(min=2,max=128)         private String babyFirstName = null;

        @JsonProperty("babyLastName")
          @NotNull

        @Size(min=2,max=128)         private String babyLastName = null;

        @JsonProperty("fatherOfApplicant")
          @NotNull

        @Size(min=2,max=128)         private String fatherOfApplicant = null;

        @JsonProperty("motherOfApplicant")
          @NotNull

        @Size(min=2,max=128)         private String motherOfApplicant = null;

        @JsonProperty("fatherMobileNumber")
          @NotNull

        @Size(min=2,max=128)         private String fatherMobileNumber = null;

        @JsonProperty("motherMobileNumber")
          @NotNull

        @Size(min=2,max=128)         private String motherMobileNumber = null;

        @JsonProperty("doctorName")
          @NotNull

        @Size(min=2,max=128)         private String doctorName = null;

        @JsonProperty("hospitalName")
          @NotNull

        @Size(min=2,max=128)         private String hospitalName = null;

        @JsonProperty("placeOfBirth")
          @NotNull

        @Size(min=2,max=128)         private String placeOfBirth = null;

        @JsonProperty("timeOfBirth")
          @NotNull

                private Integer timeOfBirth = null;

        @JsonProperty("address")

          @Valid
                private Address address = null;

        @JsonProperty("applicant")
          @NotNull

          @Valid
                private Applicant applicant = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;


}
