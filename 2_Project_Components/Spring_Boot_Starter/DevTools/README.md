# Spring Boot DevTools
Spring Boot 1.3 provides another module called Spring Boot DevTools. DevTools stands for Developer Tool. The aim of the module is to try and improve the development time while working with the Spring Boot application. Spring Boot DevTools pick up the changes and restart the application.

We can implement the DevTools in our project by adding the following dependency in the pom.xml file.

```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-devtools</artifactId>  
    <scope>runtime<scope >  
</dependency>  
```

## Spring Boot DevTools Features

### Property Defaults
Spring Boot provides templating technology Thymeleaf that contains the property **spring.thymeleaf.cache**. It disables the caching and allows us to update pages without the need of restarting the application. But setting up these properties during the development always creates some problems.

When we use the **spring-boot-devtools** module, we are not required to set properties. During the development caching for Thymeleaf, Freemarker, Groovy Templates are automatically disabled.

> Note: If we do not want to apply property defaults on an application, we can set **configprop:spring.devtools.add-properties** to false in the **application.properties** file.

### Automatic Restart
Auto-restart means reloading of Java classes and configure it at the server-side. After the server-side changes, it deployed dynamically, server restarts happen, and load the modified code. It is mostly used in microservice-based applications. Spring Boot uses two types of ClassLoaders:

- The classes that do not change (third-Jars) are loaded in the base ClassLoader.
- The classes that we are actively developing are loaded in the restart ClassLoader.
- 
When the application restarts, the restart ClassLoader is thrown away, and a new one is populated. Therefore, the base ClassLoader is always available and populated.

### Remember:
- The DevTools always monitors the classpath resources.
- There is only a way to trigger a restart is to update the classpath.
- DevTools required a separate application classloader to work properly. By default, Maven fork the application process.
- Auto-restart works well with LiveReload.
- DevTools depends on the application context's shutdown hook to close it during the restart.

### LiveReload
The Spring Boot DevTools module includes an embedded server called LiveReload. It allows the application to automictically trigger a browser refresh whenever we make changes in the resources. It is also known as auto-refresh.

> Note: We can disable the LiveReload by setting the property spring.devtools.livereload.enabled to false.

It provides browser extensions for Chrome, Firefox, and Safari. By default, LiveReload is enabled. The LiveReload works on the following path:

- /META-INF/maven
- /META-INF/resources
- /resources
- /static
- /public
- /templates
- 
We can also disable auto-reload in browser by excluding the above paths. For example:

We can disable the auto-restart of a server by using the property spring.devtools.restart.enabled to false.

```properties
spring.devtools.restart.exclude=public/**, static/**, templates/**  
```

We can see the other additional path by using the property spring.devtools.restart.additional-paths. For example:

```properties
spring.devtools.restart.additional-paths=/path-to-folder  
```

If we want to exclude additional path and want to keep defaults then use the property spring.devtools.restart.additional-exclude. For example:

```properties
spring.devtools.restart.additional-exclude=styles/**  
```

### Remember
- We can run one LiveReload server at a time.
- Before starting the application, ensure that no other LiveReload server is running.
- If we start multiple applications from IDE, it supports only the first LiveReload.

### Remote Debug Tunneling
Spring Boot can tunnel JDWP (Java Debug Wire Protocol) over HTTP directly to the application. It can even work application deployment to Internet Cloud providers that only expose port 80 and 443.

Remote Update and Restart: There is another trick that DevTools offers is: it supports remote application updates and restarts. It monitors local classpath for file changes and pushes them to a remote server, which is then restarted. We can also use this feature in combination with LiveReload.

### Using a Trigger File
Automatic restart sometimes can slow down development time due to frequent restarts. To remove this problem, we can use a trigger file. Spring Boot monitors trigger file and detects modifications in that file. It restarts the server and reloads all previous changes.

We can implement the trigger file in our application by adding the property spring.devtools.restart.trigger-file. The file can be internal or external. For example:

```properties
spring.devtools.restart.trigger-file=c:/workspace-sts-3.9.9.RELEASE/restart-trigger.txt  
```
