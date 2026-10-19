FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY web ./web
RUN mvn -B -DskipTests package

FROM tomcat:9.0-jdk21-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/fsd2-web.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
