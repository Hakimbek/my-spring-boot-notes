# Spring Boot Dependency Management
Spring Boot manages dependencies and configuration automatically. Each release of Spring Boot provides a list of dependencies that it supports. The list of dependencies is available as a part of the Bills of Materials (spring-boot-dependencies) that can be used with Maven. So, we need not to specify the version of the dependencies in our configuration. Spring Boot manages itself. Spring Boot upgrades all dependencies automatically in a consistent way when we update the Spring Boot version.

## Advantages of Dependency Management
- It provides the centralization of dependency information by specifying the Spring Boot version in one place. It helps when we switch from one version to another.
- It avoids mismatch of different versions of Spring Boot libraries.
- We only need to write a library name with specifying the version. It is helpful in multi-module projects.

## Maven Dependency Management System
The Maven project inherits the following features from spring-boot-starter-parent:

- The default Java compiler version
- UTF-8 source encoding
- It inherits a Dependency Section from the spring-boot-dependency-pom. It manages the version of common dependencies. It ignores the `<version>` tag for that dependencies.
- Dependencies, inherited from the spring-boot-dependencies POM
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

> Note: In the above dependency, we have specified only the Spring Boot version. If we want to add additional starters, simply remove the `<version>` tag. Similarly, we can also override the individual dependency by overriding a property in our project.
  
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

> Note: It does not maintain the plugin management.

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

In the Spring Boot Framework, all the starters follow a similar naming pattern: **spring-boot-starter-`*`**, where `*` denotes a particular type of application. For example, if we want to use Spring and JPA for database access, we need to include the spring-boot-starter-data-jpa dependency in our pom.xml file of the project.

Third-Party Starters
We can also include third party starters in our project. But we do not use spring-boot-starter for including third party dependency. The spring-boot-starter is reserved for official Spring Boot artifacts. The third-party starter starts with the name of the project. For example, the third-party project name is abc, then the dependency name will be abc-spring-boot-starter.

The Spring Boot Framework provides the following application starters under the org.springframework.boot group.
