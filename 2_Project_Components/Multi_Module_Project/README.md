# Spring Boot Multi-Module Project
A Spring Boot project that contains nested maven projects is called the **multi-module** project. In the multi-module project, the parent project works as a container for base maven configurations.

In other words, a **multi-module** project is built from a parent pom that manages a group of submodules. Or A **multi-module** project is defined by a parent POM referencing one or more submodules.

The parent maven project must contain the packaging type **pom** that makes the project as an aggregator. The **pom.xml** file of the parent project consists the list of all modules, common dependencies and properties that are inherited by the child projects. The parent pom is located in the project's root directory. The child modules are actual Spring Boot projects that inherit the maven properties from the parent project.

When we run the **multi-module project**, all the modules are deployed together in an embedded **Tomcat Server**. We can deploy an individual module, also.

## Parent POM
The parent POM defines the **Group ID, Artifact ID, version** and **packaging**. In the previous Maven projects, we have seen that the parent POM defines the packaging **jar**. But in the multi-module project, the parent POM defines the packaging **pom**. The packaging pom refers to other Maven projects.

## Why we need multi-module project
Splitting the project into multiple modules is useful and easy to maintain. We can also easily edit or remove modules in the project without affecting the other modules. It is useful when we required to deploy modules individually.

We only need to specify all the dependencies in the parent pom. All the other modules share the same pom, so we need not to specify the same dependency in each module separately. It makes the code easier to keep in order with a big project.

## Child module-ear, war, and jar
The child module may be any project and can have any packaging. We are free to create any type of dependency between modules and bundles together.

For example, we are creating an **EAR (Enterprise ARchive)**, **WAR (Web ARchive)** and **JAR (Java ARchive)** file. A JAR file is bundled into a war file that is bundled into an EAR file. The EAR file is the final package that is ready to deploy on the application server.

The EAR file contains one or many WAR files. Each WAR file contains the service project that has common code to all WAR files and packaging type in the JAR.

![Multi Module Photo](/2_Project_Components/Multi_Module_Project/image/ear.png)

## Maven child projects/modules
- The child modules are independent maven projects that share properties from the parent project.
- All child projects can be built with a single command because it is inside a parent project.
- It is easier to define the relationship between the projects.

# Multi-Module Project Directory Structure
Let's understand the multi-module project directory structure.

We have created a project named **spring-boot-multi-module-project**. It contains the parent **pom** at the bottom of the directory. After that, we have created two Maven Modules named **module1** and **module2**, respectively. These two modules contain their own **pom** files.

Let's open the **parent POM** and see what it configures when we create Maven modules in the project.

### pom.xml

```xml  
<?xml version="1.0" encoding="UTF-8"?>  
  <project xmlns="http://maven.apache.org/POM/4.0.0" 
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">  
  
    <modelVersion>4.0.0</modelVersion>  

    <parent>  
      <groupId>org.springframework.boot</groupId>  
      <artifactId>spring-boot-starter-parent</artifactId>  
      <version>2.2.2.BUILD-SNAPSHOT</version>  
      <relativePath/> <!-- lookup parent from repository -->  
    </parent>  
    
    <groupId>com.javatpoint</groupId>  
    <artifactId>spring-boot-example</artifactId>  
    <version>0.0.1-SNAPSHOT</version>  
    <name>spring-boot-multi-module-project</name>  
    <description>Demo project for Spring Boot</description>  
  
    <properties>  
      <java.version>1.8</java.version>  
    </properties>  
    
    <packaging>pom</packaging>  
    
    <dependencies>  
      <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter</artifactId>  
      </dependency>   
      
      <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-parent</artifactId>  
        <version>2.2.1.RELEASE</version>  
        <type>pom</type>  
      </dependency>  
      
      <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-web</artifactId>  
      </dependency>  
      
      <dependency>  
        <groupId>org.springframework</groupId>  
        <artifactId>spring-webmvc</artifactId>  
      </dependency>  
      
      <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-test</artifactId>  
        <scope>test</scope>  
        <exclusions>  
          <exclusion>  
            <groupId>org.junit.vintage</groupId>  
            <artifactId>junit-vintage-engine</artifactId>  
          </exclusion>  
        </exclusions>  
      </dependency>  
      
    </dependencies> 
    
    <build>  
      <plugins>  
        <plugin>  
          <groupId>org.springframework.boot</groupId>  
          <artifactId>spring-boot-maven-plugin</artifactId>  
        </plugin>  
      </plugins>  
    </build>  
    
    <repositories>  
      <repository>  
        <id>spring-milestones</id>  
        <name>Spring Milestones</name>  
        <url>https://repo.spring.io/milestone</url>  
      </repository>
      
      <repository>  
        <id>spring-snapshots</id>  
        <name>Spring Snapshots</name>  
        <url>https://repo.spring.io/snapshot</url>  
          <snapshots>  
            <enabled>true</enabled>  
          </snapshots> 
      </repository>  
    </repositories>  
    
    <pluginRepositories>  
      <pluginRepository>  
        <id>spring-milestones</id>  
        <name>Spring Milestones</name>  
        <url>https://repo.spring.io/milestone</url>  
      </pluginRepository>  
      
      <pluginRepository>  
        <id>spring-snapshots</id>  
        <name>Spring Snapshots</name>  
        <url>https://repo.spring.io/snapshot</url>  
        <snapshots>  
          <enabled>true</enabled>  
        </snapshots>  
      </pluginRepository>  
    </pluginRepositories>  
    
    <modules>  
      <module>module1</module>  
      <module>module2</module>  
    </modules>  
</project> 
```

The above pom file is same as we have seen in the previous examples. But in this pom file, two things to be noticed: packaging and modules.

When we create **multi-module** project, we need to configure packaging pom in the parent pom file instead of jar.

```xml
<packaging>pom</packaging>  
```

When we create Maven Modules in the project, Spring Boot automatically configures the modules in the parent pom inside the module tag, as shown below.

```xml
<modules>  
  <module>module1</module>  
  <module>module2</module>  
</modules>  
```

Now, we are going to see what inside the pom file of **module1**.

### pom.xml

```xml
<?xml version="1.0"?>  
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" 
         xmlns="http://maven.apache.org/POM/4.0.0"  
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">  
  
  <modelVersion>4.0.0</modelVersion>  
    
  <parent>  
    <groupId>com.javatpoint</groupId>  
    <artifactId>spring-boot-multi-module-project</artifactId>  
    <version>0.0.1-SNAPSHOT</version>  
  </parent>  
  
  <groupId>com.javatpoint</groupId>  
  <artifactId>module1</artifactId>  
  <version>0.0.1-SNAPSHOT</version>  
  <name>module1</name>  
  <url>http://maven.apache.org</url>  
  
  <properties>  
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
  </properties>  
  
  <dependencies>  
    <dependency>  
      <groupId>junit</groupId>  
      <artifactId>junit</artifactId>  
      <version>3.8.1</version>  
      <scope>test</scope>  
    </dependency>  
  </dependencies>  
</project>  
```

Here, a point to be noticed that the above pom file does not contain the common dependencies like **starter-web, web-mvc, etc**. It inherits all the common dependencies and the properties from the parent pom.
