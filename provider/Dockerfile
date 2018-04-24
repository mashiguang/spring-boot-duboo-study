FROM java:8

ADD "target/provider-0.0.1-SNAPSHOT.jar" app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 20880

ENTRYPOINT ["java", "-Ddubbo.protocol.host=192.168.1.213 -Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]