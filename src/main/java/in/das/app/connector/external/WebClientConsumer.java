package in.das.app.connector.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class WebClientConsumer {

    @Autowired
    private WebClient webClient;

    public <T> T executeGET(final String url, final ParameterizedTypeReference<T> parameterizedTypeReference){
        T response = null;
        try{
            response = webClient.get().uri(url).retrieve().bodyToMono(parameterizedTypeReference).block();
        }catch (Exception ex){
            log.error("An error occurred while performing [GET] url=\"{}\" message=\"{}\"",url,ex.getMessage());
        }
        if(response == null){
            log.error("[ERROR] response is null");
        }
        return response;
    }

//    public static void main(String[] args) {
//
//        get();
//
//    }
//
//    private static void get(){
//        WebClient webClient1 = WebClient.create("https://jsonplaceholder.typicode.com/todos/6");
//        Mono<Todo> todoMono = webClient1
//                .get()
//                .retrieve()
//                .bodyToMono(Todo.class);
//        todoMono.subscribe((response) -> {
//
//
//        });
//        System.out.println(todoMono);
//
//
//
//
//
//    }
}