# Spring Boot Actuator
Spring Boot Actuator is a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to monitor and manage the Spring Boot application. It contains the actuator endpoints (the place where the resources live). We can use HTTP and JMX endpoints to manage and monitor the Spring Boot application. If we want to get production-ready features in an application, we should use the Spring Boot actuator.

### Spring Boot Actuator Features
- Endpoints
- Metrics
- Audit

### Endpoint
The actuator endpoints allows us to monitor and interact with the application. Spring Boot provides a number of built-in endpoints. We can also create our own endpoint. We can enable and disable each endpoint individually. Most of the application choose HTTP, where the Id of the endpoint, along with the prefix of /actuator, is mapped to a URL.

For example, the /health endpoint provides the basic health information of an application. The actuator, by default, mapped it to /actuator/health.  

### Metrics
Spring Boot Actuator provides dimensional metrics by integrating with the micrometer. The micrometer is integrated into Spring Boot. It is the instrumentation library powering the delivery of application metrics from Spring. It provides vendor-neutral interfaces for timers, gauges, counters, distribution summaries and long task timers with a dimensional data model.

### Audit
Spring Boot provides a flexible audit framework that publishes events to an **AuditEventRepository**. It automatically publishes the authentication events if **spring-security** is in execution.

### Enabling Spring Boot Actuator
We can enable actuator by injecting the dependency spring-boot-starter-actuator in the pom.xml file.

```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-actuator</artifactId>  
    <version>latest-ver</version>  
</dependency>  
```

## Spring Boot Actuator Endpoints
The actuator endpoints allow us to monitor and interact with our Spring Boot application. Spring Boot includes number of built-in endpoints and we can also add custom endpoints in Spring Boot application.

| Id | Usage | Default |
| -- | ----- | ------- |
| actuator | It provides a hypermedia-based discovery page for the other endpoints. It requires Spring HATEOAS to be on the classpath. | True |
| auditevents |	It exposes audit events information for the current application. | True |
| autoconfig | It is used to display an auto-configuration report showing all auto-configuration candidates and the reason why they 'were' or 'were not' applied. |	True |
| beans | It is used to display a complete list of all the Spring beans in your application. | True |
| configprops |	It is used to display a collated list of all **@ConfigurationProperties**. | True |
| dump | It is used to perform a thread dump. | True |
| env |	It is used to expose properties from Spring's ConfigurableEnvironment. | True |
| flyway | It is used to show any Flyway database migrations that have been applied. | True |
| health | It is used to show application health information. |	False |
| info | It is used to display arbitrary application info. | False |
| loggers |	It is used to show and modify the configuration of loggers in the application. | True |
| liquibase | It is used to show any Liquibase database migrations that have been applied. | True |
| metrics |	It is used to show metrics information for the current application. | True |
| mappings | It is used to display a collated list of all @RequestMapping paths. |True |
| shutdown | It is used to allow the application to be gracefully shutdown. | True |
| trace | It is used to display trace information. | True |

## Spring Boot actuator properties
Spring Boot enables security for all actuator endpoints. It uses form-based authentication that provides user Id as the user and a randomly generated password. We can also access actuator-restricted endpoints by customizing basicauth security to the endpoints. We need to override this configuration by management.security.roles property. For example:

```properties
management.security.enabled=true  
management.security.roles=ADMIN  
security.basic.enabled=true  
security.user.name=admin  
security.user.passowrd=admin  
```
