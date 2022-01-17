# Spring Boot Packaging
In the J2EE application, modules are packed as **JAR, WAR and EAR**. It is the compressed file formats that is used in the J2EE. J2EE defines three types of archives:

### WAR
WAR stands for Web Archive. WAR file represents the web application. Web module contains servlet classes, JSP files, HTML files, JavaScripts, etc. are packaged as a JAR file with .war extension. It contains a special directory called WEB-INF.

WAR is a module that loads into a web container of the Java Application Server. The Java Application Server has two containers: Web Container and EJB Container.

The Web Container hosts the web applications based on Servlet API and JSP. The web container requires the web module to be packaged as a WAR file. It is a WAR file special JAR file that contains a web.xmlv file in the WEB-INF folder.

An EJB Container hosts Enterprise Java beans based on EJB API. It requires EJB modules to be packaged as a JAR file. It contains an ejb-jar.xml file in the META-INF folder.

The advantage of the WAR file is that it can be deployed easily on the client machine in a Web server environment. To execute a WAR file, a Web server or Web container is required. For example, Tomcat, Weblogic, and Websphere.

### JAR
JAR stands for Java Archive. An EJB (Enterprise Java Beans) module that contains bean files (class files), a manifest, and EJB deployment descriptor (XML file) are packaged as JAR files with the extension .jar. It is used by software developers to distribute Java classes and various metadata.

In other words, A file that encapsulates one or more Java classes, a manifest, and descriptor is called JAR file. It is the lowest level of the archive. It is used in J2EE for packaging EJB and client-side Java Applications. It makes the deployment easy.

### EAR
EAR stands for Enterprise Archive. EAR file represents the enterprise application. The above two files are packaged as a JAR file with the .ear extension. It is deployed into the Application Server. It can contain multiple EJB modules (JAR) and Web modules (WAR). It is a special JAR that contains an application.xml file in the META-INF folder.


# Spring Boot Auto-configuration
Spring Boot auto-configuration automatically configures the Spring application based on the jar dependencies that we have added.

For example, if the H2 database Jar is present in the classpath and we have not configured any beans related to the database manually, the Spring Boot's auto-configuration feature automatically configures it in the project.

We can enable the auto-configuration feature by using the annotation **@EnableAutoConfiguration**. But this annotation does not use because it is wrapped inside the **@SpringBootApplication** annotation. The annotation **@SpringBootApplication** is the combination of three annotations: **@ComponentScan, @EnableAutoConfiguration and **@Configuration**. However, we use **@SpringBootApplication** annotation instead of using **@EnableAutoConfiguration**.

### @SpringBootApplication=@ComponentScan+@EnableAutoConfiguration+@Configuration

When we add the spring-boot-starter-web dependency in the project, Spring Boot auto-configuration looks for the Spring MVC is on the classpath. It auto-configures dispatcherServlet, a default error page, and web jars.

Similarly, when we add the spring-boot-starter-data-jpa dependency, we see that Spring Boot Auto-configuration, auto-configures a datasource and an Entity Manager.

## Need of auto-configuration
Spring-based application requires a lot of configuration. When we use Spring MVC, we need to configure dispatcher servlet, view resolver, web jars among other things. The following code shows typical configuration of a dispatcher servlet in a web application:

```xml
<servlet>  
    <servlet-name>dispatcher</servlet-name>  
    <servlet-class>  
        org.springframework.web.servlet.DispatcherServlet  
    </servlet-class>  
    <init-param>  
        <param-name>contextConfigLocation</param-name>  
        <param-value>/WEB-INF/todo-servlet.xml</param-value>  
    </init-param>  
    <load-on-startup>1</load-on-startup>  
</servlet>  

<servlet-mapping>  
    <servlet-name>dispatcher</servlet-name>  
    <url-pattern>/</url-pattern>  
</servlet-mapping>  
```

Similarly, when we use Hibernate/ JPA, we need to configure datasource, a transaction manager, an entity manager factory among a host of other things.

### Configuring datasource

```xml
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">  
    <property name="driverClass" value="${db.driver}" />  
    <property name="jdbcUrl" value="${db.url}" />  
    <property name="user" value="${db.username}" />  
    <property name="password" value="${db.password}" />  
</bean>

<jdbc:initialize-database data-source="dataSource">  
    <jdbc:script location="classpath:config/schema.sql" />  
    <jdbc:script location="classpath:config/data.sql" />  
</jdbc:initialize-database>  
```
