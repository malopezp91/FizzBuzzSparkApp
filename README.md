# FizzBuzzSparkApp

## Run Tests
Unit Test can be executed by:
```
mvn clean test
```

## Create Jar / Release Executable
Jar executable is created by:
``` 
mvn clean package
```

## Execute Jar
Locally, Jar can be executed by:
```
java -jar target/fizzbuzzapp-0.0.1-SNAPSHOT-shaded.jar
```

## HealtCheck endpoint
To validate the application was deployed correctly and is running, execute:
```
curl -GET boiling-sands-95787.herokuapp.com/health
```

