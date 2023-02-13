FROM eclipse-temurin:17-focal
WORKDIR /libraryapp

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY ./mvnw dependency:go-offline
COPY src ./src

CMD ["./mvnw","spring-boot:run"]