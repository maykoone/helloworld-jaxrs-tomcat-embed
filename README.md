## JAX-RS with Tomcat Embedded
This example show how to run RESTful services using Tomcat as embedded server. 
It consists of only a single resource that returns the well know text "Hello World!".

# Running the application
Navigate to the root directory of the project then run as follow:
> mvn clean compile

Package the application
> mvn package

Finally execute the jar
> java -jar target/helloworld-jaxrs-tomcat-embed-1.0-jar-with-dependencies.jar

You can now access the application at <http://localhost:8080/base/helloworld>

