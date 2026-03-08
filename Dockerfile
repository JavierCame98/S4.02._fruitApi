# ETAPA 1: Construcción (Build)
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copiar archivos de configuración de Maven/Gradle y descargar dependencias
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline

# Copiar el código fuente y compilar el .jar (saltando los tests para velocidad)
COPY src ./src
RUN ./mvnw clean package -DskipTests

# ETAPA 2: Producción (Runtime)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar solo el artefacto compilado desde la etapa anterior
COPY --from=build /app/target/*.jar fruit-api.jar

# Configuración de seguridad y ejecución
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "fruit-api.jar"]