# Spring Boot CRUD Operations
## What is the CRUD operation?
The CRUD stands for **Create, Read/Retrieve, Update** and **Delete**. These are the four basic functions of the persistence storage.

The CRUD operation can be defined as user interface conventions that allow view, search and modify information through computer-based forms and reports. CRUD is data-oriented and the standardized use of HTTP action verbs. HTTP has a few important verbs.

- **POST:** Creates a new resource
- **GET:** Reads a resource
- **PUT:** Updates an existing resource
- **DELETE:** Deletes a resource

Within a database, each of these operations maps directly to a series of commands. However, their relationship with a **RESTful API** is slightly more complex.

## Standard CRUD Operation
- **CREATE** Operation: It performs the **INSERT** statement to create a new record.
- **READ** Operation: It reads table records based on the input parameter.
- **UPDATE** Operation: It executes an update statement on the table. It is based on the input parameter.
- **DELETE** Operation: It deletes a specified row in the table. It is also based on the input parameter.

### How CRUD Operations Works
CRUD operations are at the foundation of the most dynamic websites. Therefore, we should differentiate CRUD from the HTTP action verbs.

Suppose, if we want to create a new record, we should use HTTP action verb POST. To update a record, we should use the PUT verb. Similarly, if we want to delete a record, we should use the DELETE verb. Through CRUD operations, users and administrators have the right to retrieve, create, edit, and delete records online.

We have many options for executing CRUD operations. One of the most efficient choices is to create a set of stored procedures in SQL to execute operations.

The CRUD operations refer to all major functions that are implemented in relational database applications. Each letter of the CRUD can map to a SQL statement and HTTP methods.

| Operation | SQL | HTTP verbs | RESTfull Web Service |
| --------- | --- | ---------- | -------------------- |
| Create | INSERT | PUT/POST | POST |
| Read | SELECT | GET | GET |
| Update | UPDATE | PUT/POST/PATCH | PUT |
| Delete | DELETE | DELETE | DELETE |

## Spring Boot CrudRepository
Spring Boot provides an interface called **CrudRepository** that contains methods for CRUD operations. It is defined in the package **org.springframework.data.repository**. It extends the Spring Data **Repository** interface. It provides generic Crud operation on a repository. If we want to use CrudRepository in an application, we have to create an interface and extend the CrudRepository.

### Syntax

```java
public interface CrudRepository<T,ID> extends Repository<T,ID>  
```

- **T** is the domain type that repository manages.
- **ID** is the type of the id of the entity that repository manages.

For example:

```java
public interface StudentRepository extends CrudRepository<Student, Integer> {  

}  
```

## Spring Boot JpaRepository
**JpaRepository** provides JPA related methods such as flushing, persistence context and deletes a record in a batch. It is defined in the package **org.springframework.data.jpa.repository**. JpaRepository extends both **CrudRepository** and **PagingAndSortingRepository**.

## Why should we use these interfaces?
- The interfaces allow Spring to find the repository interface and create proxy objects for that.
- It provides methods that allow us to perform some common operations. We can also define custom methods as well.

## CrudRepository vs. JpaRepository

| CrudRepository | JpaRepository |
| -------------- | ------------- |
| CrudRepository does not provide any method for pagination and sorting. | JpaRepository extends **PagingAndSortingRepository**. It provides all the methods for implementing the pagination. |
| It works as a **marker** interface. | JpaRepository extends both **CrudRepository** and **PagingAndSortingRepository**. |
| It provides CRUD function only. For example **findById(), findAll(), etc**. | It provides some extra methods along with the method of **PagingAndSortingRepository** and **CrudRepository**. For example, **flush(), deleteInBatch()**. |
| It is used when we do not need the functions provided by **JpaRepository** and **PagingAndSortingRepository**. | It is used when we want to implement pagination and sorting functionality in an application. |

## Spring Boot CRUD Operation Example
Let's set up a Spring Boot application and perform CRUD operation.

### Spet 1
Create Spring Boot project and add the dependencies Spring Web, Spring Data JPA, and H2 Database.

### Step 2
Create a model class in the package **io.spring.boot.model**. We have created a model class with the name **Book**. In the **Book** class, we have done the following:

- Define four variable **bookid, bookname, author** and **price**.
- Generate Getters and Setters.
- Mark the class as an Entity by using the annotation **@Entity**.
- Mark the class as Table name by using the annotation **@Table**.
- Define each variable as Column by using the annotation **@Column**.

### Book.java

```java
@Entity
@Table
public class Book {
    @Id
    @Column
    private Integer id;

    @Column
    private String bookName;

    @Column
    private String author;

    @Column
    private int price;
    
    // Getters and Setters
    
}
```

### Step 3
Create a Repository interface. We have created a repository interface with the name **BooksRepository** in the package **io.spring.boot.repository**. It extends the Crud Repository interface.

### BooksRepository.java

```java
public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
```

### Step 4
Create a Service class. We have created a service class with the name **BooksService** in the package **io.spring.boot.service**.

### BooksService.java

```java
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // getting all books record by using the method findAll() of CrudRepository
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    // getting a specific record by using the method findById() of CrudRepository
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    // saving a specific record by using the method save() of CrudRepository
    public void save(Book book) {
        bookRepository.save(book);
    }

    // deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        }
    }

    // updating a record
    public void update(Book book, int id) {
        bookRepository.save(book);
    }

}
```
### Step 5

Create a Controller class in the package **io.spring.boot.controller**. We have created a controller class with the name **BooksController**. In the BooksController class, we have done the following:

- Mark the class as RestController by using the annotation **@RestController**.
- Autowire the BooksService class by using the annotation **@Autowired**.
- Define the following methods:
  - **getAllBooks():** It returns a List of all Books.
  - **getBook():** It returns a book detail that we have specified in the path variable. We have passed **id** as an argument by using the annotation **@PathVariable**. The       annotation indicates that a method parameter should be bound to a URI template variable.
  - **deleteBook():** It deletes a specific book that we have specified in the path variable.
  - **saveBook():** It saves the book detail. The annotation **@RequestBody** indicates that a method parameter should be bound to the body of the web request.
  - **update():** The method updates a record. We must specify the record in the body, which we want to update. To achieve the same, we have used the annotation                   **@RequestBody**.

### BooksController.java

```java
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    // creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{id}")
    private Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    // creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{id}")
    private void deleteBook(@PathVariable("id") int id) {
        bookService.delete(id);
    }

    // creating post mapping that post the book detail in the database
    @PostMapping("/book")
    private int saveBook(@RequestBody Book book) {
        bookService.save(book);
        return book.getId();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/book/{id}")
    private Book update(@RequestBody Book book, @PathVariable int id) {
        bookService.update(book, id);
        return book;
    }

}
```

### Step 6
Open the **application.properties** file and configure the following properties.

### application.properties

```properties
spring.datasource.url=jdbc:h2:mem:books_data  
spring.datasource.driverClassName=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  
#enabling the H2 console  
spring.h2.console.enabled=true  
```
Open main file and run it as Java Application.






