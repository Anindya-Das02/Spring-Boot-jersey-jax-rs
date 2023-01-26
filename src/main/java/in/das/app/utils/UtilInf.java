package in.das.app.utils;

import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public interface UtilInf {

    static String getUUIDString(){
        return UUID.randomUUID().toString();
    }
}
