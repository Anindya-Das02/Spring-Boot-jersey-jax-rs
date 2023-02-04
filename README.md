# Spring-Boot-jersey-jax-rs

### Run using Docker:
```
$ sudo docker pull anindyad3v/springboot-template-jersey-jaxrs
$ sudo docker run -d -p <your_host>:8080 <container_id>
```

### Concepts:
Spring Boot, JAX-RS (Jersey), REST apis, Maven, AOP (Aspect), slf4j logging, Custom Runtime Exceptions, Filters (ServerContainers), Docker  

### Console Logs
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.3)

12:24:34.447 [main] INFO  in.das.app.DasJerseyAppApplication serviceName="" reqId="" - Starting DasJerseyAppApplication using Java 18.0.2.1 on anindya with PID 412 (/home/anindya/Programs/spring-boot-prgms/das-jersey-app/target/classes started by anindya in /home/anindya/Programs/spring-boot-prgms/das-jersey-app)
12:24:34.452 [main] INFO  in.das.app.DasJerseyAppApplication serviceName="" reqId="" - No active profile set, falling back to 1 default profile: "default"
12:24:38.991 [main] INFO  o.s.b.w.e.tomcat.TomcatWebServer serviceName="" reqId="" - Tomcat initialized with port(s): 8080 (http)
12:24:39.011 [main] INFO  o.a.catalina.core.StandardService serviceName="" reqId="" - Starting service [Tomcat]
12:24:39.011 [main] INFO  o.a.catalina.core.StandardEngine serviceName="" reqId="" - Starting Servlet engine: [Apache Tomcat/9.0.65]
12:24:39.552 [main] INFO  o.a.c.c.C.[Tomcat].[localhost].[/] serviceName="" reqId="" - Initializing Spring embedded WebApplicationContext
12:24:39.553 [main] INFO  o.s.b.w.s.c.ServletWebServerApplicationContext serviceName="" reqId="" - Root WebApplicationContext: initialization completed in 4803 ms
12:24:40.622 [main] INFO  o.s.b.w.e.tomcat.TomcatWebServer serviceName="" reqId="" - Tomcat started on port(s): 8080 (http) with context path ''
12:24:40.645 [main] INFO  in.das.app.DasJerseyAppApplication serviceName="" reqId="" - Started DasJerseyAppApplication in 7.926 seconds (JVM running for 11.883)
12:24:50.223 [http-nio-8080-exec-1] WARN  o.g.jersey.server.wadl.WadlFeature serviceName="" reqId="" - JAXBContext implementation could not be found. WADL feature is disabled.
12:24:51.809 [http-nio-8080-exec-1] INFO  in.das.app.logging.aop.ServiceAspect serviceName="TestResource.validateVoterAge" reqId="dev-123-456-789" - Entering Into :: className="VoterService" methodName="isVoterValid"
12:24:51.897 [http-nio-8080-exec-1] INFO  in.das.app.logging.aop.ServiceAspect serviceName="TestResource.validateVoterAge" reqId="dev-123-456-789" - Returning from className="VoterService" methodName="isVoterValid" Response=true totalTimeTakenInMs=65
12:24:51.951 [http-nio-8080-exec-1] INFO  i.d.a.l.f.ServerContainerResponseFilter serviceName="TestResource.validateVoterAge" reqId="dev-123-456-789" - url=http://localhost:8080/test/voter/validate httpMethod=POST Request-Headers:user-id:p45 x-auth-id:12345 content-length:87 accept-encoding:gzip, deflate, br accept:*/* user-agent:Thunder Client (https://www.thunderclient.com) requestid:dev-123-456-789 content-type:application/json host:localhost:8080 connection:close RequestPayload={
  "voterId" : "IND-191-145",
  "voterName": "cc xyz",
  "age" : 27,
  "state": "TS"
}  statusCode=200 Response-Headers:Content-Type:application/json x-provider:server-app-response ResponsePayload="Voter Valid"  totalExecutionTimeInMs=507
12:25:40.997 [http-nio-8080-exec-2] INFO  in.das.app.logging.aop.ServiceAspect serviceName="TestResource.validateVoterAge" reqId="69e58204-1a2a-442a-84a4-328613f52ef1" - Entering Into :: className="VoterService" methodName="isVoterValid"
12:25:41.001 [http-nio-8080-exec-2] INFO  in.das.app.logging.aop.ServiceAspect serviceName="TestResource.validateVoterAge" reqId="69e58204-1a2a-442a-84a4-328613f52ef1" - Returning from className="VoterService" methodName="isVoterValid" Response=true totalTimeTakenInMs=0
12:25:41.005 [http-nio-8080-exec-2] INFO  i.d.a.l.f.ServerContainerResponseFilter serviceName="TestResource.validateVoterAge" reqId="69e58204-1a2a-442a-84a4-328613f52ef1" - url=http://localhost:8080/test/voter/validate httpMethod=POST Request-Headers:user-id:p45 x-auth-id:12345 content-length:88 accept-encoding:gzip, deflate, br accept:*/* user-agent:Thunder Client (https://www.thunderclient.com) content-type:application/json host:localhost:8080 connection:close RequestPayload={
  "voterId" : "IND-785-145",
  "voterName": "mno xyz",
  "age" : 25,
  "state": "WB"
}  statusCode=200 Response-Headers:Content-Type:application/json x-provider:server-app-response ResponsePayload="Voter Valid"  totalExecutionTimeInMs=8
12:27:16.097 [http-nio-8080-exec-3] INFO  in.das.app.logging.aop.ServiceAspect serviceName="TestResource.validateVoterAge" reqId="52252554-cfc0-4848-a017-731786309dd9" - Entering Into :: className="VoterService" methodName="isVoterValid"
12:27:16.098 [http-nio-8080-exec-3] ERROR i.d.a.s.testservices.VoterService serviceName="TestResource.validateVoterAge" reqId="52252554-cfc0-4848-a017-731786309dd9" - [ERROR] Voter age less than 18
12:27:16.119 [http-nio-8080-exec-3] INFO  in.das.app.logging.aop.ServiceAspect serviceName="TestResource.validateVoterAge" reqId="52252554-cfc0-4848-a017-731786309dd9" - Exiting from "VoterService.isVoterValid" totalTimeTakenInMs=1
12:27:16.157 [http-nio-8080-exec-3] INFO  i.d.a.l.f.ServerContainerResponseFilter serviceName="TestResource.validateVoterAge" reqId="52252554-cfc0-4848-a017-731786309dd9" - url=http://localhost:8080/test/voter/validate httpMethod=POST Request-Headers:user-id:p45 x-auth-id:12345 content-length:88 accept-encoding:gzip, deflate, br accept:*/* user-agent:Thunder Client (https://www.thunderclient.com) content-type:application/json host:localhost:8080 connection:close RequestPayload={
  "voterId" : "IND-785-220",
  "voterName": "kkr xyz",
  "age" : 15,
  "state": "WB"
}  statusCode=500 Response-Headers:Content-Type:application/json x-provider:server-app-response ResponsePayload={"errorMessage":"Invalid Voter! Age less than 18","errorUUID":"5a62b915-71c4-4b49-9f2e-3289f5be898a"}  totalExecutionTimeInMs=62
12:29:28.722 [http-nio-8080-exec-4] INFO  in.das.app.resource.StudentResource serviceName="StudentResource.serverHealthCheck" reqId="08dd08be-223a-4e7c-b8ce-8df97d79b2d2" - Server up...
12:29:28.730 [http-nio-8080-exec-4] INFO  i.d.a.l.f.ServerContainerResponseFilter serviceName="StudentResource.serverHealthCheck" reqId="08dd08be-223a-4e7c-b8ce-8df97d79b2d2" - url=http://localhost:8080/student/_health httpMethod=GET Request-Headers:service-name:Health-check accept-encoding:gzip, deflate, br accept:*/* user-agent:Thunder Client (https://www.thunderclient.com) host:localhost:8080 connection:close  statusCode=200 Response-Headers:Content-Type:text/plain x-provider:server-app-response ResponsePayload="Ok Response"  totalExecutionTimeInMs=19
```

## Learnings
### Custom Exception response (ExceptionMapper)
__ExceptionMapper__ is a component in JAX-RS (Java API for REST-ful Web Services) that allows you to map exceptions to appropriate HTTP response codes. It is used to handle exceptions thrown during the execution of a REST-ful API and convert them into a specific HTTP response.  
Use `ExceptionMapper<T>` interface to create custom exception mappers. (T is the custom exception class)
```java
... implements ExceptionMapper<AgeValidationException>
... implements ExceptionMapper<StudentValidationException>
```

### WebClient & ExchangeFilterFunction (logging)
__WebClient__ is a reactive, non-blocking, and client-side HTTP client available in Spring WebFlux. It allows you to make HTTP requests in a functional and reactive way, and it supports both synchronous and asynchronous communication with the server.  
<br/>
__ExchangeFilterFunction__ is a functional interface in Spring WebFlux that allows you to apply custom logic to requests and responses being processed by the WebClient. An ExchangeFilterFunction can be used to add headers, modify the request body, or process the response before it is returned to the client. In this project they are used to log request and response for later debugging processes.  
_see: `in.das.app.connector.logging.LoggingFilter.java`_

#### ExchangeFilterFunction Logging output
```
13:05:40.337 [http-nio-8080-exec-1] INFO  i.d.app.connector.client.TodoClient serviceName="TodoResource.getTodoItem" reqId="2c4ae272-40c2-4773-82e2-52937ebb85d9" - fetching todo item...
13:05:40.756 [http-nio-8080-exec-1] INFO  i.d.a.c.logging.LoggingFilter serviceName="TodoResource.getTodoItem" reqId="2c4ae272-40c2-4773-82e2-52937ebb85d9" - Request url=https://jsonplaceholder.typicode.com/todos/5 headers={} body=org.springframework.web.reactive.function.BodyInserters$$Lambda$801/0x000000080113bd88@50d28764
13:05:46.189 [reactor-http-epoll-2] INFO  i.d.a.c.logging.LoggingFilter serviceName="" reqId="" - Response from url="https://jsonplaceholder.typicode.com/todos/5" status="200 OK" headers="{Transfer-Encoding=chunked, Server=cloudflare, CF-RAY=7941bb3d4bbb2e9f-HYD, X-Ratelimit-Remaining=998, X-Content-Type-Options=nosniff, Connection=keep-alive, Pragma=no-cache, Date=Sat, 04 Feb 2023 07:35:46 GMT, Via=1.1 vegur, X-Ratelimit-Reset=1675407103, X-Ratelimit-Limit=1000, CF-Cache-Status=REVALIDATED, Cache-Control=max-age=43200, Etag=W/"80-nIDrpgGIpb97HlRnMUJPolcZWGI", NEL={"success_fraction":0,"report_to":"cf-nel","max_age":604800}, Access-Control-Allow-Credentials=true, Report-To={"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=vzJqxSVhrzF9DciaY2fGV4XeeMrR6o92COjFqHlvLWR2inyzaHPe6EioQqh5WH9UdIbgOE6FvUW6qCbpjM%2BPc6EDlKWSZiiPKwDU%2FSmD6BDUjJjBCPzzCndO9lHZOzjFbpnd%2BbFg5NZp%2FCckWMZO"}],"group":"cf-nel","max_age":604800}, Vary=Origin, Accept-Encoding, Expires=-1, alt-svc=h3=":443"; ma=86400, h3-29=":443"; ma=86400, Content-Type=application/json; charset=utf-8, X-Powered-By=Express}" timeTaken="5380 ms"
```

### Issues Observed:
- No `serviceName` & `reqId` logged for `LoggingFilter` on receiving response. 
```
i.d.a.c.logging.LoggingFilter serviceName="" reqId=""
```

### Yet to Add:

- [ ] Swagger
- [X] Custom logging
- [X] Add unique reqIds for logging
- [X] DB (Mybatis)
- [ ] Mybatis SQL logging
- [ ] Caching
- [X] Docker containerize
