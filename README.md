# Multitenant Spring Boot Application

This is a sample application that demonstrates how to build a multitenant application using Spring Boot.

## Running the application

### Using Docker
execute docker-compose up in the root directory of the project: **sandbox/services/** <br/>
`docker-compose up`

### Curl
GET
````
curl --location 'localhost:8080/employee'
````
POST
````
curl --location --request POST 'localhost:8080/employee'
````

