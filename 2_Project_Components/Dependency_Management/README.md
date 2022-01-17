# Spring Boot Dependency Management
Spring Boot manages dependencies and configuration automatically. Each release of Spring Boot provides a list of dependencies that it supports. The list of dependencies is available as a part of the Bills of Materials (spring-boot-dependencies) that can be used with Maven. So, we need not to specify the version of the dependencies in our configuration. Spring Boot manages itself. Spring Boot upgrades all dependencies automatically in a consistent way when we update the Spring Boot version.

## Advantages of Dependency Management
- It provides the centralization of dependency information by specifying the Spring Boot version in one place. It helps when we switch from one version to another.
- It avoids mismatch of different versions of Spring Boot libraries.
- We only need to write a library name with specifying the version. It is helpful in multi-module projects.

## Maven Dependency Management System
The Maven project inherits the following features from **spring-boot-starter-parent**:

- The default Java compiler version
- UTF-8 source encoding
- It inherits a Dependency Section from the **spring-boot-dependency-pom**. It manages the version of common dependencies. It ignores the `<version>` tag for that dependencies.
- Dependencies, inherited from the **spring-boot-dependencies** POM
- Sensible resource filtering
- Sensible plugin configuration

### Inheriting Starter Parent
The following **spring-boot-starter-parent** inherits automatically when we configure the project.

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.6.2</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

### Note
In the above dependency, we have specified only the Spring Boot version. If we want to add additional starters, simply remove the `<version>` tag. Similarly, we can also override the individual dependency by overriding a property in our project.
  
For example, if we want to add another dependency with the same artifact that we have injected already, inject that dependency again inside the `<properties>` tag to override the previous one.
  
### Changing the Java version
We can also change the Java version by using the `<java.version>` tag.

```xml
<properties>
    <java.version>11</java.version>
</properties>
```

### Adding Spring Boot Maven Plugin
We can also add Maven plugin in our **pom.xml** file. It wraps the project into an executable jar file.

```xml
<build>
   <plugins>
       <plugin>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-maven-plugin</artifactId>
       </plugin>
   </plugins>
</build>
```

### Spring Boot without Parent POM
If we don't want to use **spring-boot-starter-parent** dependency, but still want to take the advantage of the dependency management, we can use `<scope>` tag, as follows:

### Note
It does not maintain the plugin management.

```xml
<dependencyManagement>  
  <dependencies>  
    <dependency><!-- Import dependency management from Spring Boot -->  
      <groupId>org.springframework.boot</groupId>  
      <artifactId>spring-boot-dependencies</artifactId>  
      <version>2.2.2.RELEASE</version>  
      <type>pom</type>  
      <scope>import</scope>  
    </dependency>  
  </dependencies>  
</dependencyManagement>  
```

The above dependency does not allow overriding. To achieve the overriding, we need to add an entry inside the `<dependencyManagement>` tag of our project before the spring-boot-dependencies entry.

For example, to upgrade another **spring-data-releasetrain**, add the following dependency in the **pom.xml** file.

```xml
<dependencyManagement>  
  <dependencies>  
  <!--Override Spring Data release train-->  
    <dependency>  
      <groupId>org.springframework.data</groupId>  
      <artifactId>spring-data-releasetrain</artifactId>  
      <version>Fowler-SR2</version>  
      <type>pom</type>  
      <scope>import</scope>  
    </dependency>  
    
    <dependency>  
      <groupId>org.springframework.boot</groupId>  
      <artifactId>spring-boot-dependencies</artifactId>  
      <version>2.2.2.RELEASE</version>  
      <type>pom</type>  
      <scope>import</scope>  
    </dependency>  
  </dependencies>  
</dependencyManagement> 
```

# Spring Boot Application Properties
Spring Boot Framework comes with a built-in mechanism for application configuration using a file called **application.properties**. It is located inside the **src/main/resources** folder.

Spring Boot provides various properties that can be configured in the **application.properties** file. The properties have default values. We can set a property(s) for the Spring Boot application. Spring Boot also allows us to define our own property if required.

The application.properties file allows us to run an application in a different environment. In short, we can use the application.properties file to:

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

# Spring Boot Starters
Spring Boot provides a number of starters that allow us to add jars in the classpath. Spring Boot built-in starters make development easier and rapid. Spring Boot Starters are the dependency descriptors.

In the Spring Boot Framework, all the starters follow a similar naming pattern: spring-boot-starter-\*, where \* denotes a particular type of application. For example, if we want to use Spring and JPA for database access, we need to include the **spring-boot-starter-data-jpa** dependency in our pom.xml file of the project.

## Third-Party Starters
We can also include third party starters in our project. But we do not use **spring-boot-starter** for including third party dependency. The **spring-boot-starter** is reserved for official Spring Boot artifacts. The third-party starter starts with the name of the project. For example, the third-party project name is **abc**, then the dependency name will be **abc-spring-boot-starter**.

The Spring Boot Framework provides the following application starters under the **org.springframework.boot** group.

| Name | Description |
| ---- | ----------- |
| spring-boot-starter-thymeleaf | It is used to build MVC web applications using Thymeleaf views. |
| spring-boot-starter-data-couchbase | It is used for the Couchbase document-oriented database and Spring Data Couchbase. |
| spring-boot-starter-artemis | It is used for JMS messaging using Apache Artemis. |
| spring-boot-starter-web-services | It is used for Spring Web Services. |
| spring-boot-starter-mail | It is used to support Java Mail and Spring Framework's email sending. |
| spring-boot-starter-data-redis | It is used for Redis key-value data store with Spring Data Redis and the Jedis client. |
| spring-boot-starter-web | It is used for building the web application, including RESTful applications using Spring MVC. It uses Tomcat as the default embedded container. |
| spring-boot-starter-data-gemfire | It is used to GemFire distributed data store and Spring Data GemFire. |
| spring-boot-starter-activemq | It is used in JMS messaging using Apache ActiveMQ. |
| spring-boot-starter-data-elasticsearch | It is used in Elasticsearch search and analytics engine and Spring Data Elasticsearch. |
| spring-boot-starter-integration | It is used for Spring Integration. |
| spring-boot-starter-test | It is used to test Spring Boot applications with libraries, including JUnit, Hamcrest, and Mockito. |
| spring-boot-starter-jdbc | It is used for JDBC with the Tomcat JDBC connection pool. |
| spring-boot-starter-mobile | 	It is used for building web applications using Spring Mobile. |
| spring-boot-starter-validation | It is used for Java Bean Validation with Hibernate Validator. |
| spring-boot-starter-hateoas | It is used to build a hypermedia-based RESTful web application with Spring MVC and Spring HATEOAS. |
| spring-boot-starter-jersey | It is used to build RESTful web applications using JAX-RS and Jersey. An alternative to spring-boot-starter-web. |
| spring-boot-starter-data-neo4j | It is used for the Neo4j graph database and Spring Data Neo4j. |
| spring-boot-starter-data-ldap | It is used for Spring Data LDAP. |
| spring-boot-starter-websocket | It is used for building the WebSocket applications. It uses Spring Framework's WebSocket support. |
| spring-boot-starter-aop | It is used for aspect-oriented programming with Spring AOP and AspectJ. |
| spring-boot-starter-amqp | It is used for Spring AMQP and Rabbit MQ. |
| spring-boot-starter-data-cassandra | It is used for Cassandra distributed database and Spring Data Cassandra. |
| spring-boot-starter-social-facebook | It is used for Spring Social Facebook. |
| spring-boot-starter-jta-atomikos | It is used for JTA transactions using Atomikos. |
| spring-boot-starter-security | It is used for Spring Security. |
| spring-boot-starter-mustache | It is used for building MVC web applications using Mustache views. |
| spring-boot-starter-data-jpa | It is used for Spring Data JPA with Hibernate. |
| spring-boot-starter | It is used for core starter, including auto-configuration support, logging, and YAML. |
| spring-boot-starter-groovy-templates | It is used for building MVC web applications using Groovy Template views. |
| spring-boot-starter-freemarker | It is used for building MVC web applications using FreeMarker views. |
| spring-boot-starter-batch | It is used for Spring Batch. |
| spring-boot-starter-social-linkedin | It is used for Spring Social LinkedIn. |
| spring-boot-starter-cache | It is used for Spring Framework's caching support. |
| spring-boot-starter-data-solr | It is used for the Apache Solr search platform with Spring Data Solr. |
| spring-boot-starter-data-mongodb | It is used for MongoDB document-oriented database and Spring Data MongoDB. |
| spring-boot-starter-jooq | It is used for jOOQ to access SQL databases. An alternative to spring-boot-starter-data-jpa or spring-boot-starter-jdbc. |
| spring-boot-starter-jta-narayana | It is used for Spring Boot Narayana JTA Starter. |
| spring-boot-starter-cloud-connectors | It is used for Spring Cloud Connectors that simplifies connecting to services in cloud platforms like Cloud Foundry and Heroku. |
| spring-boot-starter-jta-bitronix | It is used for JTA transactions using Bitronix. |
| spring-boot-starter-social-twitter | It is used for Spring Social Twitter. |
| spring-boot-starter-data-rest | It is used for exposing Spring Data repositories over REST using Spring Data REST. |

### Spring Boot Production Starters
| Name | Description |
| ---- | ----------- |
| spring-boot-starter-actuator | It is used for Spring Boot's Actuator that provides production-ready features to help you monitor and manage your application. |
| spring-boot-starter-remote-shell | It is used for the CRaSH remote shell to monitor and manage your application over SSH. Deprecated since 1.5. |

### Spring Boot Technical Starters
| Name | Description |
| ---- | ----------- |
| spring-boot-starter-undertow | It is used for Undertow as the embedded servlet container. An alternative to spring-boot-starter-tomcat. |
| spring-boot-starter-jetty | It is used for Jetty as the embedded servlet container. An alternative to spring-boot-starter-tomcat. |
| spring-boot-starter-logging | It is used for logging using Logback. Default logging starter. |
| spring-boot-starter-tomcat | It is used for Tomcat as the embedded servlet container. Default servlet container starter used by spring-boot-starter-web. |
| spring-boot-starter-log4j2 | It is used for Log4j2 for logging. An alternative to spring-boot-starter-logging. |

# Spring Boot Starter Web
There are two important features of spring-boot-starter-web:

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

Starter of Spring web uses Spring MVC, REST and Tomcat as a default embedded server. The single spring-boot-starter-web dependency transitively pulls in all dependencies related to web development. It also reduces the build dependency count. The spring-boot-starter-web transitively depends on the following:

- org.springframework.boot:spring-boot-starter
- org.springframework.boot:spring-boot-starter-tomcat
- org.springframework.boot:spring-boot-starter-validation
- com.fasterxml.jackson.core:jackson-databind
- org.springframework:spring-web
- org.springframework:spring-webmvc

By default, the spring-boot-starter-web contains the following tomcat server dependency:

```xml
<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-tomcat</artifactId>  
        <version>latest-ver</version>  
        <scope>compile</scope>  
</dependency>  

The spring-boot-starter-web auto-configures the following things that are required for the web development:

- Dispatcher Servlet
- Error Page
- Web JARs for managing the static dependencies
- Embedded servlet container
```

## Spring Boot Embedded Web Server
Each Spring Boot application includes an embedded server. Embedded server is embedded as a part of deployable application. The advantage of embedded server is, we do not require pre-installed server in the environment. With Spring Boot, default embedded server is **Tomcat**. Spring Boot also supports another two embedded servers:

- **Jetty Server**
- **Undertow Server**

## Using another embedded web server
For servlet stack applications, the **spring-boot-starter-web** includes **Tomcat** by including **spring-boot-starter-tomcat**, but we can use **spring-boot-starter-jetty** or **spring-boot-starter-undertow** instead.

For reactive stack applications, the **spring-boot-starter-webflux** includes Reactor Netty by including **spring-boot-starter-reactor-netty**.

## Jetty Server
The Spring Boot also supports an embedded server called **Jetty Server**. It is an HTTP server and Servlet container that has the capability of serving static and dynamic content. It is used when machine to machine communication is required.

If we want to add the Jetty server in the application, we need to add the **spring-boot-starter-jetty** dependency in our **pom.xml** file.

**Remember: While using Jetty server in the application, make sure that the default Tomcat server is excluded from the spring-boot-starter-web. It avoids the conflict between servers.**

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

We can also customize the behavior of the Jetty server by using the **application.properties** file.

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

## Spring Data JPA
Spring Data is a high-level Spring Source project. Its purpose is to unify and easy access to the different kinds of persistence stores, both relational database systems, and NoSQL data stores.

When we implement a new application, we should focus on the business logic instead of technical complexity and boilerplate code. That's why the Java Persistent API (JPA) specification and Spring Data JPA are extremely popular.

Spring Data JPA adds a layer on the top of JPA. It means, Spring Data JPA uses all features defined by JPA specification, especially the entity, association mappings, and JPA's query capabilities. Spring Data JPA adds its own features such as the no-code implementation of the repository pattern and the creation of database queries from the method name.

### Spring Data JPA
Spring Data JPA handles most of the complexity of JDBC-based database access and ORM (Object Relational Mapping). It reduces the boilerplate code required by JPA. It makes the implementation of your persistence layer easier and faster.
Spring Data JPA aims to improve the implementation of data access layers by reducing the effort to the amount that is needed.

### Spring Data JPA Features
- **No-code repository:** It is the most popular persistence-related pattern. It enables us to implement our business code on a higher abstraction level.
- **Reduced boilerplate code:** It provides the default implementation for each method by its repository interfaces. It means that there is no longer need to implement read and write operations.
- **Generated Queries:** Another feature of Spring Data JPA is the generation of database queries based on the method name. If the query is not too complex, we need to define a method on our repository interface with the name that starts with findBy. After defining the method, Spring parses the method name and creates a query for it. For example:

```java
public interface EmployeeRepository extends CrudRepository<Employee, Long> {  
        Employee findByName(String name);  
}  
```

In the above example, we extend the CrudRepository that uses two generics: Employee and Long. The Employee is the entity that is to be managed, and Long is the data type of primary key

Spring internally generates a JPQL (Java Persistence Query Language) query based on the method name. The query is derived from the method signature. It sets the bind parameter value, execute the query, and returns the result.

There are some other features are as follows:

- It can integrate custom repository code.
- It is a powerful repository and custom object-mapping abstraction.
- It supports transparent auditing.
- It implements a domain base class that provides basic properties.
- It supports several modules such as Spring Data JPA, Spring Data MongoDB, Spring Data REST, Spring Data Cassandra, etc.

### Spring Data Repository
Spring Data JPA provides three repositories are as follows:
- **CrudRepository:** It offers standard create, read, update, and delete It contains method like findOne(), findAll(), save(), delete(), etc.
- **PagingAndSortingRepository:** It extends the CrudRepository and adds the findAll methods. It allows us to sort and retrieve the data in a paginated way.
- **JpaRepository:** It is a JPA specific repository It is defined in Spring Data Jpa. It extends the both repository CrudRepository and PagingAndSortingRepository. It adds the JPA-specific methods, like flush() to trigger a flush on the persistence context.

```xml
<dependency>  
        <groupId>org.springframework.data</groupId>  
        <artifactId>spring-data-jpa</artifactId>  
        <version>latest-ver</version>  
</dependency>  
```

### Spring Boot Starter Data JPA
Spring Boot provides spring-boot-starter-data-jpa dependency to connect Spring application with relational database efficiently. The spring-boot-starter-data-jpa internally uses the spring-boot-jpa dependency (since Spring Boot version 1.5.3).

```xml
<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-data-jpa</artifactId>  
        <version>latest-ver</version>  
</dependency>  
```

The databases are designed with tables/relations. Earlier approaches (JDBC) involved writing SQL queries.  In the JPA, we will store the data from objects into table and vice-versa. However, JPA evolved as a result of a different thought process.

Before JPA, ORM was the term more commonly used to refer to these frameworks. It is the reason Hibernate is called the ORM framework.

JPA allows us to map application classes to table in the database.

- **Entity Manager:** Once we define the mapping, it handles all the interactions with the database.
- **JPQL (Java Persistence Query Language):** It provides a way to write queries to execute searches against entities. It is different from the SQL queries. JPQL queries already understand the mapping that is defined between entities. We can add additional conditions if required.
- **Criteria API:** It defines a Java-based API to execute searches against the database.

### Hibernate vs. JPA
Hibernate is the implementation of JPA. It is the most popular ORM framework, while JPA is an API that defines the specification. Hibernate understands the mapping that we add between objects and tables. It ensures that data is retrieved/ stored from the database based on the mapping. It also provides additional features on the top of the JPA.

## Spring Boot Actuator
Spring Boot Actuator is a sub-project of the Spring Boot Framework. It includes a number of additional features that help us to monitor and manage the Spring Boot application. It contains the actuator endpoints (the place where the resources live). We can use HTTP and JMX endpoints to manage and monitor the Spring Boot application. If we want to get production-ready features in an application, we should use the Spring Boot actuator.

### Spring Boot Actuator Features
- Endpoints
- Metrics
- Audit

### Endpoint
The actuator endpoints allows us to monitor and interact with the application. Spring Boot provides a number of built-in endpoints. We can also create our own endpoint. We can enable and disable each endpoint individually. Most of the application choose HTTP, where the Id of the endpoint, along with the prefix of /actuator, is mapped to a URL.

For example, the /health endpoint provides the basic health information of an application. The actuator, by default, mapped it to /actuator/health.  

### Metrics
Spring Boot Actuator provides dimensional metrics by integrating with the micrometer. The micrometer is integrated into Spring Boot. It is the instrumentation library powering the delivery of application metrics from Spring. It provides vendor-neutral interfaces for timers, gauges, counters, distribution summaries, and long task timers with a dimensional data model.

### Audit
Spring Boot provides a flexible audit framework that publishes events to an AuditEventRepository. It automatically publishes the authentication events if spring-security is in execution.

### Enabling Spring Boot Actuator
We can enable actuator by injecting the dependency spring-boot-starter-actuator in the pom.xml file.

```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-actuator</artifactId>  
    <version>latest-ver</version>  
</dependency>  
```

### Spring Boot actuator properties
Spring Boot enables security for all actuator endpoints. It uses form-based authentication that provides user Id as the user and a randomly generated password. We can also access actuator-restricted endpoints by customizing basicauth security to the endpoints. We need to override this configuration by management.security.roles property. For example:

```properties
management.security.enabled=true  
management.security.roles=ADMIN  
security.basic.enabled=true  
security.user.name=admin  
security.user.passowrd=admin  
```

## Spring Boot Starter Test
The spring-boot-starter-test is the primary dependency for the test. It contains the majority of elements required for our tests.

There are several different types of tests that we can write to help test and automate the health of an application. Before starting any testing, we need to integrate the testing framework.

With Spring Boot, we need to add starter to our project, for testing we only need to add the spring-boot-starter-test dependency.

```xml
<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-test</artifactId>  
        <version>latest-ver</version>  
        <scope>test</scope>  
</dependency>  
```

It pulls all the dependencies related to test. After adding it, we can build up a simple unit test. We can either create the Spring Boot project through IDE or generate it using Spring Initializr.

> Note: If you are adding test dependency manually, add it to the bottom of the pom.xml file.

In the above dependency, one thing to be noticed that it includes the scope of test <scope>test</scope>. It means when the application is bundled and packaged for deployment, any dependency that is declared with the test scopes is ignored. The test scope dependencies are only available when running in the development and Maven test modes.

When we create a simple Spring Boot application, by default, it contains the test dependency in the pom.xml file and ApplicationNameTest.java file under in the folder src/test/java.

## Spring Boot DevTools
Spring Boot 1.3 provides another module called Spring Boot DevTools. DevTools stands for Developer Tool. The aim of the module is to try and improve the development time while working with the Spring Boot application. Spring Boot DevTools pick up the changes and restart the application.

We can implement the DevTools in our project by adding the following dependency in the pom.xml file.

```xml
<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-devtools</artifactId>  
        <scope>runtime<scope >  
</dependency>  
```

### Spring Boot DevTools Features

### Property Defaults
Spring Boot provides templating technology Thymeleaf that contains the property spring.thymeleaf.cache. It disables the caching and allows us to update pages without the need of restarting the application. But setting up these properties during the development always creates some problems.

When we use the spring-boot-devtools module, we are not required to set properties. During the development caching for Thymeleaf, Freemarker, Groovy Templates are automatically disabled.

> Note: If we do not want to apply property defaults on an application, we can set configprop:spring.devtools.add-properties to false in the application.properties file.

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
