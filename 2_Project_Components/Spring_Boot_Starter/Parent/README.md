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

# Spring Boot Starter Parent Internal
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

### Spring Boot Dependencies

The **spring-boot-starter-parent** dependency inherit from the **spring-boot-dependencies**, it shares all these characteristics as well. Hence the Spring Boot manages the list of the dependencies as the part of the dependency management.

```xml
<properties>  
    <activemq.version>5.13.4</activemq.version>  
    ...  
    <ehcache.version>2.10.2.2.21</ehcache.version>  
    <ehcache3.version>3.1.1</ehcache3.version>  
    ...  
    <h2.version>1.4.192</h2.version>  
    <hamcrest.version>1.3</hamcrest.version>  
    <hazelcast.version>3.6.4</hazelcast.version>  
    <hibernate.version>5.0.9.Final</hibernate.version>  
    <hibernate-validator.version>5.2.4.Final</hibernate-validator.version>  
    <hikaricp.version>2.4.7</hikaricp.version>  
    <hikaricp-java6.version>2.3.13</hikaricp-java6.version>  
    <hornetq.version>2.4.7.Final</hornetq.version>  
    <hsqldb.version>2.3.3</hsqldb.version>  
    <htmlunit.version>2.21</htmlunit.version>  
    <httpasyncclient.version>4.1.2</httpasyncclient.version>  
    <httpclient.version>4.5.2</httpclient.version>  
    <httpcore.version>4.4.5</httpcore.version>  
    <infinispan.version>8.2.2.Final</infinispan.version>  
    <jackson.version>2.8.1</jackson.version>  
    ....  
    <jersey.version>2.23.1</jersey.version>  
    <jest.version>2.0.3</jest.version>  
    <jetty.version>9.3.11.v20160721</jetty.version>  
    <jetty-jsp.version>2.2.0.v201112011158</jetty-jsp.version>  
    <spring-security.version>4.1.1.RELEASE</spring-security.version>  
    <tomcat.version>8.5.4</tomcat.version>  
    <undertow.version>1.3.23.Final</undertow.version>  
    <velocity.version>1.7</velocity.version>  
    <velocity-tools.version>2.0</velocity-tools.version>  
    <webjars-hal-browser.version>9f96c74</webjars-hal-browser.version>  
    <webjars-locator.version>0.32</webjars-locator.version>  
    <wsdl4j.version>1.6.3</wsdl4j.version>  
    <xml-apis.version>1.4.01</xml-apis.version>  
</properties>  

<prerequisites>  
    <maven>3.2.1</maven>  
</prerequisites>  
```
