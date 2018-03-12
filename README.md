# Suscription web application

## Build and run

### Quick

Just execute

`$ ./runMe.sh`

This will build and deploy all the services and also the frontend. Everything is ready when in your default browser the main page of the application is open.

> http://localhost:3000

### Manually

Go to each of of the following folders `discovery-service`,`email-service`,`event-service`,`suscription-service` and inside of each folder execute the command `mvn spring-boot:run` this will start the service in the default ports.

Then go to `suscription-portal` and execute `npm install` and then `npm start`, this will open in the browser the http://localhost:3000 url.


## Documentation

Each of the three services has their own swagger page.

##### Open API

suscription-service API documentation http://localhost:8081/swagger-ui.html

##### Secured API

The following is the documentation of the two secured services "event-service" and "email-service". Once you open the swagger page, you will see that in order to test those services you need to provide a token. For example sake, I hardcode the token in the three services, but the idea would be to create another service where the suscription-service will login and get a token that can be shared all over the rest of services. This session could be stored in redis. The token value is "3lGknM49r2 "

http://localhost:8081/swagger-ui.html
http://localhost:8082/swagger-ui.html


## Libraries used

#### Backend

* Spring boot: Used to create a serverless web application.
* Spring web: For create all the controllers and routers.
* Hystrix: For implement the faultback strategy.
* Zuul: Proxy load balancer, we are using eureka for service discovery, so Zuul is not relevant for this test. Anyway I keep it because the service could be extend to support the consume of multiple api using only one entry point.
* Feign: Declarative HTTP client for consume event-service and email-service.
* Hibernate: I used the Hibernate JPA implementation for data access.
* H2 database: In memory embedded database
* Eureka: Service discovery library, the three services register in Eureka and from there the communication starts.
* Swagger: Just for create the swagger documentation page.

#### Frotend 

* React: web components library.
* React-router: browser router library, used to show pages depending of the url.
* Redux: Used to implement the flux pattern, I used it for change the main state of the application store.
* React inform: Library for form validation, with this the code could be more cleaner than usual.
* Bootstrap: I used mostly the grid system and the flexbox too.
* React Semantic UI: React UI components, like buttons, Input fields, messages.etc. 
* MomentJS: Used for set the date into the react-datepicker
* React datepicker: Used for set the date into the react-datepicker
* SASS: CSS preprocessor.

#### Pipeline proposal
I would create pipelines in each project, so when somebody commit into master, the pipeline will call a CI that will build run maven tests, build the docker image and deploy to ECS. 

