package in.das.app.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommonUtils {

    public static String convertPOJOIntoJSONString(final Object pojo){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(pojo);
        }catch (Exception ex){
            log.error(String.format("[ObjectMapper] An error occurred while converting %s POJO into JSON string",pojo.getClass().toString()));
            ex.printStackTrace();
        }
        return null;
    }
}
