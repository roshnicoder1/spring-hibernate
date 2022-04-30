# spring-hibernate

* @Entity
* @Table(name="stu500")
* @Id
* @Component
* @Column(name="custno")
* @GeneratedValue(strategy=GenerationType.IDENTITY)
* hibernate.cfg.xml or hibernate.properties  In hibernate framework, we provide all the database information and configuration details.
* employee.hbm.xml

Entities in JPA are nothing but POJOs representing data that can be persisted to the database. An entity represents a table stored in a database. Every instance of an entity represents a row in the table.
Let's say we have a POJO called Student, which represents the data of a student, and we would like to store it in the database:

```
public class Student {
    
    // fields, getters and setters
    
}
```
In order to do this, we should define an entity so that JPA is aware of it.

## So let's define it by making use of the @Entity annotation. We must specify this annotation at the class level. We must also ensure that the entity has a no-arg constructor and a primary key: 

```
@Entity(name="student")
public class Student {
    
    // fields, getters and setters
    
}
```
##  Id Annotation
Each JPA entity must have a primary key that uniquely identifies it. The @Id annotation defines the primary key. We can generate the identifiers in different ways, which are specified by the @GeneratedValue annotation.

We can choose from four id generation strategies with the strategy element. The value can be AUTO, TABLE, SEQUENCE, or IDENTITY:
```
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    // getters and setters
}

```
If we specify GenerationType.AUTO, the JPA provider will use any strategy it wants to generate the identifiers.

Because various JPA implementations will try subclassing our entity in order to provide their functionality, entity classes must not be declared final.

## The Table Annotation
In most cases, the name of the table in the database and the name of the entity won't be the same.

In these cases, we can specify the table name using the @Table annotation:
```
@Entity
@Table(name="STUDENT")
public class Student {
    
    // fields, getters and setters
    
}

```
We can also mention the schema using the schema element:
```
@Entity
@Table(name="STUDENT", schema="SCHOOL")
public class Student {
    
    // fields, getters and setters
    
}
```

## The Column Annotation
Just like the @Table annotation, we can use the @Column annotation to mention the details of a column in the table.

The @Column annotation has many elements such as name, length, nullable, and unique:

```
@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String name;
    
    // other fields, getters and setters
}

```
The name element specifies the name of the column in the table. The length element specifies its length. The nullable element specifies whether the column is nullable or not, and the unique element specifies whether the column is unique.

## If we don't specify this annotation, the name of the column in the table will be the name of the field.



# Dependencies used with hibernate
```
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.4.3.Final</version>
</dependency>
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>6.0.6</version>
</dependency>

```
# Dependencies used spring integrted with hibernate

```

<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
<dependency>
    <groupId>commons-dbcp</groupId>
    <artifactId>commons-dbcp</artifactId>
    <version>1.4</version>
</dependency>


<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.3.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/jstl/jstl -->
<dependency>
    <groupId>jstl</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>



<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>


<!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-orm</artifactId>
    <version>5.2.3.RELEASE</version>
</dependency>

hibernate core relocation


<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.2.16.Final</version>
</dependency>


<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>6.0.6</version>
</dependency>


```
For Spring integrated with Hibernate we use applicationContext.xml for configuration details instead of hibernate.cfg.xml

# ApplicationContext.xml incudes:

![image](https://user-images.githubusercontent.com/37985023/166092597-0bda47d2-a819-4fa9-b5fc-e31a6d2c4d70.png)



# Annotations used for replacement of applicationContext.xml

* @Configuration - Annotating a class with the @Configuration indicates that the
                 class can be used by the Spring IoC container as a source of
                bean definitions
* @EnableTransactionManagement - Enables Spring's annotation-driven transaction management capability.
* @Bean
* @Autowired

* This class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
 class in Servlet 3.0+ environments in order to configure the ServletContext
 programmatically -- as opposed to the traditional web.xml-based approach. By overriding the methods of
 class, we can define the Configuration classes and root mapping so that our application can gets
 into spring.
 * @Configuration - Annotating a class with the @Configuration indicates that the
                   class can be used by the Spring IoC container as a source of
                  bean definitions
 * @ComponentScan - this annotation is used to search for the Spring components amongst the application
 * @EnableWebMvc - Adding this annotation to an @Configuration class imports the Spring MVC
 * @EnableWebMvc - It is equivalent to mvc:annotation-driven in XML and it enables front controller to use @RequestMapping defined in our controller class to map incoming requests to anyparticular method.
* @Configuration - It indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
* @ComponentScan - It specifies the base package to scan for different spring beans. If specific packages are not defined, scanning will occur from the package of the class that declares this annotation. So, either we can define following class in a base package or use this annotation.
* class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer ( web.xml )
*Instead of dispatcher-servlet.xml
'''
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ibm")
public class WebMvcConfig implements WebMvcConfigurer 

Mvc Annotations

* @Repository
* @Transactional
* @Controller
* @PostMapping(value="/add")
* @RequestMapping(value = "/updateCustomer")






 



