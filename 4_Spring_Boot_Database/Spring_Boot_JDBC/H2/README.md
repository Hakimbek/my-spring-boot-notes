# Spring Boot JDBC

Spring Boot JDBC provides starter and libraries for connecting an application with JDBC.

In Spring Boot JDBC, the database related beans such as DataSource, JdbcTemplate, and NamedParameterJdbcTemplate auto-configures and created during the startup. We can autowire these classes if we want to use it. For example:

```java
@Autowired  
JdbcTemplate jdbcTemplate;  

@Autowired  
private NamedParameterJdbcTemplate jdbcTemplate;  
```
In application.properties file, we configure DataSource and connection pooling. Spring Boot chooses tomcat pooling by default.

## JDBC Connection Pooling
JDBC connection pooling is a mechanism that manages multiple database connection requests. In other words, it facilitates connection reuse, a memory cache of database connections, called a connection pool. A connection pooling module maintains it as a layer on top of any standard JDBC driver product.

It increases the speed of data access and reduces the number of database connections for an application. It also improves the performance of an application. Connection pool performs the following tasks:

- Manage available connection
- Allocate new connection
- Close connection

## HikariCP
The default connection pool in Spring Boot 2 is HikariCP. It provides enterprise-ready features and better performance. HikariCP is a JDBC DataSource implementation that provides a connection pooling mechanism.

- If the HikariCP is present on the classpath, the Spring Boot automatically configures it.
- If the HikariCP is not found on the classpath, Spring Boot looks for the Tomcat JDBC Connection Pool. If it is on the classpath Spring Boot, pick it up.
- If both the above options are not available, Spring Boot chooses Apache Commons DBCP2 as the JDBC connection pool.

We can also configure a connection pool manually, if we do not want to use the default connection pool. Suppose, we want to use Tomcat JDBC connection pool instead of HikariCP. We will exclude HikariCP dependency and add the tomcat-jdbc dependency in the pom.xml file, as shown below.

```xml
<dependency>  
  <groupId>org.springframework.boot</groupId>  
  <artifactId>spring-boot-starter-data-jpa</ artifactId >  
  <exclusions>  
    <exclusion>  
      <groupId>com.zaxxer</groupId>  
      <artifactId>HikariCP</ artifactId >  
      </exclusion>  
  </exclusions>  
</dependency>  

<dependency>  
  <groupId>org.apache.tomcat</groupId>  
  <artifactId>tomcat-jdbc</artifactId>  
  <version>9.0.10</version>  
</dependency>  

<dependency>  
  <groupId>com.h2database</groupId>  
  <artifactId>h2</artifactId>  
  <version>1.4.9</version>  
  <socpe>runtime</scoope>  
</dependency>  
```

The above approach allows us to use Tomcat connection pool without having to write a @Configuration class and programmatically define a DataSource bean.

On the other hand, we can also skip the connection pool scanning algorithm that Spring Boot uses. We can explicitly specify a connection pooling datasource by adding the property **spring.datasource.type** in the **application.properties** file.

```properties
Spring.datasource.type=org.apache.tomcat.jdbc.pool.DataSource  
```

If we want to connect to PostgreSQL database, we need to include the JDBC driver in the application's classpath:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.3.1</version>
</dependency>

```
After that, define the datasoure properties in **application.properties** file.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/database_name
spring.datasource.password=****
spring.datasource.username=name

```

## Why should we use Spring Boot JDBC?
The functionality of Spring JDBC and Spring Boot JDBC is the same except the implementations. There are following advantages of Spring Boot JBDC over Spring JDBC:

| Spring Boot JDBC | Spring JDBC |
| ---------------- | ----------- |
| There is only a **spring-boot-starter-jdbc** dependency is required. | In Spring JDBC, multiple dependencies need to be configured like **spring-jdbc** and **spring-context**. |
| It automatically configures Datasource bean, if not maintain explicitly. If we do not want to use the bean, we can set a property **spring.datasource.initialize** to **false**. | In Spring JDBC, it is necessary to create a database bean either using **XML** or **javaconfig**. |
| We do not need to register Template beans because Spring Boot automatically registers beans. | The Template beans such as **PlatformTransactionManager, JDBCTemplate, NamedParameterJdbcTemplate** must be registered. |
| Any DB initialization scripts stored in **.sql** file gets executed automatically. | If any DB initialization scripts like dropping or creation of tables are created in SQL file, this info needs to be given explicitly in the configuration. |

## JDBC vs. Hibernate

| JDBC | Hibernate |
| ---- | --------- |
| JDBC is a technology. | Hibernate is an ORM framework. |
| In JDBC, the user is responsible for creating and closing the connections. | In Hibernate, the run time system takes care of creating and closing the connections |
| It does not support lazy loading. | It supports lazy loading that offers better performance. |
| It does not support associations (the connection between two separate classes). | It supports associations. |

## Spring Boot JDBC Example
Spring Boot provides starter and libraries for connecting to our application with JDBC. Here, we are creating an application which connects with PostgreSQL database. It includes the following steps to create and setup JDBC with Spring Boot

## Step 1
Create a database

```sql
create database spring_boot_jdbc  
```

## Step 2
Create a table

```sql
create table user(
  id int UNSIGNED primary key not null auto_increment, 
  name varchar(100), 
  email varchar(100));
```
## Step 3
Creating Spring Boot project and after onfigure database into **application.properties** file.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/spring_boot_jdbc 
spring.datasource.username=postgres  
spring.datasource.password=5657  
spring.jpa.hibernate.ddl-auto=create-drop  
```

## Step 4
Creating a controller to handle HTTP requests.

```java
@RestController
public class SpringBootJdbcController {

    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/insert")
    public String index() {
        jdbc.execute("insert into " + "\"" + "user" + "\"" + " values(2, 'Hakim','hakim@gmail.com')");
        return "Data inserted Successfully";
    }

}
```

Run main file as Javaapplication.

## Spring Boot H2 Database
### What is the in-memory database
In-memory database relies on system memory as oppose to disk space for storage of data. Because memory access is faster than disk access. We use the in-memory database when we do not need to persist the data. The in-memory database is an embedded database. The in-memory databases are volatile, by default, and all stored data loss when we restart the application.

The widely used in-memory databases are **H2, HSQLDB (HyperSQL Database)** and **Apache Derby**. It creates the configuration automatically.

Persistence vs. In-memory Database
The persistent database persists the data in physical memory. The data will be available even if the database server is bounced. Some popular persistence databases are **Oracle, MySQL, Postgres, etc**.

In the case of the in-memory database, data store in the system memory. It lost the data when the program is closed. It is helpful for POCs (Proof of Concepts), not for a production application. The widely used in-memory database is H2.

### What is the H2 Database
H2 is an embedded, open-source, and in-memory database. It is a relational database management system written in Java. It is a client/server application. It is generally used in unit testing. It stores data in memory, not persist the data on disk.

### Advantages

- Zero configuration
- It is easy to use.
- It is lightweight and fast.
- It provides simple Configuration to switch between a real database and in-memory database.
- It supports standard SQL and JDBC API.
- It provides a web console to maintain in the database.

### Configure H2 Database
If we want to use H2 database in an application we need to add the following dependency in **pom.xml** file:

```xml
<dependency>  
  <groupId>com.h2database</groupId>  
  <artifactId>h2</artifactId>  
  <scope>runtime</scope>  
</dependency>  
```

After adding the dependency, we need to configure data source **URL, driver class name, username** and **password** of H2 database. Spring Boot provide an easy way to configure these properties in **application.properties** file.

```properties
spring.datasource.url=jdbc:h2:mem:testdb  
spring.datasource.driverClassName=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  
```

In the **spring.datasource.url** property, **mem** is the name of an in-memory database and **testdb** is the name of schema that H2 provides, by default. We can also define our own schema and database. The default **username** is **sa** and the **blank password** denotes an empty password. If we want to change the username and password, we can override these values.

### Persist the data in H2 Database
If we want to persist the data in the H2 database, we should store data in a file. To achieve the same, we need to change the datasource URL property.

```properties
#persist the data  
spring.datasource.url=jdbc:h2:file:/data/sampledata  
spring.datasource.url=jdbc:h2:C:/data/sampledata
```
In the above property, the sampledata is a file name.

### Create Schema and Populate Data
We can define schema by creating a SQL file in the resource folder (src/main/resource).

### schema.sql

```sql
DROP TABLE IF EXISTS CITY;  
CREATE TABLE CITY (  
  city_code INT AUTO_INCREMENT  PRIMARY KEY,  
  city_name VARCHAR(50) NOT NULL,  
  city_pincode INT(8) NOT NULL  
);  
```

We can populate data in the table by creating a SQL file in the resource folder (src/main/resource).
### data.sql

```sql
INSERT INTO CITY VALUES (11, 'Xoream', 1);    
INSERT INTO CITY VALUES (12, 'Urgench', 2);    
INSERT INTO CITY VALUES (13, 'Khiva', 3);    
```
Spring Boot automatically picks up the data.sql file and run it against the H2 database during the application startup.

### H2 Console
By default, the console view of the H2 database is disabled. Before accessing the H2 database, we must enable it by using the following property.

```properties
#enabling the H2 console  
spring.h2.console.enabled=true  
```

## Spring Boot H2 Example
### Step 1
Create Spring Boot Project. Add the dependencies Spring Web, Spring Data JPA and H2 Database.

### Step 2
Create a model class in the package **io.spring.boot.model**. We have created model class with the name **Student**. In the Student class, we have done the following:

- Define four variable id, age, name, and
- Generate Getters and Setters.
- Mark the class as Entity by using the annotation **@Entity**.
- Mark the class as Table name by using the annotation **@Table**.
- Define each variable as Column by using the annotation **@Column**.

### Student.java
```java
@Entity
@Table
public class Student {
    @Id
    //defining id as column name
    @Column
    private int id;
    //defining name as column name
    @Column
    private String name;
    //defining age as column name
    @Column
    private int age;
    //defining email as column name
    @Column
    private String email;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

### Step 3
Create a Controller class in the package **io.spring.boot.controller**. We have created controller class with the name StudentController. In the StudentController class, we have done the following:

- Mark the class as RestController by using the annotation **@RestController**.
- Autowire the StudentService class by using the annotation **@Autowired**.
- Define the following methods:
  - **getAllStudent():** It returns a List of all Students.
  - **getStudent():** It returns a student detail that we have specified in the path variable. We have passed id as an argument by using the annotation **@PathVariable**. The     annotation indicates that a method parameter should be bound to a URI template variable.
- **deleteStudent():** It deletes a specific student that we have specified in the path variable.
- **saveStudent():** It saves the student detail. The annotation **@RequestBody** indicates that a method parameter should be bound to the body of the web request.

### StudentController.java
```java
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    private List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    //creating a get mapping that retrieves the detail of a specific student
    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    //creating a delete mapping that deletes a specific student
    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        studentService.delete(id);
    }

    //creating post mapping that post the student detail in the database
    @PostMapping("/student")
    private int saveStudent(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        return student.getId();
    }

}
```

### Step 4
Create a Service class. We have created a service class with the name StudentService in the package com.javatpoint.service.

### StudentService.java

```java
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    //getting a specific record  
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public void saveOrUpdate(Student student) {
        studentRepository.save(student);
    }

    //deleting a specific record  
    public void delete(int id) {
        studentRepository.deleteById(id);
    }

}
```

### Step 5 
Create a Repository interface. We have created a repository interface with the name StudentRepository in the package **io.spring.boot.repository. It extends the Crud Repository interface.

### StudentRepository.java

```java
public interface StudentRepository extends CrudRepository<Student, Integer> {
    
}
```

### Step 6
Now we will configure the datasource URL, driver class name, username, and password, in the **application.properties** file.

Open the application.properties file and configure the following properties.

### application.properties
```properties
spring.datasource.url=jdbc:h2:mem:test  
spring.datasource.driverClassName=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  
#enabling the H2 console  
spring.h2.console.enabled=true  
```

Open main file and run it as Java Application.
