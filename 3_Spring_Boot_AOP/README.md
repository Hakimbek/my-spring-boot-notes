# Spring Boot AOP
The application is generally developed with multiple layers. A typical Java application has the following layers:

- **Web Layer**: It exposes the services using the REST or web application.
- **Business Layer**: It implements the business logic of an application.
- **Data Layer**: It implements the persistence logic of the application.

The responsibility of each layer is different, but there are a few common aspects that apply to all layers are **Logging, Security, validation, caching,** etc. These common aspects are called **cross-cutting concerns**.

If we implement these concerns in each layer separately, the code becomes more difficult to maintain. To overcome this problem, Aspect-Oriented Programming (AOP) provides a solution to implement cross-cutting concerns.

- Implement the cross-cutting concern as an aspect.
- Define pointcuts to indicate where the aspect has to be applied.

It ensures that the cross-cutting concerns are defined in one cohesive code component.

## AOP
**AOP (Aspect-Oriented Programming)** is a programming pattern that increases modularity by allowing the separation of the cross-cutting concern. These cross-cutting concerns are different from the main business logic. We can add additional behavior to existing code without modification of the code itself.

Spring's AOP framework helps us to implement these cross-cutting concerns.

Using AOP, we define common functionality in one place. We are free to define how and where this functionality is applied without modifying the class to which we are applying the new feature. The cross-cutting concern can now be modularized into special classes, called **aspect**.

There are two benefits of aspects:

- First, the logic for each concern is now in one place instead of scattered all over the codebase.
- Second, the business modules only contain code for their primary concern. The secondary concern has been moved to the aspect.

The aspects have the responsibility that is to be implemented, called **advice**. We can implement an aspect's functionality into a program at one or more join points.

## Benefits of AOP
- It is implemented in pure Java.
- There is no requirement for a special compilation process.
- It supports only method execution Join points.
- Only run time weaving is available.
- Two types of AOP proxy is available: JDK dynamic proxy and CGLIB proxy.

## Cross-cutting concern
- The cross-cutting concern is a concern that we want to implement in multiple places in an application. It affects the entire application.

## AOP Terminology
- **Aspect:** An aspect is a module that encapsulates advice and pointcuts and provides cross-cutting An application can have any number of aspects. We can implement an aspect using regular class annotated with **@Aspect** annotation.
- **Pointcut:** A pointcut is an expression that selects one or more join points where advice is executed. We can define pointcuts using expressions or patterns. It uses different kinds of expressions that matched with the join points. In Spring Framework, **AspectJ** pointcut expression language is used.
- **Join point:** A join point is a point in the application where we apply an AOP aspect. Or it is a specific execution instance of an advice. In AOP, join point can be a method execution, exception handling, changing object variable value, etc.
- **Advice:** The advice is an action that we take either before or after the method execution. The action is a piece of code that invokes during the program execution. There are five types of advices in the Spring AOP framework: **before, after, after-returning, after-throwing,** and **around advice**. Advices are taken for a particular join point.
- **Target object:** An object on which advices are applied, is called the target object. Target objects are always a proxied It means a subclass is created at run time in which the target method is overridden, and advices are included based on their configuration.
- **Weaving:** It is a process of linking aspects with other application types. We can perform weaving at run time, load time, and compile time.
- **Proxy:** It is an object that is created after applying advice to a target object is called proxy. The Spring AOP implements the JDK dynamic proxy to create the proxy classes with target classes and advice invocations. These are called AOP proxy classes.

## AOP vs. OOP

| OOP | AOP |
| --- | --- |
| **Class:** A code unit that encapsulates methods and attributes. | **Aspect:** A code unit that encapsulates pointcuts, advices, and attributes. |
| **Method signature:** It defines the entry points for the execution of method bodies. | **Pointcut:** It defines the set of entry points in which advice is executed. |
| **Method bodies:** It is an implementation of the business logic concerns. | **Advice:** It is an implementation of cross-cutting concerns. |
| **Compiler:** It converts source code to object code. | **Waver:** It constructs code (source or object) with advice. |

## Spring AOP vs. AspectJ

| Spring AOP | AspectJ |
| --- | --- |
| There is a need for a separate compilation process. | It requires the AspectJ compiler. |
| It supports only method execution pointcuts. | It supports all pointcuts. |
| It can be implemented on beans managed by Spring Container. | It can be implemented on all domain objects. |
| It supports only method level weaving. | It can wave fields, methods, constructors, static initializers, final class, etc. |

## Types of AOP Advices
- **Before Advice:** An advice that executes before a join point, is called before advice. We use **@Before** annotation to mark an advice as Before advice.
- **After Advice:** An advice that executes after a join point, is called after advice. We use **@After** annotation to mark an advice as After advice.
- **Around Advice:** An advice that executes before and after of a join point, is called around advice.
- **After Throwing Advice:** An advice that executes when a join point throws an exception.
- **After Returning Advice:** An advice that executes when a method executes successfully.

`Before implementing the AOP in an application, we are required to add Spring AOP dependency in the pom.xml file.`

# Before Advice Example

### Step 1 
Open the **pom.xml** file and add the following AOP dependency. It is a starter for aspect-oriented programming with Spring AOP and AspectJ.

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-aop</artifactId>
   <version>latest-ver</version>
</dependency> 
```

### Step 2
Add an annotation **@EnableAspectJAutoProxy** to main class.
It enables support for handling components marked with AspectJ’s **@Aspect** annotation. It is used with @Configuration annotation. We can control the type of proxy by using the proxyTargetClass attribute. Its default value is false.

```java
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BeforeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeforeApplication.class, args);
    }


```

## Step 3
Create a model class under the package **io.spring.boot.model**. We have created a class with the name **Employee**. In the class, define the following:
- Define three variables empId, firstName, and secondName of type String.
- Generate Getters and Setters.
- Create a default constructor

```java
public class Employee {
    private String empId;
    private String firstName;
    private String secondName;

    //default constructor
    public Employee() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
```

## Step 4 
Create a controller class under the package **com.javatpoint.controller**. We have created a class with the name **EmployeeController**.
In the controller class, we have defined the two mappings one for adding an employee and the other for removing an employee.

```java
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add/employee", method = RequestMethod.POST)
    public Employee addEmployee(@RequestParam("empId") String empId, @RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {
        return employeeService.createEmployee(empId, firstName, secondName);
    }

    @RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
    public String removeEmployee(@RequestParam("empId") String empId) {
        employeeService.deleteEmployee(empId);
        return "Employee removed";
    }

}
```

## Step 5
Create a Service class under the package **com.javatpoint.service**. We have created a class with the name **EmployeeService**.
In the Service class, we have defined two methods **createEmployee** and **deleteEmployee**.

```java
@Service
public class EmployeeService {

    public Employee createEmployee(String empId, String firstName, String secondName) {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setFirstName(firstName);
        emp.setSecondName(secondName);
        return emp;
    }

    public void deleteEmployee(String empId) {
    }
}
```

## Step 6 
Create an aspect class under the package **com.javatpoint.aspect**. We have created a class with the name **EmployeeServiceAspect**.
In the aspect class, we have defined the before advice logic.

```java
@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(value = "execution(* com.example.aopbeforeadviceexample.io.spring.boot.service.EmployeeService.* (..)) && args(empId, firstName, secondName)")
    public void beforeAdvice(JoinPoint joinPoint, String empId, String firstName, String secondName) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("Creating Employee with first name - " + firstName + ", second name - " + secondName + " and id - " + empId);
    }
}
```

## Step 7
**Run**
Open the browser and invoke the following 
`URL : http://localhost:8080/add/employee?empId=1&firstName=Hakim&secondName=Bahramov`

In the above URL, /add/employee is the mapping that we have created in the Controller class. We have used two separators (?) and (&) for separating two values.


# After Advice Example
We change only **EmployeeServiceAspect** class and other classes remain unchanged

```java
@Aspect
@Component
public class EmployeeServiceAspect {

    @After(value = "execution(* com.example.after.io.spring.boot.service.EmployeeService.* (..)) && args(empId, firstName, secondName)")
    public void beforeAdvice(JoinPoint joinPoint, String empId, String firstName, String secondName) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("Creating Employee with first name - " + firstName + ", second name - " + secondName + " and id - " + empId);
    }
}
```

# Around Advice Example

### BankService.java
Create a class in the **io.spring.boot.service**. package with the name **BankService**.

In this class, we have defined a method named **displayBalance()**. It checks the account number. If the account number is matched returns total amount, else returns a message.

```java
```

### BankAspect.java
Create a class in the **io.spring.boot.aspect** package with the name **BankAspect**.

In the following class, we have defined two methods named **logDisplayingBalance()** and **aroundAdvice()** method.

```java
@Aspect
@Component
public class BankAspect {

    //Displays all the available methods i.e. the advice will be called for all the methods
    @Pointcut(value = "execution(* com.example.aoparoundadvice.io.spring.boot.service.BankService.*(..))")
    private void logDisplayingBalance() {
    }

    //Declares the around advice that is applied before and after the method matching with a pointcut expression
    @Around(value = "logDisplayingBalance()")
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("The method aroundAdvice() before invocation of the method " + jp.getSignature().getName() + " method");
        Object proceed = jp.proceed();
        System.out.println("The method aroundAdvice() after invocation of the method " + jp.getSignature().getName() + " method");
        return proceed;
    }

}
```

### Main.java
Open runable file and add an annotation **@EnableAspectJAutoProxy**.
The annotation enables support for handling components marked with AspectJ's **@Aspect** annotation. It is used with @Configuration annotation.

**ConfigurableApplicationContext** is an interface that provides facilities to configure an application context in addition to the application context client methods in the ApplicationContext.

```java
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopAroundAdviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopAroundAdviceApplication.class, args);
        // Fetching the employee object from the application context.
        BankService bank = context.getBean(BankService.class);
        String accNumber = "12345";
        bank.displayBalance(accNumber);
        context.close();
    }

}
```

# Returning Advice Example

### Acount.java
Create a class with the name Account in the package **io.spring.boot.model**.

In the Account class, do the following:

- Defined two variables accountNumber and accountType of type String.
- Generate Constructor using Fields
- Generate Getters and Setters.
- Generate a toString()

```java
public class Account {

    private String accountNumber;
    private String accountType;

    public Account(String accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + "]";
    }

}
```

### AccountService.java
Create an interface with the name AccountService in the package **io.spring.boot.model.impl**.

```java
public interface AccountService {

    public abstract Account getAccountByCustomerId(String customerId) throws Exception;

}
```

### AccountServiceImpl.java
In the **io.spring.boot.model.impl** package, create a class with the name AccountServiceImple.

In this class, we have defined account service.

```java
public class AccountServiceImpl implements AccountService {

    //storing account detail in the HashMap  
    private static Map<String, Account> map = null;

    static {
        map = new HashMap<>();
        //adding account detail in the map  
        map.put("M4546779", new Account("10441117000", "Saving Account"));
        map.put("K2434567", new Account("10863554577", "Current Account"));
    }

    @Override
    public Account getAccountByCustomerId(String customerId) throws Exception {
        if (customerId == null) {
            throw new Exception("Invalid! Customer Id");
        }
        Account account = null;
        Set<Map.Entry<String, Account>> entrySet = map.entrySet();
        for (Map.Entry<String, Account> entry : entrySet) {
            if (entry.getKey().equals(customerId)) {
                account = entry.getValue();
            }
        }
        return account;
    }

}
```

### AccountAspect.java
Create a class with the name AccountAspect in the package **io.spring.boot**.
In this class, we have implemented the after returning advice by using the annotation **@AfterReturning**. We have also defined a method **afterReturningAdvice()** method.

`Note: The name (account) that we define in the returning attribute must correspond to the name of a parameter in the advice method.`

```java
@Aspect
@Component
public class AccountAspect {

    //implementing after returning advice
    @AfterReturning(value = "execution(* com.example.aopreturningadvice.io.spring.boot.service.impl.AccountServiceImpl.*(..))", returning = "account")
    public void afterReturningAdvice(JoinPoint joinPoint, Account account) {
        System.out.println("After Returning method:" + joinPoint.getSignature());
        System.out.println(account);
    }

}
```

### Main class
Open the runable file and add an annotation **@EnableAspectJAutoProxy**.

The annotation enables support for handling components marked with AspectJ's **@Aspect** annotation. It is used with @Configuration annotation.
We have used the **proxyTargetClass** attribute of the annotation **@EnableAspectJAutoProxy**. The attribute **proxyTargetClass=true** allows us to use CGLIB (Code Generation Library) proxies instead of the default interface-based JDK proxy approach.

```java
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopReturningAdviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopReturningAdviceApplication.class, args);
        AccountServiceImpl accountServiceImpl = context.getBean(AccountServiceImpl.class);
        Account account;
        try {
            account = accountServiceImpl.getAccountByCustomerId("K2434567");
            if (account != null)
                System.out.println(account.getAccountNumber() + "\t" + account.getAccountType());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
```

# After Throwing Advice Example

We will use the previous example in **After Throwing** example.
There is only one class that you must change. It is **AccountAspect** class.

### AccountAspect.java

```java
@Aspect
@Component
public class AccountAspect {
    //implementing after throwing advice      
    @AfterThrowing(value = "execution(* com.example.aopafterthrow.io.spring.boot.service.impl.AccountServiceImpl.*(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
        System.out.println("Exception is:" + ex.getMessage());
    }
}
```

> Note: The name (ex) that we define in the throwing attribute must correspond to the name of a parameter in the advice method. Otherwise, advice will not run.

