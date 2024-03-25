package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.Document;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Fields related to workflow service
 */
@Schema(description = "Fields related to workflow service")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-03-24T07:06:09.888255110Z[Etc/UTC]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Workflow   {
        @JsonProperty("action")

        @Size(min=1,max=64)         private String action = null;

        @JsonProperty("status")

                private String status = null;

        @JsonProperty("comments")

        @Size(min=1,max=64)         private String comments = null;

        @JsonProperty("documents")
          @Valid
                private List<Document> documents = null;


        public Workflow addDocumentsItem(Document documentsItem) {
            if (this.documents == null) {
            this.documents = new ArrayList<>();
            }
        this.documents.add(documentsItem);
        return this;
        }

}
