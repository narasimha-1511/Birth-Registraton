package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.UserInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * RequestInfo should be used to carry meta information about the requests to the server as described in the fields below. All eGov APIs will use requestinfo as a part of the request body to carry this meta information. Some of this information will be returned back from the server as part of the ResponseInfo in the response body to ensure correlation.
 */
@Schema(description = "RequestInfo should be used to carry meta information about the requests to the server as described in the fields below. All eGov APIs will use requestinfo as a part of the request body to carry this meta information. Some of this information will be returned back from the server as part of the ResponseInfo in the response body to ensure correlation.")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-03-24T07:25:44.850546250Z[Etc/UTC]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestInfo2   {
        @JsonProperty("apiId")
          @NotNull

        @Size(max=128)         private String apiId = null;

        @JsonProperty("ver")
          @NotNull

        @Size(max=32)         private String ver = null;

        @JsonProperty("ts")
          @NotNull

                private Long ts = null;

        @JsonProperty("action")
          @NotNull

        @Size(max=32)         private String action = null;

        @JsonProperty("did")

        @Size(max=1024)         private String did = null;

        @JsonProperty("key")

        @Size(max=256)         private String key = null;

        @JsonProperty("msgId")
          @NotNull

        @Size(max=256)         private String msgId = null;

        @JsonProperty("requesterId")

        @Size(max=256)         private String requesterId = null;

        @JsonProperty("authToken")

                private String authToken = null;

        @JsonProperty("userInfo")

          @Valid
                private UserInfo userInfo = null;

        @JsonProperty("correlationId")

                private String correlationId = null;


}
