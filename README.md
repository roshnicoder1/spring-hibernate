# spring-hibernate

* @Entity
* @Table(name="stu500")
* @Id
* @Component
* @Column(name="custno")
* hibernate.cfg.xml or hibernate.properties  In hibernate framework, we provide all the database information and configuration details.
* employee.hbm.xml

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






 



