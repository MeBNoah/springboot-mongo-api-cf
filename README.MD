# springboot-mongo-api-cf
Sample showing REST API implementation using Spring Boot and MongoDB as the backend. 
This app connects to another service (node_project_service) and is used for training purpose. 

Note: 

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