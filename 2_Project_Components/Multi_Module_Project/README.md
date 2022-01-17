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
