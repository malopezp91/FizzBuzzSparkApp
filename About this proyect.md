# FizzBuzzApp Discussion

In this document, I will briefly descrive the process to solve the given problem and technical details about it.

## Problem to solve
Create a Web API so when the user inputs a number, all FizzBuzz numbers from 1 to that number are retrieved.

## Solution
The application/UI can be found in here:
https://evening-lake-92251.herokuapp.com/

The REST API lives in here:
https://boiling-sands-95787.herokuapp.com/

#### Used technologies
The BackEnd runs in Java Spark. Dependency Injections are performed by Guice and outputs parsed using Gson. Unit Tests are executed by JUnit and Maven is used for dependency management and application lifecycle. 

The FrontEnd is developed in Angular 1.6. and running over NodeJs.  

Both the BackEnd and the FrontEnd are hosted in Heroku. Both are running on the free tier so no costs!

#### Where is the code?
The BackEnd Repository is: https://github.com/malopezp91/FizzBuzzSparkApp
The FrondEnd Repository is: https://github.com/malopezp91/FizzBuzzAppUi

#### Technical details
Two Endpoints where generated in order to retrieve the FizzBuzz numbers. 

The first Endpoint, when called with a valid number, FizzBuzz numbers are retrieved as a JSON. Currently, as limit of 10,000 is set in the backend. When calling this endpoint with a value higher than 10,000, a 400 Error is Thrown.

{"fizzBuzz":"1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz"}

The other Endpoint was intended for high traffic. Instead of retrieving a String with all the numbers from 1 to N, a Map is retrieved with only the numbers that should be changed as Fizz or Buzz. This Map is easier to be used by the client to know if number X is Fizz, Buzz, or should stay the same. 

{"fizzBuzz":{"3":"Fizz","5":"Buzz","6":"Fizz","9":"Fizz","10":"Buzz"}}


#### Another approach
Due of lack of time, I couldn't explore another approach, which used Information At Rest. In this approach, when a request is received, a json file with all FizzBuzz numbers is stored in the Server. When another request is received looking for the same number, this file is sent to the cliend and the FizzBuzz algorithm won't be executed. 
This approach can go further by placing the json file into an external repository, such as AWS S3, so instead of retrieving the FizzBuzz numbers from my server, the client will retrieve a URL from S3 where he can look for the data.


