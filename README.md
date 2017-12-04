# Integristore - Shopping Cart Example

This example is an app that provides a solution for a shopping cart using AngularJS, Java and Docker. The development took almost 20 hours of coding. Here is the solution's stack:

- [SpringBoot](https://projects.spring.io/spring-boot/) is used to provide container's boot and MVC support.
- [Docker](https://www.docker.com/) is used for containerization.
- [MySQL](https://www.mysql.com/) is used for entity persistence.
- [Swager](https://swagger.io/) is used for API tooling and REST documentation.
- [Lombok](https://projectlombok.org/) powerful annotations.
- [Jackson](https://github.com/FasterXML/jackson) is used to serialize objects to JSON.


## Missing Requirements (Due to test timeout)

- Solution does not make use of ActiveMQ or any other queue for scaling purposes.
- Container's orchestration is missing, although the app is provisioned using Docker.
- Just one microservice was provided, so the backend is a monolit.
- The cart's product counter is just kept in the frontend app.


## My personal standards missing (Due to test timeout)

- There is no backend endpoint testing with in-memory database. I feel ashamed for that :(
- Was not able to do some front end refactoring. I realised that I should have coded some other additional directives.
- I also use Flyway to manage relational database migrations.


## Containers

![Alt text](/containers.png?raw=true "Optional Title")


## Build

- FrontEnd App

It is required to build prior to deploying. You must build the deployment artifact using Docker:

```bash
$ cd integristore-front
$ docker build -t integristore-front .
```

In order to run the container:

```bash
$ cd integristore-front
$ docker run --name integristore-front -p 8081:80 -d integristore-front
```

*Ps. The frontend is reaching the backend through address: http://127.0.0.1. Due to test time out I was not able to parameterize it. 

- Database

It is required to build the database container and run the DDL script. You must build using Docker:

```bash
$ docker run --name integristore-db -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=integristore -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin -p 3307:3306 -d mysql:5.6
```

Now you have a MySQL instance running, run the following script:

```bash
integristore-back/src/main/resources/ddl.sql
```

- BackEnd

It is required to build prior to deploying. You must build the deployment artifact using Docker:

```bash
$ cd integristore-back
$ mvn clean package docker:build
```

Now you have a Backend image, run the following script in order to run the backend and link to database:

```bash
$ docker run -p 8080:9000 --name integristore-back --link integristore-db:integristore-db -d integristore/integristore.back
```

