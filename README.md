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

### Local
```bash
mvn spring-boot:run

docker build -t game-catalog-api .
docker run -p 8085:8085 game-catalog-api

mvn test
