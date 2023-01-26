package in.das.app.exceptions.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ValidationExceptionSchema {
    private String errorMessage;
    private String errorUUID;
}
