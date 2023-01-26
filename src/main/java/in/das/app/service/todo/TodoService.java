package in.das.app.service.todo;

import in.das.app.connector.client.TodoClient;
import in.das.app.model.pojo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoClient todoClient;

    public Todo getTodoItemDetails(final int id){
        return todoClient.getTodoItemDetails(id);
    }
}