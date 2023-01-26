package in.das.app.connector.client;

import com.fasterxml.jackson.core.type.TypeReference;
import in.das.app.connector.external.RestConsumer;
import in.das.app.model.pojo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
public class TodoClient {

    private String url;

    @Autowired
    private RestConsumer restConsumer;

    public TodoClient(String url) {
        this.url = url;
    }

    public Todo getTodoItemDetails(final int id){
        log.info("fetching todo item...");
        return restConsumer.simpleGet(url + id, new TypeReference<Todo>(){});
    }
}
