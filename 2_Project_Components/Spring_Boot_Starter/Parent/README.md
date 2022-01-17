# Spring Boot Starter Parent
The **spring-boot-starter-parent** is a project starter. It provides default configurations for our applications. It is used internally by all dependencies. All Spring Boot projects use **spring-boot-starter-parent** as a parent in **pom.xml** file.

```xml
<parent>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-parent</artifactId>  
    <version>latest-ver</version>  
</parent>  
```

Parent Poms allow us to manage the following things for multiple child projects and modules:

- **Configuration:** It allows us to maintain consistency of Java Version and other related properties.
- **Dependency Management:** It controls the versions of dependencies to avoid conflict.
- Source encoding
- Default Java Version
- Resource filtering
- It also controls the default plugin configuration.

The **spring-boot-starter-parent** inherits dependency management from **spring-boot-dependencies**. We only need to specify the Spring Boot version number. If there is a requirement of the additional starter, we can safely omit the version number.

## Spring Boot Starter Parent Internal
The **spring-boot-starter-parent** inherits dependency management from **spring-boot-dependencies**. We only need to specify the Spring Boot version number. If there is a requirement of the additional starter, we can safely omit the version number.

```xml
<parent>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-dependencies</artifactId>  
    <version>1.6.0.RELEASE</version>  
    <relativePath>../../spring-boot-dependencies</relativePath>  
</parent>
```

### Default Parent Pom

```xml
<properties>  
    <java.version>1.8</java.version>  
    <resource.delimiter>@</resource.delimiter>   
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>  
    <maven.compiler.source>${java.version}</maven.compiler.source>  
    <maven.compiler.target>${java.version}</maven.compiler.target>  
</properties>  
```

The properties section defines the application default values. The default Java version is 1.8. We can also override Java version by specifying a property        `<java.version>1.8</java.version>` in the project pom. The parent pom also contains the few other settings related to encoding and source. The Spring Boot framework uses these defaults in case, if we have not defined in the **application.properties** file.

### Plugin Management

The **spring-boot-starter-parent** specifies the default configuration for a host of plugins including **maven-failsafe-plugin, maven-jar-plugin** and **maven-surefire-plugin**.

```xml
<plugin>  
    <groupId>org.apache.maven.plugins</groupId>  
    <artifactId>maven-failsafe-plugin</artifactId>  
    <executions>  
        <execution>  
            <goals>  
                <goal>integration-test</goal>  
                <goal>verify</goal>  
            </goals>  
        </execution>  
    </executions>  
</plugin>

<plugin>  
    <groupId>org.apache.maven.plugins</groupId>  
    <artifactId>maven-jar-plugin</artifactId>  
    <configuration>  
        <archive>  
            <manifest>  
                <mainClass>${start-class}</mainClass> 
                <addDefaultImplementationEntries>true</addDefaultImplementationEntries>  
            </manifest>  
        </archive>  
    </configuration>  
</plugin>

<plugin>  
    <groupId>org.apache.maven.plugins</groupId>  
    <artifactId>maven-surefire-plugin</artifactId>  
    <configuration>  
        <includes>  
            <include>**/*Tests.java</include> 
            <include>**/*Test.java</include>  
        </includes>  
        <excludes>  
            <exclude>**/Abstract*.java</exclude>  
        </excludes>  
    </configuration>  
</plugin>  
```
