-- ===============================================
-- Database creation
-- ===============================================
DROP DATABASE IF EXISTS game_catalog;
CREATE DATABASE game_catalog
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE game_catalog;

-- ===============================================
-- Table: consoles
-- ===============================================
CREATE TABLE consoles (
    id_console BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    release_year INT NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

-- ===============================================
-- Table: digital_games
-- ===============================================
CREATE TABLE digital_games (
    id_digital_game BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(1000),
    genre VARCHAR(100) NOT NULL,
    release_year INT,
    platform VARCHAR(50),                         -- ex: PC, PS5
    production_studio VARCHAR(150),
    production_classification VARCHAR(50),
    id_console BIGINT NOT NULL,
    price DECIMAL(10,2),
    activation_key VARCHAR(100),                  -- chave de ativação
    digital_store VARCHAR(100),                   -- ex: Steam, PSN
    download_size DECIMAL(6,2),                   -- tamanho em GB
    license_expiration DATE,                      -- expiração da licença
    active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_digital_console FOREIGN KEY (id_console)
        REFERENCES consoles(id_console)
);

-- ===============================================
-- Table: physical_games
-- ===============================================
CREATE TABLE physical_games (
    id_physical_game BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(1000),
    genre VARCHAR(100) NOT NULL,
    release_year INT,
    platform VARCHAR(50),                         -- ex: PS2, Xbox 360
    production_studio VARCHAR(150),
    production_classification VARCHAR(50),
    id_console BIGINT NOT NULL,
    price DECIMAL(10,2),
    media_type VARCHAR(50),                       -- Disc, Cartridge, Blu-ray
    condition_status VARCHAR(50),                 -- New, Used, Special Edition
    manual_language VARCHAR(50),                  -- idioma do manual
    has_box BOOLEAN DEFAULT TRUE,                 -- tem caixa original
    stock INT DEFAULT 0,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_physical_console FOREIGN KEY (id_console)
        REFERENCES consoles(id_console)
);

-- ===============================================
-- Table: online_games
-- ===============================================
CREATE TABLE online_games (
    id_online_game BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(1000),
    genre VARCHAR(100) NOT NULL,
    release_year INT,
    platform VARCHAR(50),                         -- ex: PC, PS4, Xbox
    production_studio VARCHAR(150),
    production_classification VARCHAR(50),
    id_console BIGINT NOT NULL,
    price DECIMAL(10,2),
    server VARCHAR(100),                          -- região do servidor
    multiplayer BOOLEAN,
    subscription_period VARCHAR(50),              -- Monthly, Annual
    max_players INT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_online_console FOREIGN KEY (id_console)
        REFERENCES consoles(id_console)
);
