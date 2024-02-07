FROM maven:4-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -Dmaven.test.skip=true
FROM eclipse-temurin:21-alpine
COPY --from=build /target/[YOUR APP NAME & VERSION].jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]