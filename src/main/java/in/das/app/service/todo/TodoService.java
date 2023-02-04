package in.das.app.service.todo;

import in.das.app.connector.client.TodoClient;
import in.das.app.mapper.TodoMapper;
import in.das.app.model.pojo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class TodoService {

    @Autowired
    private TodoClient todoClient;

    @Autowired
    private TodoMapper todoMapper;

    public Todo getTodoItemDetails(final int id){
        return todoClient.getTodoItemDetails(id);
    }

    public List<Todo> getAllTodoItems(){
        return todoClient.getAllTodoItems();
    }

    public Todo fetchTodoFromDB(final int id){
        Todo todoResponse = todoMapper.getTodo(id);
        return todoResponse;
    }

    public List<Todo> fetchAllTodos(){
        return todoMapper.fetchAllTodo();
    }

    public Response createTodo(final Todo todo){
        try{
            todoMapper.insertTodo(todo);
        }catch (Exception ex){
            log.error("Error occurred in inserting record in DB, message=\"{}\"",ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                    new HashMap<String,String>(){{
                        put("status","error");
                        put("message",ex.getMessage());
                    }}
            ).build();
        }
        return Response.status(Response.Status.OK)
                .entity(
                        new HashMap<String,String>(){{
                            put("status","OK");
                            put("message","inserted record in DB");
                        }}
                ).build();
    }
}
