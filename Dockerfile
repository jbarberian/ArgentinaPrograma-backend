FROM amazoncorretto:11
MAINTAINER joseignaciobar@gmail.com
COPY target/SpringBoot3-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
