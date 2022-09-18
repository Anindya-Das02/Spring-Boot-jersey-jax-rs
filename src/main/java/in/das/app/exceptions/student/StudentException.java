package in.das.app.exceptions.student;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


public class StudentException extends WebApplicationException {

    private String message;
    private String status;

    public StudentException(final String message, final String status){
        super(Response.status(Response.Status.BAD_REQUEST).entity(new StudentErrorResponseSchema(message,status)).build());
    }
}
