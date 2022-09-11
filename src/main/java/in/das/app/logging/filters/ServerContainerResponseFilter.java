package in.das.app.logging.filters;

import in.das.app.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Provider
@Slf4j
public class ServerContainerResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        containerResponseContext.getHeaders().add("x-provider","server-app-response");
        log.info("url=\"{}\" method=\"{}\" Request-Headers={}  Response-Headers={} ResponsePayload={}", containerRequestContext.getUriInfo().getRequestUri().toURL() ,containerRequestContext.getMethod(),
                containerRequestContext.getHeaders(), containerResponseContext.getHeaders(), CommonUtils.convertPOJOIntoJSONString(containerResponseContext.getEntity()));
    }
}
