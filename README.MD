# springboot-mongo-api-cf
Sample showing REST API implementation using Spring Boot and MongoDB as persistence mechanism. 
Note that there is no explicit configuration for connecting to the MongoDB. SpringBoot does some voodoo magic under the hood. When running locally it assumes mongodb runs under localhost using the default port. You could change that by simply adding the following line to the [application.properties](src/main/resources/application.properties): spring.data.mongodb.uri = mongodb://localhost:27017/users

When running on Cloud Foundry, the Auto Reconfiguration of the Java Buildpack while kick in, which recognizes that there is a MongoDB service bound to the application and inject the respective Spring Bean in order to work with the DB.  

## Run locally
* `docker pull mongo`
* `docker run -d -p 27017:27017 mongo`
* `mvn clean spring-boot:run`

## Run on Cloud Foundry
* `mvn clean install`
* create a mongo db service in Cloud Foundry named `mongodb`
* `cf push`

## Endpoints

### Create user 
`curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"firstname": "noah", "lastname": "ispas"}' http://localhost:8080/user`

### Get all user
`curl -X GET http://localhost:8080/user`

### Get user detail 
`curl -X GET http://localhost:8989/user/<id>`

### Update user 
`curl -H "Accept: application/json" -H "Content-type: application/json" -X PUT -d '{"firstname": "noah", "lastname": "ispas", "age": 18, , "email": "no@ah.com", "twittername": "mebnoah"}' http://localhost:8989/user/<id>`

### Delete user 
`curl -X DELETE http://localhost:8989/user/<id>`