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
    genre VARCHAR(100) NOT NULL,
    production_studio VARCHAR(150),
    release_year INT,
    production_classification VARCHAR(50),
    id_console BIGINT NOT NULL,
    size_gb DECIMAL(6,2),
    distribution_platform VARCHAR(100),
    price DECIMAL(10,2),
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
    genre VARCHAR(100) NOT NULL,
    production_studio VARCHAR(150),
    release_year INT,
    production_classification VARCHAR(50),
    id_console BIGINT NOT NULL,
    media_type VARCHAR(50), -- Disc, Cartridge, Blu-ray
    price DECIMAL(10,2),
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
    genre VARCHAR(100) NOT NULL,
    production_studio VARCHAR(150),
    release_year INT,
    production_classification VARCHAR(50),
    id_console BIGINT NOT NULL,
    server_region VARCHAR(100),
    max_players INT,
    monthly_fee DECIMAL(10,2),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_online_console FOREIGN KEY (id_console)
        REFERENCES consoles(id_console)
);
