package in.das.app.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.HashMap;

public class BaseResource {

    @GET
    @Path("/_test")
    public Response serverHealthCheck(){
        return Response.status(200).entity(new HashMap<>(){{
            put("code",200);
            put("message","Server up & running!");
            put("datetime",new Date());
        }}).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
