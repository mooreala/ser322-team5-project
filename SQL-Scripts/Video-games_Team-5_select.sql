/* 
TEAM: GROUP 5
FILE: Video-games_Team-5_select
DESC: This script will make the following selections from the Video Games database...
	1. List all the game titles and id's that are published by Square Enix.
    2. List all the games and their publisher that have the character Ratchet in them.
    3. List all games and number of copies sold that are published by Sony and that have sold more than 30,000 copies in a year.
    4. List all the publishers in the database.
    5. List the title, genre, and description of all games that are RPG's.
    6. List the names and birth-dates of all developers born before 1980
    7. List all the PS5 games available for purchase from Amazon.
    8. List all the genre's of games in the database.
    9. List all the title, game ID and amount of copies sold of games that have music composed by John Paesano.
@author Alana Moore
@date 2.19.2022
@version 1.0
*/

/* QUERY 1: List all the game titles and id's that are published by Square Enix. */
SELECT TITLE, GAME.GAME_ID 
FROM GAME, PUBLISHER
WHERE GAME.GAME_ID=PUBLISHER.GAME_ID AND PUBLISHER.PUBLISHING_COMPANY_NAME='Square Enix';

/* QUERY 2: List all the games and their publisher that have the character Ratchet in them. */
SELECT TITLE, PUBLISHING_COMPANY_NAME
FROM GAME 
INNER JOIN PUBLISHER ON GAME.GAME_ID=PUBLISHER.GAME_ID, CHARACTER_IN_GAME
WHERE GAME.GAME_ID=CHARACTER_IN_GAME.GAME_ID AND CHARACTER_IN_GAME.C_NAME='Ratchet';

/* QUERY 3: List all games, number of copies sold, and relevant month and year that are published by Sony and that have sold more than 80,000 copies in a month */
SELECT TITLE, M_MONTH, Y_YEAR, AMOUNT
FROM GAME
INNER JOIN PUBLISHER ON GAME.GAME_ID=PUBLISHER.GAME_ID, GAME_SALES
WHERE PUBLISHING_COMPANY_NAME='Sony Interactive Entertainment' AND AMOUNT>80000;

/* QUERY 4: List all the publishers in the database. */
SELECT DISTINCT PUBLISHING_COMPANY_NAME
FROM PUBLISHER;

/* QUERY 5: List the title, genre, and description of all games that are RPG's. */
SELECT TITLE, GENRE, PLOT
FROM GAME
WHERE GAME.GENRE='RPG';

/* QUERY 6: List the names and birth-dates of all developers born before 1980 */
SELECT FULL_NAME, DOB
FROM PERSON AS p
JOIN DEVELOPER AS d
WHERE p.SSN=d.SSN AND p.DOB<'1980-01-01';

/* QUERY 7: List all the PS5 games available for purchase from Amazon. */
SELECT TITLE
FROM GAME AS g
WHERE g.RETAILERS='Amazon' AND g.PLATFORM='PS5';

/* QUERY 8: List all the genre's of games in the database. */
SELECT DISTINCT GENRE
FROM GAME;

/* QUERY 9: List all the title, game ID and amount of copies sold of games that have music composed by John Paesano. */
SELECT GAME.TITLE, GAME.GAME_ID, SUM(GAME_SALES.AMOUNT) AS AMOUNT
FROM GAME 
INNER JOIN GAME_SALES ON GAME.GAME_ID=GAME_SALES.GAME_ID
INNER JOIN COMPOSER ON GAME.GAME_ID=COMPOSER.GAME_ID
INNER JOIN PERSON ON COMPOSER.SSN=PERSON.SSN
WHERE PERSON.FULL_NAME='John Paesano'
GROUP BY GAME.TITLE, GAME.GAME_ID;
