package in.das.app.logging.filters;

import in.das.app.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;

@Provider
@Slf4j
public class ServerContainerResponseFilter implements ContainerResponseFilter {

    private static final String REQUEST_CONTEXT = "request-context";
    private static final String REQUEST_BEGIN_TIME = "request-begin-time";

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("x-provider","server-app-response");
        StringBuilder rsb = new StringBuilder();

        rsb.append("statusCode=").append(containerResponseContext.getStatus()).append(" ");
        rsb.append("Response-Headers:");
        for (String header : containerResponseContext.getHeaders().keySet()){
            rsb.append(header).append(":").append(containerResponseContext.getHeaderString(header)).append(" ");
        }

        if (containerResponseContext.hasEntity()){
            rsb.append("ResponsePayload=").append(CommonUtils.convertPOJOIntoJSONString(containerResponseContext.getEntity())).append(" ");
        }
        long serviceExecutionTimeInMs = Duration.between((Temporal) containerRequestContext.getProperty(REQUEST_BEGIN_TIME), Instant.now()).toMillis();
        log.info("{} {} totalExecutionTimeInMs={}",containerRequestContext.getProperty(REQUEST_CONTEXT), rsb.toString(), serviceExecutionTimeInMs);
    }
}
