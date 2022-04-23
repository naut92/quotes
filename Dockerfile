FROM openjdk:8-jdk-alpine
RUN addgroup -S echo && adduser -S echo -G echo
USER echo:echo
ARG JAR_FILE=target/*.jar
COPY /build/libs/quotes-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
