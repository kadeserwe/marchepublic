FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/demo.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
#./target/demo.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]