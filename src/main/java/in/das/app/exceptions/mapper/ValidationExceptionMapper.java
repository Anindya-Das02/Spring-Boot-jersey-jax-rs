package in.das.app.exceptions.mapper;

import in.das.app.exceptions.type.ValidationException;
import in.das.app.exceptions.schema.ValidationExceptionSchema;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException ex) {
        ValidationExceptionSchema exceptionSchema = new ValidationExceptionSchema();
        exceptionSchema.setErrorMessage(ex.getErrorMessage());
        exceptionSchema.setErrorUUID(ex.getErrorUUID());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exceptionSchema).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
