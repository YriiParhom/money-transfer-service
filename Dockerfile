FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 5500

COPY target/card-transfer-back-0.0.1-SNAPSHOT.jar "money-transfer.jar"

CMD ["java", "-jar", "money-transfer.jar"]