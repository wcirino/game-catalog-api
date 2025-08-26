-- src/test/resources/scripts/schema-test.sql

CREATE TABLE consoles (
    id_console BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    release_year INT NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

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
    active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE physical_games (
    id_physical_game BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    production_studio VARCHAR(150),
    release_year INT,
    production_classification VARCHAR(50),
    id_console BIGINT NOT NULL,
    media_type VARCHAR(50),
    price DECIMAL(10,2),
    stock INT DEFAULT 0,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

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
    active BOOLEAN NOT NULL DEFAULT TRUE
);
