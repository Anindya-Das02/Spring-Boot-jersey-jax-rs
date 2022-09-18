# Spring-Boot-jersey-jax-rs

### Concepts:
JAX-RS, Spring AOP, Custom Runtime Exceptions, Filters (ServerContainers)  

### Problems (Yet to resolve)

- Spring AOP (Aspect) logging is not working with JAX-RS. [possible fix](https://stackoverflow.com/questions/25209339/spring-aspectj-weaving-for-java-8-using-aspectj-maven-plugin)

### Console Logs
```
2022-09-18 17:46:22.476  INFO 2536 --- [nio-8080-exec-1] in.das.app.resource.StudentResource      : Inside student add service
2022-09-18 17:46:22.477  INFO 2536 --- [nio-8080-exec-1] i.d.app.service.student.StudentService   : student add success!
2022-09-18 17:46:22.548  INFO 2536 --- [nio-8080-exec-1] i.d.a.l.f.ServerContainerResponseFilter  : url=http://localhost:8080/student/add httpMethod=POST Request-Headers:user-agent:Thunder Client (https://www.thunderclient.com) accept:*/* user-id:p45 x-auth-id:12345 content-type:application/json content-length:56 accept-encoding:gzip, deflate, br host:localhost:8080 connection:close RequestPayload={
  "name": "mmm",
  "id": 23,
  "courseType": "BTECH"
}  statusCode=200 Response-Headers:Content-Type:application/json x-provider:server-app-response ResponsePayload={"status":"success","message":"student added"}  totalExecutionTimeInMs=481
```

### Yet to Add:

- [ ] Swagger
- [ ] Custom logging
- [ ] Add unique reqIds for logging
- [ ] DB (Mybatis)
- [ ] Caching
- [ ] Docker containerize