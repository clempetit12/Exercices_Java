
#
FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

# Copie du fichier pom.xml et téléchargement des dépendances
COPY pom.xml .
RUN mvn dependency:go-offline


COPY src ./src
COPY upload-dir ./upload-dir

RUN mvn package -DskipTests


FROM openjdk:17

WORKDIR /app

# Copie de l'artifact JAR depuis l'étape précédente
COPY --from=build /app/target/TP_Blog-0.0.1-SNAPSHOT.jar .

COPY --from=build /app/upload-dir/* .

# Exposition du port 8080
EXPOSE 8080

# Exécution de l'application Spring Boot
ENTRYPOINT ["java", "-jar", "TP_Blog-0.0.1-SNAPSHOT.jar"]