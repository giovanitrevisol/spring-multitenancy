# Multitenant Spring Boot Application

This is a sample application that demonstrates how to build a multitenant application using Spring Boot.

## Running the application

### Using Docker
execute docker-compose up in the root directory of the project: **sandbox/services/** <br/>
`docker-compose up`

#### Create two databases
`tenant1` and `tenant2`

### Curl

GET
````
curl --location 'localhost:8080/employee' \
--header 'X-TenantID: tenant_2'
````
POST
````
curl --location 'localhost:8080/employee' \
--header 'X-TenantID: tenant_2' \
--header 'Content-Type: application/json' \
--data 'tenant22'
````


