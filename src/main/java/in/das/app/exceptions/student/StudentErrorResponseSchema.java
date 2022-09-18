package in.das.app.exceptions.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.das.app.utils.CommonUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentErrorResponseSchema {
    private String message;
    private String status;
    private String uuid;

    public StudentErrorResponseSchema(String message, String status) {
        this.message = message;
        this.status = status;
        this.uuid = CommonUtils.generateUUIDString();
    }
}
