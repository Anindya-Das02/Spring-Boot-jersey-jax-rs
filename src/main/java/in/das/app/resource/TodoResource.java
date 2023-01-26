package in.das.app.resource;

import in.das.app.constants.ResourcePath;
import in.das.app.model.pojo.Todo;
import in.das.app.service.todo.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(ResourcePath.TODO_RESOURCE_PATH)
@Slf4j
public class TodoResource extends BaseResource {

    @Autowired
    private TodoService todoService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getTodoItem(@PathParam("id") final int id){
        log.info("fetching Todo details for id: {}",id);
        return todoService.getTodoItemDetails(id);
    }
}
