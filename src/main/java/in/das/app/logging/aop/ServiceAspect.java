package in.das.app.logging.aop;

import in.das.app.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
@Slf4j
public class ServiceAspect {

    public Object serviceAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Entering Into:: className=\""+className+"\" methodName=\""+methodName+"\"");
        Instant start = Instant.now();
        Object response = null;
        try{
            response = joinPoint.proceed();
        }finally {
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start,finish).toMillis();
            if (response != null){
                log.info("Returning from className=\"{}\" methodName=\"{}\" Response={} totalTimeTakenInMs={}",className, methodName, response, timeElapsed);
            }else{
                log.info("Exiting from \"" + className+ "." + methodName + "\" totalTimeTakenInMs=" + timeElapsed);
            }
        }
        return response;
    }
}
