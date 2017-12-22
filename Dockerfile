FROM cjmason8/ubuntu-java8:latest

RUN mkdir /app
COPY target/pdfcollator-0.0.1-SNAPSHOT.jar /app/pdfCollator.jar

RUN sh -c 'touch /app/pdfCollator.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/pdfCollator.jar"]
