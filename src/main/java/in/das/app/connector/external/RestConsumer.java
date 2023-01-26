package in.das.app.connector.external;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RestConsumer {

    private final RestTemplate restTemplate = new RestTemplate();

    public <T> T simpleGet(final String url, final TypeReference<T> clazz){
        ResponseEntity<String> responseEntity = null;
        try{
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        }catch (Exception ex){
            log.error("An error occurred while performing [GET] url=\"{}\" message=\"{}\"",url,ex.getMessage());
            return null;
        }
        return getResponseBodyAsObject(responseEntity,clazz);
    }

    private <T> T getResponseBodyAsObject(ResponseEntity<String> responseEntity, TypeReference<T> clazz){
        T response = null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            response = mapper.readValue(responseEntity.getBody(),clazz);
        }catch (Exception ex){
            log.error("An error occurred message=\"{}\"",ex.getMessage());
        }
        return response;
    }
}
