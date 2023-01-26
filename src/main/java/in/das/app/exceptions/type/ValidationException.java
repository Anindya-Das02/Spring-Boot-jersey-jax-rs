package in.das.app.exceptions.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends Exception {

    private String errorMessage;
    private String errorUUID;

    public ValidationException(final String errorMessage, final String errorUUID) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorUUID = errorUUID;
    }
}
