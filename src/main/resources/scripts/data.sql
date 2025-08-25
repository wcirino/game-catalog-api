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
INSERT INTO physical_games (title, description, genre, release_year, platform, production_studio, price, media_type, condition_status, manual_language, has_box, id_console)
VALUES
('God of War II', 'Action-adventure game set in Greek mythology.', 'Action', 2007, 'PS2', 'Santa Monica Studio', 79.90, 'DVD', 'Used', 'Portuguese', TRUE, 1),
('Halo 3', 'First-person shooter in the Halo series.', 'Shooter', 2007, 'Xbox 360', 'Bungie', 99.90, 'DVD', 'New', 'English', TRUE, 5),
('The Last of Us', 'Post-apocalyptic action-adventure game.', 'Adventure', 2013, 'PS3', 'Naughty Dog', 129.90, 'Blu-ray', 'Special Edition', 'English', TRUE, 2);

-- Digital Games
INSERT INTO digital_games (title, description, genre, release_year, platform, production_studio, price, activation_key, digital_store, download_size, license_expiration, id_console)
VALUES
('Minecraft', 'Sandbox survival game with building mechanics.', 'Sandbox', 2011, 'PC', 'Mojang', 99.90, 'MINE-1234-5678-ABCD', 'Steam', 5.50, NULL, 8),
('Cyberpunk 2077', 'Futuristic RPG in Night City.', 'RPG', 2020, 'PS5', 'CD Projekt Red', 249.90, 'CYB-9876-5432-WXYZ', 'PSN', 70.00, NULL, 4);


-- Online Games
INSERT INTO online_games (title, description, genre, release_year, platform, production_studio, price, server, multiplayer, subscription_period, max_players, id_console)
VALUES
('Fortnite', 'Battle royale multiplayer game.', 'Shooter', 2017, 'PS4', 'Epic Games', 0.00, 'US East', TRUE, 'Monthly', 100, 3),
('World of Warcraft', 'Fantasy MMORPG.', 'MMORPG', 2004, 'PC', 'Blizzard', 59.90, 'South America', TRUE, 'Annual', 2000, 8);

INSERT INTO physical_games (title, description, genre, release_year, platform, production_studio, price, media_type, condition_status, manual_language, has_box, id_console)
VALUES
('God of War II', 'Action-adventure in Greek mythology.', 'Action', 2007, 'PS2', 'Santa Monica Studio', 79.90, 'DVD', 'Used', 'Portuguese', TRUE, 1),
('The Last of Us', 'Post-apocalyptic survival game.', 'Adventure', 2013, 'PS3', 'Naughty Dog', 129.90, 'Blu-ray', 'New', 'English', TRUE, 2),
('Uncharted 4: A Thief''s End', 'Treasure hunting adventure.', 'Adventure', 2016, 'PS4', 'Naughty Dog', 159.90, 'Blu-ray', 'Special Edition', 'English', TRUE, 3),
('Gran Turismo 7', 'Realistic racing simulation.', 'Racing', 2022, 'PS5', 'Polyphony Digital', 299.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 4),
('Halo 3', 'Sci-fi first-person shooter.', 'Shooter', 2007, 'Xbox 360', 'Bungie', 99.90, 'DVD', 'Used', 'English', TRUE, 5),
('Halo 5: Guardians', 'Shooter with multiplayer campaign.', 'Shooter', 2015, 'Xbox One', '343 Industries', 149.90, 'Blu-ray', 'New', 'English', TRUE, 6),
('Forza Horizon 5', 'Open world racing game in Mexico.', 'Racing', 2021, 'Xbox Series X', 'Playground Games', 299.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 7),
('Super Mario Odyssey', 'Mario exploring new worlds.', 'Platformer', 2017, 'Switch', 'Nintendo', 249.90, 'Cartridge', 'New', 'English', TRUE, 8),
('The Legend of Zelda: Ocarina of Time', 'Classic adventure with Link.', 'Adventure', 1998, 'N64', 'Nintendo', 199.90, 'Cartridge', 'Used', 'English', TRUE, 20),
('Metroid Prime', 'Sci-fi exploration shooter.', 'Action', 2002, 'GameCube', 'Retro Studios', 179.90, 'DVD', 'Used', 'English', TRUE, 10);

INSERT INTO digital_games (title, description, genre, release_year, platform, production_studio, price, activation_key, digital_store, download_size, license_expiration, id_console)
VALUES
('Minecraft', 'Sandbox building survival game.', 'Sandbox', 2011, 'PC', 'Mojang', 99.90, 'MINE-1234-5678-ABCD', 'Steam', 5.50, NULL, 8),
('Cyberpunk 2077', 'Futuristic open-world RPG.', 'RPG', 2020, 'PS5', 'CD Projekt Red', 249.90, 'CYB-9876-5432-WXYZ', 'PSN', 70.00, NULL, 4),
('The Witcher 3: Wild Hunt', 'Epic RPG adventure with Geralt.', 'RPG', 2015, 'PC', 'CD Projekt Red', 149.90, 'W3-1234-KEY-5678', 'GOG', 40.00, NULL, 8),
('Elden Ring', 'Soulslike open world RPG.', 'RPG', 2022, 'PS5', 'FromSoftware', 299.90, 'ELDR-2022-PSN', 'PSN', 45.00, NULL, 4),
('Hades', 'Roguelike dungeon crawler.', 'Action', 2020, 'Switch', 'Supergiant Games', 99.90, 'HADES-KEY-2020', 'Nintendo eShop', 6.00, NULL, 8),
('Stardew Valley', 'Farming and life simulation.', 'Simulation', 2016, 'PC', 'ConcernedApe', 39.90, 'SDV-2020-STEAM', 'Steam', 1.50, NULL, 8),
('Resident Evil Village', 'Horror survival story.', 'Horror', 2021, 'PS5', 'Capcom', 229.90, 'REVIL-2021-PSN', 'PSN', 30.00, NULL, 4),
('Assassin''s Creed Valhalla', 'Viking action adventure.', 'Action', 2020, 'Xbox Series X', 'Ubisoft', 259.90, 'ACV-UBI-2020', 'Xbox Live', 65.00, NULL, 7),
('Hollow Knight', 'Metroidvania indie hit.', 'Adventure', 2017, 'PC', 'Team Cherry', 49.90, 'HK-INDIE-KEY', 'Steam', 9.00, NULL, 8),
('Cuphead', 'Run-and-gun cartoon shooter.', 'Shooter', 2017, 'Xbox One', 'Studio MDHR', 79.90, 'CUP-2017-KEY', 'Xbox Live', 3.20, NULL, 6);

INSERT INTO online_games (title, description, genre, release_year, platform, production_studio, price, server, multiplayer, subscription_period, max_players, id_console)
VALUES
('Fortnite', 'Battle royale shooter with building.', 'Shooter', 2017, 'PS4', 'Epic Games', 0.00, 'US East', TRUE, 'Monthly', 100, 3),
('World of Warcraft', 'Fantasy MMORPG with expansions.', 'MMORPG', 2004, 'PC', 'Blizzard', 59.90, 'South America', TRUE, 'Annual', 2000, 8),
('League of Legends', 'MOBA with champions and ranked play.', 'MOBA', 2009, 'PC', 'Riot Games', 0.00, 'Brazil', TRUE, 'Monthly', 10, 8),
('Counter-Strike: Global Offensive', 'Tactical team-based shooter.', 'Shooter', 2012, 'PC', 'Valve', 49.90, 'Europe West', TRUE, 'Monthly', 10, 8),
('Apex Legends', 'Hero-based battle royale.', 'Shooter', 2019, 'PC', 'Respawn Entertainment', 0.00, 'US West', TRUE, 'Monthly', 60, 8),
('Overwatch', 'Team hero shooter.', 'Shooter', 2016, 'PC', 'Blizzard', 149.90, 'Asia', TRUE, 'Monthly', 12, 8),
('Final Fantasy XIV Online', 'MMORPG with Final Fantasy universe.', 'MMORPG', 2010, 'PC', 'Square Enix', 129.90, 'Europe', TRUE, 'Annual', 5000, 8),
('Call of Duty: Warzone', 'Battle royale shooter.', 'Shooter', 2020, 'PS5', 'Infinity Ward', 0.00, 'US East', TRUE, 'Monthly', 150, 4),
('Rocket League', 'Soccer with cars, online competition.', 'Sports', 2015, 'PS4', 'Psyonix', 89.90, 'South America', TRUE, 'Monthly', 8, 3),
('Destiny 2', 'Sci-fi online shooter with raids.', 'Shooter/MMO', 2017, 'Xbox Series X', 'Bungie', 199.90, 'US West', TRUE, 'Annual', 100, 7);

INSERT INTO physical_games (title, description, genre, release_year, platform, production_studio, price, media_type, condition_status, manual_language, has_box, id_console)
VALUES
('Shadow of the Colossus', 'Epic battles against colossi.', 'Adventure', 2005, 'PS2', 'Team Ico', 89.90, 'DVD', 'Used', 'English', TRUE, 1),
('Metal Gear Solid 3: Snake Eater', 'Stealth action set in Cold War.', 'Action', 2004, 'PS2', 'Konami', 99.90, 'DVD', 'Used', 'English', TRUE, 1),
('Resident Evil 4', 'Survival horror revolution.', 'Horror', 2005, 'PS2', 'Capcom', 79.90, 'DVD', 'Used', 'Portuguese', TRUE, 1),
('Gran Turismo 4', 'Racing simulator with hundreds of cars.', 'Racing', 2004, 'PS2', 'Polyphony Digital', 69.90, 'DVD', 'Used', 'English', TRUE, 1),
('Killzone 2', 'Sci-fi FPS exclusive for PS3.', 'Shooter', 2009, 'PS3', 'Guerrilla Games', 99.90, 'Blu-ray', 'Used', 'English', TRUE, 2),
('Heavy Rain', 'Interactive drama thriller.', 'Adventure', 2010, 'PS3', 'Quantic Dream', 89.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 2),
('God of War III', 'Mythological hack and slash.', 'Action', 2010, 'PS3', 'Santa Monica Studio', 119.90, 'Blu-ray', 'New', 'English', TRUE, 2),
('Bloodborne', 'Dark fantasy action RPG.', 'RPG', 2015, 'PS4', 'FromSoftware', 149.90, 'Blu-ray', 'New', 'English', TRUE, 3),
('Horizon Zero Dawn', 'Open-world adventure with machines.', 'Adventure', 2017, 'PS4', 'Guerrilla Games', 179.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 3),
('Marvel''s Spider-Man', 'Action adventure as Spider-Man.', 'Action', 2018, 'PS4', 'Insomniac Games', 199.90, 'Blu-ray', 'New', 'English', TRUE, 3),
('Ratchet & Clank: Rift Apart', 'Dimensional platforming adventure.', 'Platformer', 2021, 'PS5', 'Insomniac Games', 299.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 4),
('Demon''s Souls', 'Remake of the cult classic.', 'RPG', 2020, 'PS5', 'FromSoftware', 299.90, 'Blu-ray', 'New', 'English', TRUE, 4),
('Gears of War 2', 'Sci-fi third-person shooter.', 'Shooter', 2008, 'Xbox 360', 'Epic Games', 89.90, 'DVD', 'Used', 'English', TRUE, 5),
('Red Dead Redemption', 'Wild West open-world adventure.', 'Adventure', 2010, 'Xbox 360', 'Rockstar Games', 109.90, 'DVD', 'Used', 'English', TRUE, 5),
('Halo Reach', 'Prequel to the Halo trilogy.', 'Shooter', 2010, 'Xbox 360', 'Bungie', 119.90, 'DVD', 'Used', 'English', TRUE, 5),
('Forza Motorsport 7', 'Simulation racing.', 'Racing', 2017, 'Xbox One', 'Turn 10 Studios', 199.90, 'Blu-ray', 'New', 'English', TRUE, 6),
('Quantum Break', 'Shooter with time manipulation.', 'Shooter', 2016, 'Xbox One', 'Remedy Entertainment', 169.90, 'Blu-ray', 'New', 'English', TRUE, 6),
('Sea of Thieves', 'Pirate online adventure.', 'Adventure', 2018, 'Xbox One', 'Rare', 159.90, 'Blu-ray', 'New', 'English', TRUE, 6),
('Pokemon Sword', 'Monster catching RPG.', 'RPG', 2019, 'Switch', 'Game Freak', 249.90, 'Cartridge', 'New', 'Portuguese', TRUE, 8),
('Super Smash Bros. Ultimate', 'Crossover fighting game.', 'Fighting', 2018, 'Switch', 'Nintendo', 279.90, 'Cartridge', 'New', 'English', TRUE, 8);

INSERT INTO digital_games (title, description, genre, release_year, platform, production_studio, price, activation_key, digital_store, download_size, license_expiration, id_console)
VALUES
('Diablo III', 'Action RPG hack and slash.', 'RPG', 2012, 'PC', 'Blizzard', 149.90, 'D3-BLIZZ-2012', 'Battle.net', 20.00, NULL, 8),
('Diablo IV', 'Dark action RPG.', 'RPG', 2023, 'PC', 'Blizzard', 349.90, 'D4-BLIZZ-2023', 'Battle.net', 90.00, NULL, 8),
('StarCraft II', 'Real-time strategy.', 'Strategy', 2010, 'PC', 'Blizzard', 99.90, 'SC2-BLIZZ-2010', 'Battle.net', 15.00, NULL, 8),
('Valorant', 'Hero tactical shooter.', 'Shooter', 2020, 'PC', 'Riot Games', 0.00, 'VAL-2020-RIOT', 'Riot Launcher', 25.00, NULL, 8),
('Among Us', 'Multiplayer social deduction.', 'Party', 2018, 'PC', 'Innersloth', 15.90, 'AMONG-US-2018', 'Steam', 0.50, NULL, 8),
('Fall Guys', 'Battle royale party game.', 'Party', 2020, 'PC', 'Mediatonic', 59.90, 'FALL-2020-KEY', 'Epic Store', 2.00, NULL, 8),
('Celeste', 'Indie platformer with story.', 'Platformer', 2018, 'PC', 'Maddy Makes Games', 39.90, 'CEL-INDIE-2018', 'Steam', 1.50, NULL, 8),
('Terraria', '2D sandbox adventure.', 'Sandbox', 2011, 'PC', 'Re-Logic', 39.90, 'TERRARIA-2011', 'Steam', 2.00, NULL, 8),
('Dota 2', 'MOBA strategy online.', 'MOBA', 2013, 'PC', 'Valve', 0.00, 'DOTA-2-STEAM', 'Steam', 15.00, NULL, 8),
('Half-Life 2', 'Legendary FPS from Valve.', 'Shooter', 2004, 'PC', 'Valve', 79.90, 'HL2-2004-STEAM', 'Steam', 5.00, NULL, 8),
('Alan Wake', 'Psychological thriller.', 'Adventure', 2010, 'PC', 'Remedy Entertainment', 59.90, 'ALAN-2010-KEY', 'Epic Store', 8.00, NULL, 8),
('Alan Wake II', 'Survival horror thriller.', 'Horror', 2023, 'PC', 'Remedy Entertainment', 349.90, 'AW2-2023-KEY', 'Epic Store', 80.00, NULL, 8),
('Baldur''s Gate 3', 'Dungeons & Dragons RPG.', 'RPG', 2023, 'PC', 'Larian Studios', 349.90, 'BG3-2023-KEY', 'Steam', 120.00, NULL, 8),
('Star Wars Jedi: Survivor', 'Jedi action-adventure.', 'Action', 2023, 'PC', 'Respawn Entertainment', 299.90, 'SWJS-2023-KEY', 'Steam', 130.00, NULL, 8),
('Returnal', 'Sci-fi roguelike shooter.', 'Shooter', 2021, 'PS5', 'Housemarque', 299.90, 'RET-2021-PSN', 'PSN', 56.00, NULL, 4),
('Mortal Kombat 11', 'Fighting franchise classic.', 'Fighting', 2019, 'PC', 'NetherRealm Studios', 199.90, 'MK11-2019-KEY', 'Steam', 45.00, NULL, 8),
('Street Fighter V', 'Iconic fighting game.', 'Fighting', 2016, 'PC', 'Capcom', 149.90, 'SFV-2016-KEY', 'Steam', 35.00, NULL, 8),
('Tekken 7', 'King of Iron Fist tournament.', 'Fighting', 2017, 'PC', 'Bandai Namco', 199.90, 'TK7-2017-KEY', 'Steam', 55.00, NULL, 8),
('GTA V', 'Open world crime epic.', 'Action', 2013, 'PC', 'Rockstar', 149.90, 'GTAV-2013-KEY', 'Rockstar Launcher', 90.00, NULL, 8),
('GTA Online', 'Online expansion of GTA V.', 'Action Online', 2015, 'PC', 'Rockstar', 0.00, 'GTAO-2015-KEY', 'Rockstar Launcher', 100.00, NULL, 8);

INSERT INTO online_games (title, description, genre, release_year, platform, production_studio, price, server, multiplayer, subscription_period, max_players, id_console)
VALUES
('PUBG: Battlegrounds', 'Battle royale with realism.', 'Shooter', 2017, 'PC', 'PUBG Studios', 59.90, 'Asia', TRUE, 'Monthly', 100, 8),
('Dota Underlords', 'Auto chess strategy.', 'Strategy', 2020, 'PC', 'Valve', 0.00, 'Europe', TRUE, 'Monthly', 8, 8),
('Lost Ark', 'MMO action RPG.', 'MMORPG', 2022, 'PC', 'Smilegate RPG', 0.00, 'South America', TRUE, 'Monthly', 5000, 8),
('Black Desert Online', 'Fantasy MMORPG with graphics.', 'MMORPG', 2015, 'PC', 'Pearl Abyss', 49.90, 'Asia', TRUE, 'Annual', 3000, 8),
('The Division 2', 'Tactical shooter online.', 'Shooter', 2019, 'PC', 'Ubisoft', 149.90, 'US East', TRUE, 'Monthly', 12, 8),
('Rainbow Six Siege', 'Tactical FPS with operators.', 'Shooter', 2015, 'PC', 'Ubisoft', 129.90, 'Europe', TRUE, 'Monthly', 10, 8),
('Warframe', 'Sci-fi cooperative online.', 'Action', 2013, 'PC', 'Digital Extremes', 0.00, 'US West', TRUE, 'Monthly', 4, 8),
('Guild Wars 2', 'Fantasy MMORPG.', 'MMORPG', 2012, 'PC', 'ArenaNet', 79.90, 'Europe', TRUE, 'Annual', 2000, 8),
('Runescape', 'Classic fantasy MMORPG.', 'MMORPG', 2001, 'PC', 'Jagex', 39.90, 'Europe', TRUE, 'Monthly', 1000, 8),
('MapleStory', 'Anime-style MMORPG.', 'MMORPG', 2003, 'PC', 'Nexon', 29.90, 'Asia', TRUE, 'Monthly', 2000, 8),
('Smite', 'Third-person MOBA with gods.', 'MOBA', 2014, 'PC', 'Hi-Rez Studios', 0.00, 'US East', TRUE, 'Monthly', 10, 8),
('Paladins', 'Hero shooter online.', 'Shooter', 2016, 'PC', 'Hi-Rez Studios', 0.00, 'South America', TRUE, 'Monthly', 12, 8),
('Star Wars: The Old Republic', 'Star Wars MMORPG.', 'MMORPG', 2011, 'PC', 'BioWare', 59.90, 'US West', TRUE, 'Annual', 4000, 8),
('EVE Online', 'Space MMO with economy.', 'Simulation', 2003, 'PC', 'CCP Games', 49.90, 'Europe', TRUE, 'Monthly', 10000, 8),
('CrossFire', 'Free-to-play FPS.', 'Shooter', 2007, 'PC', 'Smilegate', 0.00, 'Asia', TRUE, 'Monthly', 16, 8),
('Second Life', 'Virtual world online.', 'Simulation', 2003, 'PC', 'Linden Lab', 29.90, 'US East', TRUE, 'Annual', 5000, 8),
('Phantasy Star Online 2', 'Sci-fi MMORPG.', 'MMORPG', 2012, 'PC', 'Sega', 0.00, 'Asia', TRUE, 'Monthly', 3000, 8),
('Monster Hunter: World', 'Online hunting with friends.', 'Action RPG', 2018, 'PC', 'Capcom', 199.90, 'South America', TRUE, 'Monthly', 4, 8),
('Genshin Impact', 'Anime-style open world MMO-lite.', 'Adventure', 2020, 'PC', 'miHoYo', 0.00, 'Asia', TRUE, 'Monthly', 4, 8),
('FIFA Online 4', 'Soccer free-to-play online.', 'Sports', 2018, 'PC', 'EA Sports', 0.00, 'Asia', TRUE, 'Monthly', 22, 8);


INSERT INTO physical_games (title, description, genre, release_year, platform, production_studio, price, media_type, condition_status, manual_language, has_box, id_console)
VALUES
('Resident Evil 2 Remake', 'Survival horror classic reimagined.', 'Horror', 2019, 'PS4', 'Capcom', 179.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 3),
('Resident Evil 3 Remake', 'Nemesis returns in Raccoon City.', 'Horror', 2020, 'PS4', 'Capcom', 179.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 3),
('Resident Evil 5', 'Co-op action horror.', 'Horror', 2009, 'Xbox 360', 'Capcom', 109.90, 'DVD', 'Used', 'English', TRUE, 5),
('Resident Evil 6', 'Global horror action story.', 'Horror', 2012, 'Xbox 360', 'Capcom', 129.90, 'DVD', 'Used', 'English', TRUE, 5),
('Resident Evil 7: Biohazard', 'First-person horror revival.', 'Horror', 2017, 'PS4', 'Capcom', 159.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 3),
('Resident Evil Village', 'Survival horror in a creepy village.', 'Horror', 2021, 'PS5', 'Capcom', 249.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 4),
('Final Fantasy VII Remake', 'Reimagined RPG classic.', 'RPG', 2020, 'PS4', 'Square Enix', 229.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 3),
('Final Fantasy XVI', 'New fantasy epic.', 'RPG', 2023, 'PS5', 'Square Enix', 349.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 4),
('Dragon Quest XI', 'JRPG classic revived.', 'RPG', 2017, 'PS4', 'Square Enix', 199.90, 'Blu-ray', 'New', 'English', TRUE, 3),
('Persona 5 Royal', 'Stylish JRPG with social sim.', 'RPG', 2019, 'PS4', 'Atlus', 229.90, 'Blu-ray', 'New', 'Portuguese', TRUE, 3),
('Persona 4 Golden', 'Classic JRPG story.', 'RPG', 2012, 'PS Vita', 'Atlus', 99.90, 'Cartridge', 'Used', 'English', TRUE, 17),
('Persona 3 Portable', 'Persona adventure on PSP.', 'RPG', 2009, 'PSP', 'Atlus', 79.90, 'UMD', 'Used', 'English', TRUE, 16),
('Pokemon Brilliant Diamond', 'Remake of Sinnoh region RPG.', 'RPG', 2021, 'Switch', 'Game Freak', 249.90, 'Cartridge', 'New', 'Portuguese', TRUE, 8),
('Pokemon Legends Arceus', 'Semi-open world Pokemon.', 'RPG', 2022, 'Switch', 'Game Freak', 299.90, 'Cartridge', 'New', 'Portuguese', TRUE, 8),
('Metroid Dread', 'Sci-fi platforming action.', 'Action', 2021, 'Switch', 'Nintendo', 279.90, 'Cartridge', 'New', 'Portuguese', TRUE, 8),
('Bayonetta 2', 'Stylish action combat.', 'Action', 2014, 'Wii U', 'PlatinumGames', 149.90, 'Blu-ray', 'New', 'English', TRUE, 12),
('Bayonetta 3', 'Witch returns with more action.', 'Action', 2022, 'Switch', 'PlatinumGames', 299.90, 'Cartridge', 'New', 'Portuguese', TRUE, 8),
('Mario Kart 8 Deluxe', 'Arcade racing fun.', 'Racing', 2017, 'Switch', 'Nintendo', 249.90, 'Cartridge', 'New', 'Portuguese', TRUE, 8),
('Donkey Kong Country: Tropical Freeze', 'Classic platformer returns.', 'Platformer', 2014, 'Wii U', 'Nintendo', 149.90, 'Blu-ray', 'New', 'English', TRUE, 12),
('Luigi''s Mansion 3', 'Ghost-hunting adventure.', 'Adventure', 2019, 'Switch', 'Nintendo', 249.90, 'Cartridge', 'New', 'Portuguese', TRUE, 8);

INSERT INTO digital_games (title, description, genre, release_year, platform, production_studio, price, activation_key, digital_store, download_size, license_expiration, id_console)
VALUES
('The Sims 4', 'Life simulation game.', 'Simulation', 2014, 'PC', 'EA', 159.90, 'SIMS4-2014-KEY', 'Origin', 20.00, NULL, 8),
('The Sims 3', 'Predecessor with expansions.', 'Simulation', 2009, 'PC', 'EA', 129.90, 'SIMS3-2009-KEY', 'Origin', 12.00, NULL, 8),
('No Man''s Sky', 'Space exploration game.', 'Adventure', 2016, 'PC', 'Hello Games', 199.90, 'NMS-2016-KEY', 'Steam', 20.00, NULL, 8),
('Subnautica', 'Underwater survival adventure.', 'Adventure', 2018, 'PC', 'Unknown Worlds', 99.90, 'SUB-2018-KEY', 'Steam', 15.00, NULL, 8),
('Subnautica: Below Zero', 'Frozen ocean survival.', 'Adventure', 2021, 'PC', 'Unknown Worlds', 129.90, 'SUB-BZ-2021-KEY', 'Steam', 20.00, NULL, 8),
('Hellblade: Senua''s Sacrifice', 'Dark adventure with Norse myths.', 'Adventure', 2017, 'PC', 'Ninja Theory', 119.90, 'HS-2017-KEY', 'Steam', 25.00, NULL, 8),
('Hellblade II: Senua''s Saga', 'Sequel to Senua''s story.', 'Adventure', 2024, 'PC', 'Ninja Theory', 349.90, 'HS2-2024-KEY', 'Steam', 90.00, NULL, 8),
('Ori and the Blind Forest', 'Emotional platformer.', 'Platformer', 2015, 'PC', 'Moon Studios', 89.90, 'ORI-2015-KEY', 'Steam', 8.00, NULL, 8),
('Ori and the Will of the Wisps', 'Sequel to Ori adventure.', 'Platformer', 2020, 'PC', 'Moon Studios', 129.90, 'ORI2-2020-KEY', 'Steam', 12.00, NULL, 8),
('Inside', 'Dark puzzle-platformer.', 'Puzzle', 2016, 'PC', 'Playdead', 59.90, 'INSIDE-2016-KEY', 'Steam', 4.00, NULL, 8),
('Limbo', 'Black and white puzzle adventure.', 'Puzzle', 2010, 'PC', 'Playdead', 39.90, 'LIMBO-2010-KEY', 'Steam', 3.00, NULL, 8),
('Dead Cells', 'Roguelike Metroidvania.', 'Roguelike', 2018, 'PC', 'Motion Twin', 89.90, 'DC-2018-KEY', 'Steam', 8.00, NULL, 8),
('Horizon Forbidden West', 'Sequel to Horizon Zero Dawn.', 'Adventure', 2022, 'PS5', 'Guerrilla Games', 349.90, 'HFW-2022-KEY', 'PSN', 90.00, NULL, 4),
('Death Stranding', 'Strand game by Kojima.', 'Adventure', 2019, 'PC', 'Kojima Productions', 229.90, 'DS-2019-KEY', 'Steam', 60.00, NULL, 8),
('Death Stranding: Director''s Cut', 'Expanded version.', 'Adventure', 2021, 'PS5', 'Kojima Productions', 299.90, 'DSDC-2021-KEY', 'PSN', 70.00, NULL, 4),
('Sekiro: Shadows Die Twice', 'Samurai soulslike.', 'Action', 2019, 'PC', 'FromSoftware', 229.90, 'SEKIRO-2019-KEY', 'Steam', 25.00, NULL, 8),
('Dark Souls III', 'Hardcore action RPG.', 'RPG', 2016, 'PC', 'FromSoftware', 179.90, 'DS3-2016-KEY', 'Steam', 30.00, NULL, 8),
('Dark Souls II', 'Challenging RPG sequel.', 'RPG', 2014, 'PC', 'FromSoftware', 149.90, 'DS2-2014-KEY', 'Steam', 20.00, NULL, 8),
('Dark Souls Remastered', 'HD version of classic.', 'RPG', 2018, 'PC', 'FromSoftware', 199.90, 'DS-REM-2018', 'Steam', 15.00, NULL, 8),
('Bloodstained: Ritual of the Night', 'Spiritual Castlevania successor.', 'Adventure', 2019, 'PC', 'ArtPlay', 149.90, 'BS-2019-KEY', 'Steam', 12.00, NULL, 8);

INSERT INTO online_games (title, description, genre, release_year, platform, production_studio, price, server, multiplayer, subscription_period, max_players, id_console)
VALUES
('Overwatch 2', 'Hero shooter sequel.', 'Shooter', 2022, 'PC', 'Blizzard', 0.00, 'US East', TRUE, 'Monthly', 12, 8),
('Heroes of the Storm', 'Blizzard MOBA.', 'MOBA', 2015, 'PC', 'Blizzard', 0.00, 'Europe', TRUE, 'Monthly', 10, 8),
('Path of Exile', 'Dark ARPG online.', 'RPG', 2013, 'PC', 'Grinding Gear Games', 0.00, 'US West', TRUE, 'Monthly', 6, 8),
('Torchlight Infinite', 'ARPG successor.', 'RPG', 2022, 'PC', 'XD Inc.', 0.00, 'Asia', TRUE, 'Monthly', 6, 8),
('Dauntless', 'Monster hunting online.', 'Action', 2019, 'PC', 'Phoenix Labs', 0.00, 'US East', TRUE, 'Monthly', 4, 8),
('Fallout 76', 'Post-apocalyptic MMO-lite.', 'RPG', 2018, 'PC', 'Bethesda', 179.90, 'US East', TRUE, 'Monthly', 24, 8),
('Elder Scrolls Online', 'Fantasy MMORPG.', 'MMORPG', 2014, 'PC', 'Bethesda', 149.90, 'Europe', TRUE, 'Annual', 5000, 8),
('Mortal Online 2', 'Hardcore sandbox MMO.', 'MMORPG', 2022, 'PC', 'Star Vault', 199.90, 'Europe', TRUE, 'Monthly', 5000, 8),
('Conan Exiles', 'Survival MMO.', 'Survival', 2018, 'PC', 'Funcom', 129.90, 'US West', TRUE, 'Monthly', 40, 8),
('Rust', 'Survival online sandbox.', 'Survival', 2013, 'PC', 'Facepunch Studios', 99.90, 'US East', TRUE, 'Monthly', 200, 8),
('ARK: Survival Evolved', 'Survival with dinosaurs.', 'Survival', 2017, 'PC', 'Studio Wildcard', 149.90, 'US East', TRUE, 'Monthly', 100, 8),
('ARK: Survival Ascended', 'Next-gen remake of ARK.', 'Survival', 2023, 'PC', 'Studio Wildcard', 249.90, 'US West', TRUE, 'Monthly', 100, 8),
('DayZ', 'Zombie survival online.', 'Survival', 2018, 'PC', 'Bohemia Interactive', 129.90, 'Europe', TRUE, 'Monthly', 60, 8),
('H1Z1', 'Zombie battle royale.', 'Shooter', 2015, 'PC', 'Daybreak', 49.90, 'US West', TRUE, 'Monthly', 100, 8),
('War Thunder', 'Military vehicle MMO.', 'Simulation', 2013, 'PC', 'Gaijin Entertainment', 0.00, 'Europe', TRUE, 'Monthly', 64, 8),
('World of Tanks', 'Tank warfare MMO.', 'Simulation', 2010, 'PC', 'Wargaming', 0.00, 'Europe', TRUE, 'Monthly', 30, 8),
('World of Warships', 'Naval combat MMO.', 'Simulation', 2015, 'PC', 'Wargaming', 0.00, 'Asia', TRUE, 'Monthly', 30, 8),
('Star Trek Online', 'Sci-fi MMORPG.', 'MMORPG', 2010, 'PC', 'Cryptic Studios', 59.90, 'US West', TRUE, 'Annual', 4000, 8),
('DC Universe Online', 'Superhero MMORPG.', 'MMORPG', 2011, 'PC', 'Daybreak', 39.90, 'US East', TRUE, 'Monthly', 2000, 8),
('Lost Planet 2 Online', 'Co-op shooter online.', 'Shooter', 2010, 'Xbox 360', 'Capcom', 59.90, 'Asia', TRUE, 'Monthly', 4, 5);