package in.das.app.config;

import in.das.app.logging.filters.ServerContainerResponseFilter;
import in.das.app.resource.StudentResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig extends ResourceConfig {

    public RestConfig(Class<?>... classes){
        register(StudentResource.class);
        register(ServerContainerResponseFilter.class);
    }
}
