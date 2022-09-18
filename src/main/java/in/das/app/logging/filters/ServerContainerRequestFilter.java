package in.das.app.logging.filters;

import com.google.common.io.ByteStreams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

@Slf4j
@Provider
@Order(1)
public class ServerContainerRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        StringBuilder rsb = new StringBuilder();
        rsb.append("url=").append(requestContext.getUriInfo().getAbsolutePath().toString()).append(" ");
        rsb.append("httpMethod=").append(requestContext.getMethod()).append(" ");
        rsb.append("Request-Headers:");
        for(String header : requestContext.getHeaders().keySet()){
            rsb.append(header).append(":").append(requestContext.getHeaderString(header)).append(" ");
        }
        if (StringUtils.isNotBlank(requestContext.getUriInfo().getRequestUri().getQuery())){
            rsb.append("queryParams=").append(requestContext.getUriInfo().getRequestUri().getQuery()).append(" ");
        }

        if (requestContext.hasEntity()){
            InputStream inputStream = requestContext.getEntityStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            if (inputStream.available() > 0){
                ByteStreams.copy(inputStream,outputStream);
                byte[] requestEntity = outputStream.toByteArray();
                rsb.append("RequestPayload=").append(outputStream.toString(StandardCharsets.UTF_8)).append(" ");
                requestContext.setEntityStream(new ByteArrayInputStream(requestEntity));
            }
        }
        requestContext.setProperty("request-begin-time", Instant.now());
        requestContext.setProperty("request-context",rsb.toString());
    }
}
