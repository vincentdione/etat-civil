FROM openjdk:17-jdk
WORKDIR /app
COPY target/gestion-document-0.0.1-SNAPSHOT.jar  /app/gestion-doc.jar
EXPOSE 8082
CMD ["java","-jar","gestion-doc.jar"]
