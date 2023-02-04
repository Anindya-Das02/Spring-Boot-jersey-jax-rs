package in.das.app.resource;

import in.das.app.constants.ResourcePath;
import in.das.app.model.pojo.Todo;
import in.das.app.service.todo.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAllTodoItems(){
        log.info("fetching all Todo details...");
        return todoService.getAllTodoItems();
    }

    @GET
    @Path("/db/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getTodoFromDB(@PathParam("id") final int id){
        log.info("fetching todo record from DB with id={}", id);
        return todoService.fetchTodoFromDB(id);
    }

    @GET
    @Path("/db/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getTodoFromDB(){
        log.info("fetching all todo record from DB");
        return todoService.fetchAllTodos();
    }

    @POST
    @Path("/db/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTodoTask(final Todo todo){
        log.info("Inserting record into DB");
        return todoService.createTodo(todo);
    }
}
