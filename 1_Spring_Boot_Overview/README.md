# Spring Boot 
Spring Boot is a Spring module that provides the **RAD (Rapid Application Development)** feature to the Spring framework.

## What is Spring Boot
Spring Boot is a project that is built on the top of the **Spring Framework**. It provides an easier and faster way to set up, configure and run both simple and web-based applications.
It is a Spring module that provides the **RAD (Rapid Application Development)** feature to the Spring Framework. It is used to create a stand-alone Spring-based application that you can just run because it needs minimal Spring configuration.

In short, Spring Boot is the combination of **Spring Framework** and **Embedded Servers**.

In Spring Boot, there is no requirement for **XML configuration (deployment descriptor)**. It uses convention over configuration software design paradigm that means it decreases the effort of the developer.

### Why should we use Spring Boot Framework?

- The dependency injection approach is used in Spring Boot.
- It contains powerful database transaction management capabilities.
- It simplifies integration with other Java frameworks like **JPA/Hibernate ORM, Struts, etc**.
- It reduces the cost and development time of the application.

Along with the Spring Boot Framework, many other Spring sister projects help to build applications addressing modern business needs. There are the following Spring sister projects are as follows:

- **Spring Data:** It simplifies data access from the **relational** and **NoSQL databases**.
- **Spring Batch:** It provides powerful batch processing.
- **Spring Security:** It is a security framework that provides robust security to applications.
- **Spring Social:** It supports integration with social networking like **LinkedIn**.
- **Spring Integration:** It is an implementation of **Enterprise Integration Patterns**. It facilitates integration with other enterprise applications using lightweight messaging and declarative adapters.

### Advantages of Spring Boot
- It creates stand-alone Spring applications that can be started using Java -jar.
- It tests web applications easily with the help of different Embedded HTTP servers such as **Tomcat, Jetty, etc**. We don't need to deploy WAR files.
- It provides opinionated **'starter' POMs** to simplify our **Maven** configuration.
- It provides production-ready features such as metrics, health checks, and externalized configuration.
- There is no requirement for XML configuration.
- It offers a CLI tool for developing and testing the Spring Boot application.
- It offers the number of plug-ins.
- It also minimizes writing multiple boilerplate codes (the code that has to be included in many places with little or no alteration), XML configuration, and annotations.
- It increases productivity and reduces development time.

### Limitations of Spring Boot
- Spring Boot can use dependencies that are not going to be used in the application. These dependencies increase the size of the application.

## Goals of Spring Boot
The main goal of Spring Boot is to reduce development, unit test and integration test time.

- Provides Opinionated Development approach
- Avoids defining more Annotation Configuration
- Avoids writing lots of import statements
- Avoids XML Configuration.

By providing or avoiding the above points, Spring Boot Framework reduces Development time, Developer Effort, and increases productivity.

# Spring Boot Features

### Web Development
It is a well-suited Spring module for web application development. We can easily create a self-contained HTTP application that uses embedded servers like Tomcat, Jetty or Undertow. We can use the **spring-boot-starter-web** module to start and run the application quickly.

### SpringApplication
The SpringApplication is a class that provides a convenient way to bootstrap a Spring application. It can be started from the **main** method. We can call the application just by calling a static **run()** method.

```java
public static void main(String[] args) {    
  SpringApplication.run(ClassName.class, args);    
}  
```

### Application Events and Listeners
Spring Boot uses events to handle the variety of tasks. It allows us to create factories file that is used to add listeners. We can refer it to using the **ApplicationListener** key.
Always create factories file in **META-INF** folder like **META-INF/spring.factories**.

### Admin Support
Spring Boot provides the facility to enable admin-related features for the application. It is used to access and manage applications remotely. We can enable it in the Spring Boot application by using **spring.application.admin.enabled** property.

### Externalized Configuration
Spring Boot allows us to externalize our configuration so that we can work with the same application in different environments. The application uses **YAML** files to externalize configuration.

### Properties Files
Spring Boot provides a rich set of Application Properties. So, we can use that in the properties file of our project. The properties file is used to set properties like **server-port=8082** and many others. It helps to organize application properties.

### YAML Support
It provides a convenient way of specifying the hierarchical configuration. It is a superset of **JSON**. The **SpringApplication** class automatically supports **YAML**. It is an alternative of properties file.

### Type-safe Configuration
The strong type-safe configuration is provided to govern and validate the configuration of the application. Application configuration is always a crucial task which should be type-safe. We can also use annotation provided by this library.

### Logging
Spring Boot uses Common logging for all internal logging. Logging dependencies are managed by default. We should not change logging dependencies if no customization is needed.

### Security
Spring Boot applications are spring bases web applications. So, it is secure by default with basic authentication on all HTTP endpoints. A rich set of Endpoints is available to develop a secure Spring Boot application.

# Spring vs. Spring Boot
### Spring 
Spring Framework is the most popular application development framework of Java. The main feature of the Spring Framework is **dependency Injection** or **Inversion of Control (IoC)**. With the help of Spring Framework, we can develop a loosely coupled application. It is better to use if application type or characteristics are purely defined.

### Spring Boot
Spring Boot is a module of Spring Framework. It allows us to build a stand-alone application with minimal or zero configurations. It is better to use if we want to develop a simple Spring-based application or **RESTful** services.

| Spring | Spring Boot |
| ------ | ----------- |
| Spring Framework is a widely used Java EE framework for building applications. | Spring Boot Framework is widely used to develop REST APIs. |
| It aims to simplify Java EE development that makes developers more productive. | It aims to shorten the code length and provide the easiest way to develop Web Applications. |
| The primary feature of the Spring Framework is dependency injection. | The primary feature of Spring Boot is **Autoconfiguration.** It automatically configures the classes based on the requirement. |
| It helps to make things simpler by allowing us to develop loosely coupled applications. |	It helps to create a stand-alone application with less configuration. |
| The developer writes a lot of code (boilerplate code) to do the minimal task. |	It reduces boilerplate code. |
| To test the Spring project, we need to set up the sever explicitly. |	Spring Boot offers embedded server such as **Jetty** and **Tomcat, etc**. |
| It does not provide support for an in-memory database. | It offers several plugins for working with an embedded and in-memory database such as **H2**. |
| Developers manually define dependencies for the Spring project in **pom.xml**. |Spring Boot comes with the concept of starter in **pom.xml** file that internally takes care of downloading the dependencies JARs based on Spring Boot Requirement. |


# Spring Boot vs. Spring MVC
### Spring Boot
Spring Boot makes it easy to quickly bootstrap and start developing a Spring-based application. It avoids a lot of boilerplate code. It hides a lot of complexity behind the scene so that the developer can quickly get started and develop Spring-based applications easily.

### Spring MVC
Spring MVC is a Web MVC Framework for building web applications. It contains a lot of configuration files for various capabilities. It is an HTTP oriented web application development framework.

| Spring Boot |	Spring MVC |
| ----------- | ---------- |
| Spring Boot is a module of Spring for packaging the Spring-based application with sensible defaults. | Spring MVC is a model view controller-based web framework under the Spring framework. |
| It provides default configurations to build Spring-powered framework. |	It provides ready to use features for building a web application. |
| There is no need to build configuration manually. |	It requires build configuration manually. |
| There is no requirement for a deployment descriptor. | A Deployment descriptor is required. |
| It avoids boilerplate code and wraps dependencies together in a single unit. | It specifies each dependency separately. |
| It reduces development time and increases productivity. |	It takes more time to achieve the same. |

# Spring Boot Architecture
Spring Boot is a module of the Spring Framework. It is used to create stand-alone, production-grade Spring Based Applications with minimum efforts. It is developed on top of the core Spring Framework.

Spring Boot follows a layered architecture in which each layer communicates with the layer directly below or above (hierarchical structure) it.

Before understanding the Spring Boot Architecture, we must know the different layers and classes present in it. There are four layers in Spring Boot are as follows:

### Presentation Layer
The presentation layer handles the HTTP requests, translates the JSON parameter to object and authenticates the request and transfer it to the business layer. In short, it consists of views i.e., frontend part.
- Authentication
- JSON Translation 

### Business Layer
The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers. It also performs authorization and validation.
- Bisness Logic
- Validation
- Authorisation

### Persistence Layer
The persistence layer contains all the storage logic and translates business objects from and to database rows.
- Storage Logic

### Database Layer
In the database layer, CRUD (create, retrieve, update, delete) operations are performed.
- Actual Dtabase

