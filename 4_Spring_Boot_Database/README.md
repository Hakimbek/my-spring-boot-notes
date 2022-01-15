# Spring Boot Database
## What is JPA?
**Spring Boot JPA** is a Java specification for managing relational data in Java applications. It allows us to access and persist data between Java object/class and relational database. JPA follows **Object-Relation Mapping (ORM)**. It is a set of interfaces. It also provides a runtime EntityManager API for processing queries and transactions on the objects against the database. It uses a platform-independent object-oriented query language **JPQL (Java Persistent Query Language)**.

In the context of persistence, it covers three areas:

- The Java Persistence API
- Object-Relational metadata
- The API itself, defined in the persistence package

JPA is not a framework. It defines a concept that can be implemented by any framework.

## Why should we use JPA?
JPA is simpler, cleaner, and less labor-intensive than JDBC, SQL, and hand-written mapping. JPA is suitable for non-performance oriented complex applications. The main advantage of JPA over JDBC is that, in JPA, data is represented by objects and classes while in JDBC data is represented by tables and records. It uses POJO to represent persistent data that simplifies database programming. There are some other advantages of JPA:

- JPA avoids writing DDL in a database-specific dialect of SQL. Instead of this, it allows mapping in XML or using Java annotations.
- JPA allows us to avoid writing DML in the database-specific dialect of SQL.
- JPA allows us to save and load Java objects and graphs without any DML language at all.
- When we need to perform queries JPQL, it allows us to express the queries in terms of Java entities rather than the (native) SQL table and columns.
 
## JPA Features
- It is a powerful repository and custom object-mapping abstraction.
- It supports for cross-store persistence. It means an entity can be partially stored in MySQL and Neo4j (Graph Database Management System).
- It dynamically generates queries from queries methods name.
- The domain base classes provide basic properties.
- It supports transparent auditing.
- Possibility to integrate custom repository code.
- It is easy to integrate with Spring Framework with the custom namespace.

## JPA Architecture
JPA is a source to store business entities as relational entities. It shows how to define a POJO as an entity and how to manage entities with relation.

The following figure describes the class-level architecture of JPA that describes the core classes and interfaces of JPA that is defined in the javax persistence package. The JPA architecture contains the following units:

### Persistence
It is a class that contains static methods to obtain an EntityManagerFactory instance.

### EntityManagerFactory
It is a factory class of EntityManager. It creates and manages multiple instances of EntityManager.

### EntityManager
It is an interface. It controls the persistence operations on objects. It works for the Query instance.

### Entity
The entities are the persistence objects stores as a record in the database.

### Persistence Unit
It defines a set of all entity classes. In an application, EntityManager instances manage it. The set of entity classes represents the data contained within a single data store.

### EntityTransaction
It has a one-to-one relationship with the EntityManager class. For each EntityManager, operations are maintained by EntityTransaction class.

### Query
It is an interface that is implemented by each JPA vendor to obtain relation objects that meet the criteria.

## JPA Class Relationships
- The relationship between EntityManager and EntiyTransaction is one-to-one. There is an EntityTransaction instance for each EntityManager operation.
- The relationship between EntityManageFactory and EntiyManager is one-to-many. It is a factory class to EntityManager instance.
- The relationship between EntityManager and Query is one-to-many. We can execute any number of queries by using an instance of EntityManager class.
- The relationship between EntityManager and Entity is one-to-many. An EntityManager instance can manage multiple Entities.

## JPA Implementations
JPA is an open-source API. There is various enterprises vendor such as Eclipse, RedHat, Oracle, etc. that provides new products by adding the JPA in them. There are some popular JPA implementations frameworks such as Hibernate, EclipseLink, DataNucleus, etc. It is also known as Object-Relation Mapping (ORM) tool.

## Object-Relation Mapping (ORM)
In ORM, the mapping of Java objects to database tables, and vice-versa is called Object-Relational Mapping. The ORM mapping works as a bridge between a relational database (tables and records) and Java application (classes and objects).

The ORM layer exists between the application and the database. It converts the Java classes and objects so that they can be stored and managed in a relational database. By default, the name that persists become the name of the table, and fields become columns. Once an application sets-up, each table row corresponds to an object.

## Difference between JPA and Hibernate
### JPA
JPA is a Java specification that is used to access, manage, and persist data between Java object and relational database. It is a standard approach for ORM.

### Hibernate
It is a lightweight, open-source ORM tool that is used to store Java objects in the relational database system. It is a provider of JPA. It follows a common approach provided by JPA.

| JPA | Hibernate |
| --- | --------- |
| JPA is a Java specification for mapping relation data in Java application. | Hibernate is an ORM framework that deals with data persistence. |
| JPA does not provide any implementation classes. | It provides implementation classes. |
| It uses platform-independent query language called JPQL (Java Persistence Query Language). | It uses its own query language called HQL (Hibernate Query Language). |
| It is defined in javax.persistence package. | It is defined in org.hibernate package. |
| It is implemented in various ORM tools like Hibernate, EclipseLink, etc. | Hibernate is the provider of JPA. |
| JPA uses EntityManager for handling the persistence of data. | In Hibernate uses Session for handling the persistence of data. |

## Spring Boot Starter Data JPA
Spring Boot provides starter dependency **spring-boot-starter-data-jpa** to connect Spring Boot application with relational database efficiently. The spring-boot-starter-data-jpa internally uses the **spring-boot-jpa** dependency.

```xml
<dependency>    
  <groupId>org.springframework.boot</groupId>    
  <artifactId>spring-boot-starter-data-jpa</artifactId>    
  <version>latest-ver</version>    
</dependency>  
```
## Spring Boot JPA Example

### Step 1
Generate Spring Boot project and add dependencyies Spring: Web, Spring Data JPA and PostgreSQL Driver

### Step 2 
Create a class with the name **UserRecord** in the package **io.spring.boot.model** and do the following:

- Define three variables **id, name** and **email**.
- Generate Getters and Setter.
- Define a default constructor.
- Mark the class as an Entity by using the annotation **@Entity**.
- Mark **Id** as the primary key by using the annotation **@Id**.

### UserRecord.java

```java
@Entity
public class UserRecord {
    @Id
    private Integer id;

    private String name;

    private String email;

    public UserRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

## Step 3
Create a repository interface with the name **UserRepository** in the package **io.spring.boot.repository** and extends **CrudRepository**.

### UserRepository.java

```java
public interface UserRepository extends CrudRepository<UserRecord, String> {

}
```

## Step 4
Create a Service class with the name **UserService** in the package **io.spring.boot.service** and do the following:

- Mark the class as service by using the annotation **@Service**.
- Autowired the UserRepository
- Define a method **getAllUsers()** that returns a List of
- Define another method name **addUser()** that saves the user record.

### UserService.java

```java
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserRecord> getAllUsers() {
        List<UserRecord> userRecords = new ArrayList<>();
        userRepository.findAll().forEach(userRecords::add);
        return userRecords;
    }

    public void addUser(UserRecord userRecord) {
        userRepository.save(userRecord);
    }

}
```

### Strep 5
Create a Controller class with the name **UserController** in the package **io.spring.boot.controller** and do the following:

- Mark the class as a controller by using the annotation **@RestController**.
- Autowired the class **UserService** by using the annotation **@Autowired**.
- We have defined two mappings, one for getting all users and the other for add-user.

```java
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public List<UserRecord> getAllUser() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public void addUser(@RequestBody UserRecord userRecord) {
        userService.addUser(userRecord);
    }

}
```

## Step 6
Set database url, name and password in application.properties file

### application.properties

```java
`spring.datasource.url=jdbc:postgresql://localhost:5432/spring_jpa_example`
spring.datasource.password=5657
spring.datasource.username=postgres
spring.jpa.hibernate.ddl-auto=create
```




