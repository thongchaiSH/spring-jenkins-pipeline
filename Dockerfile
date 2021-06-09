FROM adoptopenjdk/openjdk11

ENV TZ=Asia/Bangkok

RUN mkdir -m 777 -p /usr/src/app/
RUN mkdir -m 777 -p /logs

COPY target/app-0.0.1-SNAPSHOT.jar /usr/src/app/app.jar

WORKDIR /usr/src/app

CMD ["java", "-jar", "-Xms256m", "-Xmx512m", "/usr/src/app/app.jar"]


