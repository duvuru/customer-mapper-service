# Spring Boot CustomerMapperService Project

This is a sample Java / Maven / Spring Boot (version 2.6.6) application that can be used as a starter for creating a microservice. I hope it helps you.

## How to Run 

This application is packaged as a jar which has Tomcat embedded. No Tomcat installation is necessary. You can run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 11 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar -Dspring.profiles.active=test target/spring-boot-rest-example-0.5.0.war
or
        Run CustomerMapperServiceApplication java application
```

Once the application runs you should see something like this

```
2022-04-09 20:12:52.189  INFO 11292 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-04-09 20:12:52.220  INFO 11292 --- [           main] c.r.c.CustomerMapperServiceApplication   : Started CustomerMapperServiceApplication in 12.124 seconds (JVM running for 13.616)

```

## About the Service

The service is just a simple Customer REST service. It uses an in-memory database (H2) to store the data. 

Here are some endpoints you can call:

### GET information about externalId for the passed customerId

```
http://localhost:8080/customerService/getExernalId/{customerId}

RESPONSE: <externalId> Eg: df313eac-bb61-4791-8523-8f4405a42cfc
```

### POST Create a Customer Record

```
http://localhost:8080/customerService/saveCustomer

POST 
Accept: application/json
Content-Type: application/json

{
      "customerId": "1003",
      "createdAt":"2022-03-08"
}

RESPONSE: HTTP 201 (Created)

```



