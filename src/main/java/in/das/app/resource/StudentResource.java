package in.das.app.resource;

import in.das.app.constants.ResourcePath;
import in.das.app.model.Student;
import in.das.app.model.response.StudentResponse;
import in.das.app.service.student.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(ResourcePath.STUDENT_RESOURCE_PATH)
@Slf4j
public class StudentResource {

    @Context
    private HttpHeaders httpHeaders;

    @Autowired
    private StudentService studentService;

    @GET
    @Path("/_health")
    public Response serverHealthCheck(){
        String x = httpHeaders.getHeaderString("service-name");
        log.info("Server up...");
        return Response.status(Response.Status.OK).entity("Ok Response").build();
    }

    @POST
    @Path("/service")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response studentService(final Student student){
        log.info("inside student service");
        String userId = httpHeaders.getHeaderString("user-id");
        String authId = httpHeaders.getHeaderString("x-auth-id");

        if (!authId.equals("12345")){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).entity("Ok Response").build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StudentResponse addStudent(final Student student){
        log.info("Inside student add service");
        String userId = httpHeaders.getHeaderString("user-id");
        return studentService.addStudentService(student);
    }
}
