# Getting Started

#How to install the application

[Windows]
`gradlew.bat clean build bootRun` 

[ Linux/MacOS]
`./gradlew clean build bootRun` 

#How to test UI
Go to `http://localhost:9090`
It will show two links: one for User and the other for Flights

#How to run Restful Service

Use postman:

To retrieve all flights: 
- Set the request to GET 
- Set URL to `http://localhost:9090/flightrest/findAll`

To add/update flight:
- Set the request to POST
- Set URL to `http://localhost:9090/flightrest/update`
- Go to Body and choose raw and MIME type from text to JSON and enter JSON payload, for example

`{
         "id": 1,
         "number": "AF101",
         "flightDate": "10/25/2019",
         "fromAirport": "DFW",
         "toAirport": "HOU"
     }`
- Keep the same flight number if you want to modify existing flight or it will create a new flight

#How to test SOAP Based Web Services

- Use the following URL to test in SOAPUI `http://localhost:9090/ws/flights.wsdl`
- Use SOAPUI to load the following [soapui](soapui/flights-soapui-project.xml) 
- Example [screenshot](soapui/SoapUI-ScreenShot.png)

#How to test RabbitMQ Messages
- Install Rabbit MQ Server using the [installer link](https://www.rabbitmq.com/download.html)
- Start running rabbitmq server 
- Login to rabbitmq server using URL: http://localhost:15672/#/queues/%2F/flight-queue
    _**User/password: guest/guest**_ 
- You will see the following Queue: [flight queue](rabbitmq/RabbitMQScreenshot.png)
- Use the following URL to post messages in Postman: `
http://localhost:9090/message/post`
- Message example: 
`{
	"message":"Testing",
	"count":1000
}` 
Here message is Testing and Number of messages is 1000.


### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/gradle-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Data JDBC](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-sql)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-webservices)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/2.2.0.RELEASE/reference/htmlsingle/#boot-features-amqp)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

