# Spring Boot Starter Web
There are two important features of **spring-boot-starter-web**:

It is compatible for web development
- Auto configuration
- If we want to develop a web application, we need to add the following dependency in **pom.xml** file:

```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-web</artifactId>  
    <version>latest-ver</version>  
</dependency>  
```

Starter of Spring web uses **Spring MVC, REST** and **Tomcat** as a default embedded server. The single **spring-boot-starter-web** dependency transitively pulls in all dependencies related to web development. It also reduces the build dependency count. The **spring-boot-starter-web** transitively depends on the following:

- org.springframework.boot:spring-boot-starter
- org.springframework.boot:spring-boot-starter-tomcat
- org.springframework.boot:spring-boot-starter-validation
- com.fasterxml.jackson.core:jackson-databind
- org.springframework:spring-web
- org.springframework:spring-webmvc

By default, the **spring-boot-starter-web** contains the following tomcat server dependency:

```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-tomcat</artifactId>  
    <version>latest-ver</version>  
    <scope>compile</scope>  
</dependency>
```

The **spring-boot-starter-web** auto-configures the following things that are required for the web development:

- Dispatcher Servlet
- Error Page
- Web JARs for managing the static dependencies
- Embedded servlet container

## Spring Boot Embedded Web Server
Each Spring Boot application includes an embedded server. Embedded server is embedded as a part of deployable application. The advantage of embedded server is, we do not require pre-installed server in the environment. With Spring Boot, default embedded server is **Tomcat**. Spring Boot also supports another two embedded servers:

- **Jetty Server**
- **Undertow Server**

## Using another embedded web server
For servlet stack applications, the **spring-boot-starter-web** includes **Tomcat** by including **spring-boot-starter-tomcat**, but we can use **spring-boot-starter-jetty** or **spring-boot-starter-undertow** instead.

For reactive stack applications, the **spring-boot-starter-webflux** includes Reactor Netty by including **spring-boot-starter-reactor-netty**.

## Jetty Server
The Spring Boot also supports an embedded server called **Jetty Server**. It is an HTTP server and Servlet container that has the capability of serving static and dynamic content. It is used when machine to machine communication is required.

If we want to add the **Jetty** server in the application, we need to add the **spring-boot-starter-jetty** dependency in our **pom.xml** file.

### Remember
While using **Jetty** server in the application, make sure that the default **Tomcat** server is excluded from the **spring-boot-starter-web**. It avoids the conflict between servers.

```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-web</artifactId>  
    <exclusions>  
            <exclusion>  
                    <groupId>org.springframework.boot</groupId>  
                    <artifactId>spring-boot-starter-tomcat</artifactId>  
            </exclusion>  
    </exclusions>  
</dependency>

<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-jetty</artifactId>  
</dependency>  
```

We can also customize the behavior of the **Jetty** server by using the **application.properties** file.

## Undertow Server
Spring Boot provides another server called Undertow. It is also an embedded web server like **Jetty**. It is written in Java and manage and sponsored by **JBoss**. The main advantages of Undertow server are:

- Supports HTTP/2
- HTTP upgrade support
- Websocket Support
- Provides support for Servlet 4.0
- Flexible
- Embeddable

**Remember: While using Undertow server in the application, make sure that the default Tomcat server is excluded from the spring-boot-starter-web. It avoids the conflict between servers.**

```xml
<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-web</artifactId>  
        <exclusions>  
                <exclusion>  
                        <groupId>org.springframework.boot</groupId>  
                        <artifactId>spring-boot-starter-tomcat</artifactId>  
                </exclusion>  
        </exclusions>  
</dependency>  

<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-undertow</artifactId>  
</dependency>  
```

We can also customize the behavior of the Jetty server by using the **application.properties** file.

## spring-boot-starter-web vs. spring-boot-starter-tomcat
The **spring-boot-starter-web** contains the spring web dependencies that includes **spring-boot-starter-tomcat**. The **spring-boot-starter-web** contains the following:

- spring-boot-starter
- jackson
- spring-core
- spring-mvc
- spring-boot-starter-tomcat

While the **spring-boot-starter-tomcat** contains everything related to Tomcat server.

- core
- el
- logging
- websocket

The starter-tomcat has the following dependencies:

```xml
<dependency>  
        <groupId>org.apache.tomcat.embed</groupId>  
        <artifactId>tomcat-embed-core</artifactId>  
        <version>8.5.23</version>  
        <scope>compile</scope>  
</dependency>

<dependency>  
        <groupId>org.apache.tomcat.embed</groupId>  
        <artifactId>tomcat-embed-el</artifactId>  
        <version>8.5.23</version>  
        <scope>compile</scope>  
</dependency>  

<dependency>  
        <groupId>org.apache.tomcat.embed</groupId>  
        <artifactId>tomcat-embed-websocket</artifactId>  
        <version>8.5.23</version>  
        <scope>compile</scope>  
</dependency>  
```

We can also use **spring-mvc** without using the embedded Tomcat server. If we want to do so, we need to exclude the Tomcat server by using the `<exclusion>` tag, as shown in the following code.

```xml
<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-web</artifactId>  
        <exclusions>  
                <exclusion>  
                        <groupId>org.springframework.boot</groupId>  
                        <artifactId>spring-boot-starter-tomcat</artifactId>  
                </exclusion>  
        </exclusions>  
</dependency>  
```
