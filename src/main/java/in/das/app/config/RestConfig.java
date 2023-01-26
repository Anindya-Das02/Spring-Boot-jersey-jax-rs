package in.das.app.config;

import in.das.app.exceptions.mapper.ValidationExceptionMapper;
import in.das.app.logging.filters.ServerContainerRequestFilter;
import in.das.app.logging.filters.ServerContainerResponseFilter;
import in.das.app.resource.StudentResource;
import in.das.app.resource.TestResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig extends ResourceConfig {

    public RestConfig(Class<?>... classes){
        register(StudentResource.class);
        register(TestResource.class);

        register(ServerContainerResponseFilter.class);
        register(ServerContainerRequestFilter.class);

        register(ValidationExceptionMapper.class);
    }
}
