# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo JAR de la aplicación Spring Boot al contenedor
COPY target/appStudy-1.0.0.jar app.jar

# Exponer el puerto 8080 (el puerto en el que se ejecutará tu aplicación Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]

