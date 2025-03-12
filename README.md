# User
## Definition
Users crud project using postgres relational database with unit tests and integrated tests using h2 for company Itau.

**Programming language:** Java 11

**Framework:** Spring boot, with the following libraries:
- Lombok
- Postgresql
- Mapstruct
- H2

## Quick Start
Property definition file:
```yml
server:  
  port: 8080  
  servlet:  
    context-path: /user-service  
spring:  
  datasource:  
    url: jdbc:postgresql://postgres:5432/user-db  
    username: postgres  
    password: senha  
  jpa:  
    hibernate:  
      ddl-auto: update  
    properties:  
      hibernate:  
        dialect: org.hibernate.dialect.PostgreSQLDialect
```
Test properties definition file:

```yml
hibernate:  
  dialect: org.hibernate.dialect.H2Dialect  
  hbm2ddl:  
    auto: create  
jdbc:  
  driverClassName: org.h2.Driver  
  url: jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1

``` 


**Start project**
To start the project you will need to install the following dependencies:
https://docs.docker.com/engine/install/
https://docs.docker.com/compose/install/

Clone using ssh: `git clone git@gitlab.com:guicavicci/user.git`
Clone using https: `https://gitlab.com/guicavicci/user.git`


Alter installation, run the following commands at the project root:
**docker-compose up**

**Using application**

To test the endpoints, you will need to import the collection located at the project root:

> User.postman_collection.json