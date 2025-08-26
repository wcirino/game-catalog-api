# 🎮 Game Catalog API

API REST para gerenciamento de jogos digitais, físicos e online.  
Permite cadastrar, consultar, atualizar e filtrar jogos de diferentes formatos, com base em uma estrutura organizada por entidades, DTOs, serviços e controladores.

---

## 🚀 Tecnologias
- **Java 17+**  
- **Spring Boot 3**  
- **Spring Data JPA**  
- **H2 / MySQL (configurável)**  
- **Docker**  
- **JUnit 5 / Mockito**  

---

## ⚙️ Configuração

- **Banco de dados:** `games` (nome físico `game_catalog`)  
- **Porta padrão da aplicação:** `8085`  
- **Scripts:**  
  - Estrutura: [`schema.sql`](src/main/resources/scripts/schema.sql)  
  - Dados iniciais: [`data.sql`](src/main/resources/scripts/data.sql)  

---

## 📂 Estrutura do Projeto


---

## 📖 O que o sistema faz?

O **Game Catalog API** permite:  
- Gerenciar **jogos digitais** (ex.: Steam, PS Store, Xbox Live)  
- Gerenciar **jogos físicos** (Blu-ray, cartucho, edição especial)  
- Gerenciar **jogos online** (servidores, multiplayer, assinatura)  
- Consultar, filtrar e listar jogos com base em critérios dinâmicos  

---

## 📡 Endpoints principais

### 🎮 Jogos Digitais
- `GET /api/digital` → Lista todos os jogos digitais  
- `GET /api/digital/{id}` → Busca jogo digital por ID  
- `POST /api/digital` → Cadastra novo jogo digital  
- `PUT /api/digital/{id}` → Atualiza jogo digital  
- `DELETE /api/digital/{id}` → Remove jogo digital  

### 💿 Jogos Físicos
- `GET /api/physical` → Lista todos os jogos físicos  
- `GET /api/physical/{id}` → Busca jogo físico por ID  
- `POST /api/physical` → Cadastra novo jogo físico  
- `PUT /api/physical/{id}` → Atualiza jogo físico  
- `DELETE /api/physical/{id}` → Remove jogo físico  

### 🌐 Jogos Online
- `GET /api/online` → Lista todos os jogos online  
- `GET /api/online/{id}` → Busca jogo online por ID  
- `POST /api/online` → Cadastra novo jogo online  
- `PUT /api/online/{id}` → Atualiza jogo online  
- `DELETE /api/online/{id}` → Remove jogo online  

### 🔍 Filtros
- `POST /api/digital/filter`  
- `POST /api/physical/filter`  
- `POST /api/online/filter`  

---

## ▶️ Como rodar

- mvn clean package -DskipTests
- docker build -t game-catalog-api:latest .
- docker run -d --name game-catalog-api-dev --network docker_global-rede -p 8085:8085 -e SPRING_PROFILES_ACTIVE=docker -e SPRING_APPLICATION_NAME=game-catalog-api-dev game-catalog-api:latest

🚀 Actuator Endpoints

A API utiliza o Spring Boot Actuator para expor endpoints de monitoramento e métricas.

Lista de endpoints expostos
👉 http://localhost:8085/actuator

Health check
👉 http://localhost:8085/actuator/health

Informações da aplicação
👉 http://localhost:8085/actuator/info

Métricas disponíveis
👉 http://localhost:8085/actuator/metrics

Exemplo de métrica específica
👉 http://localhost:8085/actuator/metrics/jvm.memory.used


### Local
```bash
mvn spring-boot:run

docker build -t game-catalog-api .
docker run -p 8085:8085 game-catalog-api

mvn test

## Estrutura api

game-catalog-api
├── pom.xml
├── Dockerfile
├── .gitignore
├── src
│ ├── main
│ │ ├── java/com/games/api
│ │ │ ├── controller # Controllers REST (endpoints)
│ │ │ ├── dto # Objetos de transferência (DTOs)
│ │ │ ├── entity # Entidades JPA
│ │ │ ├── enums # Enumerações
│ │ │ ├── repository # Repositórios + Specifications
│ │ │ ├── service # Interfaces e implementações de serviços
│ │ │ └── GameCatalogApiApplication.java
│ │ └── resources
│ │ ├── application.yml
│ │ ├── application-dev.yml
│ │ ├── application-hml.yml
│ │ ├── application-docker.yml
│ │ └── scripts
│ │ ├── schema.sql
│ │ └── data.sql
│ └── test/java/com/games/api
│ ├── controller # Testes dos controllers
│ └── service # Testes dos services

