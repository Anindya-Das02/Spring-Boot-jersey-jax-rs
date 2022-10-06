# Spring-Boot-jersey-jax-rs

### Run using Docker:
```
$ sudo docker pull anindyad3v/springboot-template-jersey-jaxrs
$ sudo docker run -d -p <your_host>:8080 <container_id>
```

### Concepts:
JAX-RS, REST apis, Spring AOP (Aspect), slf4j logging, Custom Runtime Exceptions, Filters (ServerContainers)  

### Console Logs
```
2022-09-26 23:34:20.611  INFO 1148 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-09-26 23:34:20.637  INFO 1148 --- [           main] in.das.app.DasJerseyAppApplication       : Started DasJerseyAppApplication in 5.608 seconds (JVM running for 7.349)
2022-09-26 23:35:16.422  WARN 1148 --- [nio-8080-exec-1] o.g.jersey.server.wadl.WadlFeature       : JAXBContext implementation could not be found. WADL feature is disabled.
2022-09-26 23:35:17.629  INFO 1148 --- [nio-8080-exec-1] in.das.app.resource.StudentResource      : Inside student add service
2022-09-26 23:35:17.643  INFO 1148 --- [nio-8080-exec-1] in.das.app.logging.aop.ServiceAspect     : Entering Into :: className="StudentService" methodName="addStudentService"
2022-09-26 23:35:17.696  INFO 1148 --- [nio-8080-exec-1] i.d.app.service.student.StudentService   : student add success!
2022-09-26 23:35:17.725  INFO 1148 --- [nio-8080-exec-1] in.das.app.logging.aop.ServiceAspect     : Returning from className="StudentService" methodName="addStudentService" Response={"status":"success","message":"student added"} totalTimeTakenInMs=52
2022-09-26 23:35:17.747  INFO 1148 --- [nio-8080-exec-1] i.d.a.l.f.ServerContainerResponseFilter  : url=http://localhost:8080/student/add httpMethod=POST Request-Headers:user-id:p45 x-auth-id:12345 content-length:56 accept-encoding:gzip, deflate, br accept:*/* user-agent:Thunder Client (https://www.thunderclient.com) content-type:application/json host:localhost:8080 connection:close RequestPayload={
  "name": "ggg",
  "id": 21,
  "courseType": "BTECH"
}  statusCode=200 Response-Headers:Content-Type:application/json x-provider:server-app-response ResponsePayload={"status":"success","message":"student added"}  totalExecutionTimeInMs=371
2022-09-26 23:35:27.187  INFO 1148 --- [nio-8080-exec-2] in.das.app.resource.StudentResource      : Inside student add service
2022-09-26 23:35:27.188  INFO 1148 --- [nio-8080-exec-2] in.das.app.logging.aop.ServiceAspect     : Entering Into :: className="StudentService" methodName="addStudentService"
2022-09-26 23:35:27.188 ERROR 1148 --- [nio-8080-exec-2] i.d.app.service.student.StudentService   : banned student name=xxx
2022-09-26 23:35:27.215  INFO 1148 --- [nio-8080-exec-2] in.das.app.logging.aop.ServiceAspect     : Exiting from "StudentService.addStudentService" totalTimeTakenInMs=3
2022-09-26 23:35:27.227  INFO 1148 --- [nio-8080-exec-2] i.d.a.l.f.ServerContainerResponseFilter  : url=http://localhost:8080/student/add httpMethod=POST Request-Headers:user-id:p45 x-auth-id:12345 content-length:56 accept-encoding:gzip, deflate, br accept:*/* user-agent:Thunder Client (https://www.thunderclient.com) content-type:application/json host:localhost:8080 connection:close RequestPayload={
  "name": "xxx",
  "id": 23,
  "courseType": "BTECH"
}  statusCode=400 Response-Headers:Content-Type:application/json x-provider:server-app-response ResponsePayload={"message":"Banned Student","status":"error","uuid":"a6cb4291-f25c-4524-b84c-fae32f3072e5"}  totalExecutionTimeInMs=41
```

### Yet to Add:

- [ ] Swagger
- [ ] Custom logging
- [ ] Add unique reqIds for logging
- [ ] DB (Mybatis)
- [ ] Caching
- [ ] Docker containerize
