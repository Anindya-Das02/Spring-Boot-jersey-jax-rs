package in.das.app.config;

import in.das.app.connector.client.TodoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public TodoClient todoClient(@Value("${todo.url.base}") final String url){
        return new TodoClient(url);
    }
}
