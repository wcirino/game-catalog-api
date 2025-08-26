-- Consoles
INSERT INTO consoles (name, manufacturer, release_year) VALUES
('PlayStation 2', 'Sony', 2000),
('PlayStation 3', 'Sony', 2006),
('PlayStation 4', 'Sony', 2013),
('PlayStation 5', 'Sony', 2020),
('Xbox 360', 'Microsoft', 2005),
('Xbox One', 'Microsoft', 2013),
('Xbox Series X', 'Microsoft', 2020),
('Nintendo Switch', 'Nintendo', 2017);

-- Consoles adicionais
INSERT INTO consoles (name, manufacturer, release_year) VALUES
('Super Nintendo Entertainment System (SNES)', 'Nintendo', 1990),
('Nintendo Entertainment System (NES)', 'Nintendo', 1983),
('Nintendo GameCube', 'Nintendo', 2001),
('Nintendo Wii', 'Nintendo', 2006),
('Nintendo Wii U', 'Nintendo', 2012),
('Game Boy', 'Nintendo', 1989),
('Game Boy Advance', 'Nintendo', 2001),
('Nintendo DS', 'Nintendo', 2004),
('Nintendo 3DS', 'Nintendo', 2011),
('Sega Master System', 'Sega', 1985),
('Sega Genesis (Mega Drive)', 'Sega', 1988),
('Sega Saturn', 'Sega', 1994),
('Sega Dreamcast', 'Sega', 1998),
('Atari 2600', 'Atari', 1977),
('Atari Jaguar', 'Atari', 1993),
('PlayStation Portable (PSP)', 'Sony', 2004),
('PlayStation Vita', 'Sony', 2011),
('Neo Geo AES', 'SNK', 1990),
('Commodore 64', 'Commodore', 1982),
('PC Engine (TurboGrafx-16)', 'NEC', 1987);

-- Physical Games
INSERT INTO physical_games (title, genre, release_year, production_studio, media_type, price, id_console)
VALUES
('God of War II', 'Action', 2007, 'Santa Monica Studio', 'DVD', 79.90, 1),
('Halo 3', 'Shooter', 2007, 'Bungie', 'DVD', 99.90, 5),
('The Last of Us', 'Adventure', 2013, 'Naughty Dog', 'Blu-ray', 129.90, 2),
('Uncharted 4: A Thief''s End', 'Adventure', 2016, 'Naughty Dog', 'Blu-ray', 159.90, 3),
('Gran Turismo 7', 'Racing', 2022, 'Polyphony Digital', 'Blu-ray', 299.90, 4),
('Halo 5: Guardians', 'Shooter', 2015, '343 Industries', 'Blu-ray', 149.90, 6),
('Forza Horizon 5', 'Racing', 2021, 'Playground Games', 'Blu-ray', 299.90, 7),
('Super Mario Odyssey', 'Platformer', 2017, 'Nintendo', 'Cartridge', 249.90, 8);

-- Digital Games
INSERT INTO digital_games (title, genre, release_year, production_studio, distribution_platform, price, size_gb, id_console)
VALUES
('Minecraft', 'Sandbox', 2011, 'Mojang', 'Steam', 99.90, 5.50, 8),
('Cyberpunk 2077', 'RPG', 2020, 'CD Projekt Red', 'PSN', 249.90, 70.00, 4),
('The Witcher 3: Wild Hunt', 'RPG', 2015, 'CD Projekt Red', 'GOG', 149.90, 40.00, 8),
('Elden Ring', 'RPG', 2022, 'FromSoftware', 'PSN', 299.90, 45.00, 4),
('Hades', 'Action', 2020, 'Supergiant Games', 'Nintendo eShop', 99.90, 6.00, 8),
('Stardew Valley', 'Simulation', 2016, 'ConcernedApe', 'Steam', 39.90, 1.50, 8);

-- Online Games
INSERT INTO online_games (title, genre, release_year, production_studio, server_region, max_players, monthly_fee, id_console)
VALUES
('Fortnite', 'Shooter', 2017, 'Epic Games', 'US East', 100, 0.00, 3),
('World of Warcraft', 'MMORPG', 2004, 'Blizzard', 'South America', 2000, 59.90, 8),
('League of Legends', 'MOBA', 2009, 'Riot Games', 'Brazil', 10, 0.00, 8),
('Counter-Strike: Global Offensive', 'Shooter', 2012, 'Valve', 'Europe West', 10, 49.90, 8),
('Apex Legends', 'Shooter', 2019, 'Respawn Entertainment', 'US West', 60, 0.00, 8),
('Overwatch', 'Shooter', 2016, 'Blizzard', 'Asia', 12, 149.90, 8),
('Call of Duty: Warzone', 'Shooter', 2020, 'Infinity Ward', 'US East', 150, 0.00, 4),
('Rocket League', 'Sports', 2015, 'Psyonix', 'South America', 8, 89.90, 3);
