FROM maven:3.6.3-openjdk-15-slim AS MAVEN_BUILD
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package -Dmaven.test.skip=true
COPY target/ /build/target/

FROM openjdk:15-alpine
COPY --from=MAVEN_BUILD /build/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]