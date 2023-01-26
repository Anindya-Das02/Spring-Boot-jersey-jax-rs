package in.das.app.resource;

import in.das.app.constants.ResourcePath;
import in.das.app.exceptions.type.ValidationException;
import in.das.app.model.request.Voter;
import in.das.app.service.testservices.VoterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path(ResourcePath.TEST_RESOURCE_PATH)
@Slf4j
public class TestResource {

    @Autowired
    private VoterService voterService;

    @GET
    @Path("/_health")
    @Produces(MediaType.APPLICATION_JSON)
    public Response serverHealthCheck(){
        log.info("Server up...");
        return Response.status(Response.Status.OK).entity("Ok Response").type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    @POST
    @Path("/voter/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateVoterAge(final Voter voter) throws ValidationException {

        if(voterService.isVoterValid(voter)){
            return Response.status(200).entity("Voter Valid").build();
        }
        return null;
    }
}
