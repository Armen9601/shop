# Shop service

[Spring Boot](http://projects.spring.io/spring-boot/) app.

## Requirements

For building and running the application you need:

- JDK 17
- Maven 3
- H2

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `src/main/java/com/example/shop/ShopApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

## Or

follow the steps below:

git clone https://github.com/Armen9601/shop.git

cd <project-directory>

mvn clean package

java -jar target/shop-0.0.1-SNAPSHOT.jar

