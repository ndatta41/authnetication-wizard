#
# Build stage
#
FROM maven:3.6.3 AS build
COPY src /home/acer/NewF/app/src
COPY pom.xml /home/acer/NewF/app/pom.xml
RUN mvn -f /home/acer/NewF/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/acer/NewF/app/target/authentication-wizard.jar /usr/local/lib/authentication-wizard.jar
EXPOSE 9003
ENTRYPOINT ["java","-jar","/usr/local/lib/authentication-wizard.jar"]
