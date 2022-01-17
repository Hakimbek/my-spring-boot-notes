# Spring Data JPA
Spring Data is a high-level Spring Source project. Its purpose is to unify and easy access to the different kinds of persistence stores, both relational database systems and NoSQL data stores.

When we implement a new application, we should focus on the business logic instead of technical complexity and boilerplate code. That's why the **Java Persistent API (JPA)** specification and **Spring Data JPA** are extremely popular.

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
