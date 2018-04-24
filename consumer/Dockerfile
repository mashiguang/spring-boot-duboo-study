FROM java:8

ADD "target/consumer-0.0.1-SNAPSHOT.jar" app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 20880

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]