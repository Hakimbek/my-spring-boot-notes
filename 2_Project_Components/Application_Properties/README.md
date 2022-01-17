# Spring Boot Application Properties
Spring Boot Framework comes with a built-in mechanism for application configuration using a file called **application.properties**. It is located inside the **src/main/resources** folder.

Spring Boot provides various properties that can be configured in the **application.properties** file. The properties have default values. We can set a property(s) for the Spring Boot application. Spring Boot also allows us to define our own property if required.

The **application.properties** file allows us to run an application in a different environment. In short, we can use the application.properties file to:

- Configure the Spring Boot framework
- define our application custom configuration properties

```properties
#configuring application name  
spring.application.name = demoApplication  
#configuring port  
server.port = 8081  
```

In the above example, we have configured the application name and port. The port 8081 denotes that the application runs on port 8081.

> Note: The lines started with # are comments.

### YAML Properties File

Spring Boot provides another file to configure the properties is called **yml** file. The Yaml file works because the Snake YAML jar is present in the classpath. Instead of using the **application.properties** file, we can also use the **application.yml** file, but the Yml file should be present in the classpath.

```yml
spring:  
application:  
name: demoApplication  
server:  
port: 8081  
```

In the above example, we have configured the application name and port. The port 8081 denotes that the application runs on port 8081.

### Spring Boot Property Categories
There are sixteen categories of Spring Boot Property are as follows:

1. Core Properties
2. Cache Properties
3. Mail Properties
4. JSON Properties
5. Data Properties
6. Transaction Properties
7. Data Migration Properties
8. Integration Properties
9. Web Properties
10. Templating Properties
11. Server Properties
12. Security Properties
13. RSocket Properties
14. Actuator Properties
15. DevTools Properties
16. Testing Properties
