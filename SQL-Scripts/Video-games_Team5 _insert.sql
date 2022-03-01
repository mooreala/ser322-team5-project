/* 
GROUP 5
THIS SCRIPT WILL LOAD THE SPECIFIED TABLES INTO THE SELECTED SCHEMA
*/

INSERT INTO GAME VALUES 
(1,4423,TRUE,'Adventure',95,
'The intergalactic adventurers are back with a bang. Help them stop a robotic emperor intent on conquering cross-dimensional worlds, with their own universe next in the firing line.'
,'BestBuy','PS5','EVERYONE','Ratchet & Clank: Rift Apart'),
(2,2862,TRUE,'Dungeon Crawl',92,
'Discover where the journey began - Experience the original brutal challenge completely remade from the ground up. All presented in amazing visual quality with enhanced performance, this is the world of Boletaria as you have never seen it before.'
,'Amazon','PS5','MATURE','Demons Souls'),
(3,12128,TRUE,'RPG',75,
'The rise of Miles Morales - Miles Morales discovers explosive powers that set him apart from his mentor, Peter Parker. Master his unique, bioelectric venom blast attacks and covert camouflage power alongside spectacular web-slinging acrobatics, gadgets, and skills.'
,'BestBuy','PS5','TEEN','Marvels Spider-Man: Miles Morales'),
(4,44969,TRUE,'Roguelike',82,
'Through relentless roguelike gameplay, you’ll discover that just as the planet changes with every cycle, so do the items at your disposal. Every loop offers new combinations, forcing you to push your boundaries and approach combat with a different strategy each time.'
,'Amazon','PS5','TEEN','Returnal'),
(5,92420,TRUE,'RPG',97,
'Immerse yourself in the city of Midgar like never before, with improved textures, lighting, and background environments. Play the brand-new episode featuring Yuffie and experience new combat and gameplay additions.'
,'Amazon','PS5','TEEN','Final Fantasy VII REMAKE Intergrade');


INSERT INTO CHARACTER_IN_GAME VALUES
("Ratchet", 1),
("Clank", 1),
("Slayer of Demons", 2),
("Spiderman", 3),
("Selene", 4),
("Yuffie", 5),
("Wutai", 5);

INSERT INTO GAME_SALES VALUES
(1, 1, 2022, 48426),
(1, 12, 2021, 71087),
(1, 11, 2021, 33903),
(1, 10, 2021, 55311),
(1, 9, 2021, 3023),
(1, 8, 2021, 97233),
(1, 7, 2021, 94085),
(1, 6, 2021, 38285),
(1, 5, 2021, 30479),
(1, 4, 2021, 36409),
(1, 3, 2021, 29205),
(1, 2, 2021, 90847),
(1, 1, 2021, 27186),
(2, 1, 2022, 8079),
(2, 12, 2021, 8533),
(2, 11, 2021, 18506),
(2, 10, 2021, 30233),
(2, 9, 2021, 18614),
(2, 8, 2021, 4193),
(2, 7, 2021, 1386),
(2, 6, 2021, 40886),
(2, 5, 2021, 79881),
(2, 4, 2021, 25678),
(2, 3, 2021, 77191),
(2, 2, 2021, 64564),
(2, 1, 2021, 43501),
(3, 1, 2022, 15916),
(3, 12, 2021, 88865),
(3, 11, 2021, 68598),
(3, 10, 2021, 38633),
(3, 9, 2021, 26898),
(3, 8, 2021, 79392),
(3, 7, 2021, 13065),
(3, 6, 2021, 66507),
(3, 5, 2021, 44657),
(3, 4, 2021, 73751),
(3, 3, 2021, 30660),
(3, 2, 2021, 75479),
(3, 1, 2021, 96795),
(4, 1, 2022, 9558),
(4, 12, 2021, 94618),
(4, 11, 2021, 68192),
(4, 10, 2021, 63166),
(4, 9, 2021, 75717),
(4, 8, 2021, 45661),
(4, 7, 2021, 24534),
(4, 6, 2021, 75613),
(4, 5, 2021, 3349),
(4, 4, 2021, 35140),
(4, 3, 2021, 94528),
(4, 2, 2021, 83642),
(4, 1, 2021, 89650),
(5, 1, 2022, 26707),
(5, 12, 2021, 8715),
(5, 11, 2021, 49393),
(5, 10, 2021, 14755),
(5, 9, 2021, 46076),
(5, 8, 2021, 74037),
(5, 7, 2021, 92101),
(5, 6, 2021, 85377),
(5, 5, 2021, 7841),
(5, 4, 2021, 64850),
(5, 3, 2021, 73529),
(5, 2, 2021, 98597),
(5, 1, 2021, 46377);

INSERT INTO PERSON (SSN, FIRST_NAME, LAST_NAME, DOB) VALUES 
(163746523,'Hidetaka','Miyazaki','1974-01-01'),
(406753968,'Cameron','Christian','1972-10-01'),
(301967619,'John','Paesano','1963-09-01'),
(995878944,'Marcus','Smith','1975-05-01'),
(469848995,'Mike','Daly','1981-04-01'),
(182912032,'Shunsuke','Kida','1968-03-01'),
(659501351,'Henri','Mustonen','1965-11-01'),
(284195260,'Ville','Kinnunen','1986-09-01'),
(618527439,'Naoki','Hamaguchi','1977-02-01'),
(229458328,'Nobuo','Uematsu','1959-03-21'),
(432169470,'CHRIS','ALFARO','1989-09-23'),
(927564451,'Josh','McMillen','1987-01-01'),
(442985386,'Luca','Fulmor','1990-08-01'),
(925831695,'Alana','Moore','1991-07-01');

INSERT INTO END_USER VALUES 
("calfaro7", TRUE, 432169470),
("jamcmil1", TRUE, 927564451),
("gfulmor", TRUE, 442985386),
("amoore66", TRUE, 925831695);

INSERT INTO COMPOSER VALUES
(301967619,3),
(469848995,1),
(182912032,2),
(284195260,4),
(229458328,5);

INSERT INTO PUBLISHER VALUES
('PlayStation Studios', 1),
('Sony Interactive Entertainment', 2),
('Sony Interactive Entertainment', 3),
('PlayStation Studios', 4),
('Square Enix', 5);

INSERT INTO DEVELOPER VALUES
(163746523,2),
(406753968,3),
(995878944,1),
(659501351,4),
(618527439,5);

