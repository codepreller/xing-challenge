# solution for the xing qa coding challenge 

an automated test suite of the reqres api 

## requirements / tested with:
- Java JDK 8 (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- Maven 3.3.9 (https://maven.apache.org/install.html)

## technology stack:
- serenity bdd (reporting framework)
- cucumber jvm
- rest assured
- junit/hamcrest

## installation:
- the easiest way to install the test suite is to clone the repository with an ide like intellij.
- if you dont want to, you can install the jdk, maven (make sure you add them both to your system path) and clone the repository. 

## execution:
- if you chose the ide variant you can execute the suite by executing **clean** followed by a **verify**.
- if you chose the second variant you can switch to the root folder of the project and execute it via: `mvn clean verify`

## reporting:
- serenity bdd creates a neat test report (if you executed verify). you can find the index.html under target/site/serenity/ after the suite run

## architecture overview:
- the test runner is implemented in test/java/de/xing/APITest.java
- features are descriped in test/resources/features and written in gherkin
- the glue code is implemented in test/java/de/xing/steps
- an API/URL helper class is implemented in main/java/de/xing/api/ReqresAPI.java
- models are implemented in main/java/de/xing/model