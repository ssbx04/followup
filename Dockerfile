FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

# Copier les fichiers Maven
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Télécharger les dépendances
RUN ./mvnw dependency:go-offline

# Copier le code source
COPY src src

# Builder l'application
RUN ./mvnw package -DskipTests

# Phase finale - image légère
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copier le JAR depuis la phase build
COPY --from=build /workspace/app/target/*.jar app.jar

# Exposer le port
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]