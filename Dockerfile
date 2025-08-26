# Imagem base enxuta com JDK 17
FROM openjdk:17-jdk-slim

# Definição do diretório de trabalho dentro do container
WORKDIR /app

# Copia apenas o jar gerado pelo Maven
COPY target/game-catalog-api-*.jar app.jar

# Define a porta que o container vai expor
EXPOSE 8085

# Ponto de entrada do container
ENTRYPOINT ["java", "-jar", "app.jar"]