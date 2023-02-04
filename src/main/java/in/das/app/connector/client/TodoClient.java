package in.das.app.connector.client;

import com.fasterxml.jackson.core.type.TypeReference;
import in.das.app.connector.external.RestConsumer;
import in.das.app.connector.external.WebClientConsumer;
import in.das.app.model.pojo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
public class TodoClient {

    private String url;

    @Autowired
    private RestConsumer restConsumer;

    @Autowired
    private WebClientConsumer webClientConsumer;

    public TodoClient(String url) {
        this.url = url;
    }

    public Todo getTodoItemDetails(final int id){
        log.info("fetching todo item...");
//        return restConsumer.simpleGet(url + id, new TypeReference<Todo>(){});
        return webClientConsumer.executeGET(url + id, new ParameterizedTypeReference<Todo>() {});
    }

    public List<Todo> getAllTodoItems(){
        log.info("fetching todo items...");
        TypeReference<List<Todo>> responseClassType = new TypeReference<List<Todo>>() {};
//        return restConsumer.simpleGet(url,responseClassType);
        return webClientConsumer.executeGET(url, new ParameterizedTypeReference<List<Todo>>() {});
    }
}
