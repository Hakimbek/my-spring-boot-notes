# Spring Boot Starter Test
The **spring-boot-starter-test** is the primary dependency for the test. It contains the majority of elements required for our tests.

There are several different types of tests that we can write to help test and automate the health of an application. Before starting any testing, we need to integrate the testing framework.

With Spring Boot, we need to add starter to our project, for testing we only need to add the **spring-boot-starter-test** dependency.

```xml
<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-test</artifactId>  
    <version>latest-ver</version>  
    <scope>test</scope>  
</dependency>  
```

It pulls all the dependencies related to test. After adding it, we can build up a simple unit test. We can either create the Spring Boot project through IDE or generate it using Spring Initializr.

> Note: If you are adding test dependency manually, add it to the bottom of the **pom.xml** file.

In the above dependency, one thing to be noticed that it includes the scope of test `<scope>test</scope>`. It means when the application is bundled and packaged for deployment, any dependency that is declared with the test scopes is ignored. The test scope dependencies are only available when running in the development and **Maven** test modes.

When we create a simple Spring Boot application, by default, it contains the test dependency in the **pom.xml** file and **ApplicationNameTest.java** file under in the folder src/test/java.
