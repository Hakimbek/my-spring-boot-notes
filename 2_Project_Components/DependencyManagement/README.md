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
- It inherits a Dependency Section from the spring-boot-dependency-pom. It manages the version of common dependencies. It ignores the <version> tag for that dependencies.
- Dependencies, inherited from the spring-boot-dependencies POM
- Sensible resource filtering
- Sensible plugin configuration
  
## Inheriting Starter Parent
The following **spring-boot-starter-parent** inherits automatically when we configure the project.
  
  ```xml
  <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
  ```
