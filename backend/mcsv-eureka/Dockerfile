# Usa una imagen base de OpenJDK 17 con la versión slim (ligera) del JDK.
# Esta imagen incluye el entorno de Java necesario para ejecutar aplicaciones
FROM openjdk:17-jdk-slim as build

# Copia el archivo JAR generado (la aplicación Spring Boot empaquetada) desde ../target
# y lo coloca en el contenedor en el directorio /home. 
# Cambia "eureka_server-0.0.1-SNAPSHOT.jar" según el nombre exacto del archivo generado.
ADD ../target/mcsv-eureka-0.0.1-SNAPSHOT.jar /home/servite3it-eureka.jar

# Expone el puerto 8761 del contenedor para que sea accedido por el host
# Este puerto es usado por el servidor Eureka
EXPOSE 8761

# Define el punto de entrada del contenedor.
# Ejecuta el comando para iniciar la aplicación Java, pasando opciones adicionales:
# `-Djava.security.egd=file:/dev/./urandom`: Acelera la generación de números aleatorios
# en entornos donde `/dev/random` puede ser lento, útil para mejorar el rendimiento.
# `-jar /home/servite3it-eureka.jar`: Especifica el archivo JAR que se debe ejecutar.
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/servite3it-eureka.jar"]