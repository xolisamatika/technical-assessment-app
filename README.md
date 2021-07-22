# TECHNICAL ASSESSMENT

## Executing tests :

* running tests :

`./mvnw clean install`

## Compile and run the application

- Compile the application create the JAR file
```
./mvnw package && java -jar target/app.jar
```

- Build the docker container
```
docker build -t technical-assessment-app  .
```

- Make sure port 8080 is not being used, then run the docker container
```
docker run -p 8080:8080 technical-assessment-app
```

- Run the following command to hit the api 
```
curl -X GET localhost:8080/directories
```
