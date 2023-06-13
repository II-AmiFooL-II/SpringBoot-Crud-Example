# SpringBoot Crud Example

## Requirements
For building and running the application you need:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle 8](https://gradle.org)

### URL ENDPOINTS
- GET all Servers : /Servers
- PUT Server : /Servers
- DELETE Server : /Servers/{id}
- GET Servers by id : /Servers/{id}
- GET Servers by name : /Servers/{name}

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
Gradle Build
java -jar MyJavaBuild.jar
```

## Working Images

PUT Server Request 

![alt text](TestingPictures/CreateServers.png?raw=true)

&nbsp;&nbsp;

DELETE Server Request

![alt text](TestingPictures/DeleteId.png?raw=true)

&nbsp;&nbsp;

GET all Servers Request

![alt text](TestingPictures/GetAll.png?raw=true)

&nbsp;&nbsp;

GET Server by Id Request

![alt text](TestingPictures/GetAllId.png?raw=true)

&nbsp;&nbsp;

GET Servers by Name Request

![alt text](TestingPictures/GetAllName.png?raw=true)
