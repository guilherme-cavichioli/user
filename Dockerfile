#builder
FROM maven:3.6.2-jdk-11 as builder

RUN mkdir --parents /usr/src/app
WORKDIR /usr/src/app

ADD ./target /root/.m2
RUN ls -la /root/.m2

ADD . /usr/src/app
#RUN rm -f /usr/src/app/src/main/resources/application.properties
RUN rm -rf /usr/src/app/target
RUN mvn verify -DskipTests

#runner
#FROM openjdk:8-jdk-alpine
FROM openjdk:11-jre-slim
EXPOSE 8080
COPY --from=builder /usr/src/app/target/*.jar app.jar
ENTRYPOINT java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
