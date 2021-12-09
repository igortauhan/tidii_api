# TID II - API

A Spring Boot API Rest for college work. This API is responsible for integrating and communicating an Arduino on the App.

This API is used by my other project -> [TID II - APP](https://github.com/igortauh/tidii_app)

## How to run this project 

### First, install the dependencies:

- Java
- Docker and Docker Compose
- Any application for requisitions tests, like Postman

### Build the Java project

Before you up the docker-compose, you need to build the Jar file. With the JDK installed, just run ***./mvwn clean package***, this will build and generate the Jar file. That is necessary because the Dockerfile will use to run the project.

### Docker Compose

With the Jar file, enter in the root of the project, run ***sudo docker-compose up*** to run the docker-compose. The docker-compose file will run the Java and Postgres images. The API will run on the ***8080*** port and the Postgres on the ***5432***.

The docker-compose file defines a database with the ***optimusapi*** name, with the user ***postgres*** and the password ***12345***. The database will be created and seeded when the docker-compose starts.

## Project structure

This project has two profile files, the test and dev files.

The test profile use the h2-database. The database will seed with the TestConfig file. The TestConfig file is located inside the src/../../../../optimusapi/config folder. This file has a private attribute with dependency injection, the DBService. The DBService is located inside the services folder and has a method that will seed the database.

The dev profile use the Postgres DB. He has some configurations that will connect with the database, like username and password of the database. The database URL is inside the docker-compose file, in the root of the project.

To develop the project, i recommend comment the ***SPRING_DATASOURCE_URL*** line inside the docker-compose file and define ***spring.profiles.active=test*** in the application.properties file, this will use the test profile. Later, rebuild the project again, just run ***./mvwn clean package***.

## How the API works

This API contains endpoints for districts and streets. All endpoints related to districts contain the ***/districts*** signature and all endpoints related to streets contain the ***/streets*** signature.

> The 8080 inside the URL is equal to the port that the API is running.

***DISTRICTS***:

***GET***

URL = ***localhost:8080/distrcts*** -> GET = Return a JSON with all districts.

URL = ***localhost:8080/distrcts/{id}*** -> GET = Return a JSON with a district related with the id.

URL = ***localhost:8080/distrcts/name/{name}*** -> GET = Return a JSON with a district related with the name.

***POST***

URL = ***localhost:8080/distrcts*** -> POST = With the required fields inside the request body, insert a district.

***PUT***

URL = ***localhost:8080/distrcts/{id}*** -> PUT = With the required fields inside the request body, update a district related with the id.

#

***STREETS***

***GET***

URL = ***localhost:8080/streets*** -> GET = Return a JSON with all streets.

URL = ***localhost:8080/streets/district/{districtId}*** -> GET = Return a JSON with all streets related with the id.

URL = ***localhost:8080/streets/{id}*** -> GET = Return a JSON with a street related with the id.

URL = ***localhost:8080/streets/name/{name}*** -> GET = Return a JSON with a street related with the name.

***POST***

URL = ***localhost:8080/streets*** -> POST = With the required fields inside the request body, insert a street.

***PUT***

URL = ***localhost:8080/streets/{id}*** -> PUT = With the required fields inside the request body, update a street related with the id.
