# TECHNICAL ASSESSMENT

##Executing tests:

* running tests :

`mvn clean install`

## Compile and run the application

- Compile the application create the JAR file.
```
./mvnw package && java -jar target/app.jar
```

- Build the docker container.
```
docker build -t technical-assessment-app  .
```

- Run the docker container.
```
docker run -p 8080:8080 technical-assessment-app
```

- make sure port 8080 is not being used
