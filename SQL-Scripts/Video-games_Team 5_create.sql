/* 
GROUP 5
THIS SCRIPT WILL LOAD THE SPECIFIED TABLES INTO THE SELECTED SCHEMA

IMPORT DATA INTO SCHEMA
RUN QUERY BELOW TO ADD TUPLES
-----------------------------------------------------------------------------------------------------
INSERT INTO GAME VALUES(12345,0,TRUE,'GENRE',100,'PLOT','RETAILER','PS5','CHARCTER','MATURE','TITLE');
INSERT INTO PERSON (SSN, FIRST_NAME, LAST_NAME, DOB) VALUES (163746523,'CHRIS','ALFARO','1989-09-23');
INSERT INTO COMPOSER VALUES (163746523,12345);
INSERT INTO PUBLISHER VALUES (163746523,12345,'ACTIVISION');
------------------------------------------------------------------------------------------------------
*/

CREATE TABLE GAME (
GAME_ID                                 INTEGER NOT NULL
                                            CONSTRAINT CHK_GAME_ID_LENGTH 
                                            CHECK (GAME_ID >= 0 AND GAME_ID <= 99999),
PAGE_VIEWS                              INTEGER NOT NULL,
APPROVED_FLAG                           BOOLEAN,
GENRE                                   VARCHAR(15),
SCORE                                   INTEGER NOT NULL
                                            CONSTRAINT CHK_SCORE_ID_LENGTH 
                                            CHECK (SCORE >= 0 AND SCORE <= 100),
PLOT                                    VARCHAR(1000),
RETAILERS                               VARCHAR(50),
PLATFORM                                VARCHAR(15)
                                            CONSTRAINT CHK_PLATFORM_VALUE
                                            CHECK(PLATFORM IN ('PC','PS4','PS5','XBOX360','XBOX ONE','NINTENDO DS')),
RATING                                  VARCHAR(15)
                                            CONSTRAINT CHK_RATING_VALUE
                                            CHECK(RATING IN ('MATURE','TEEN','EVERYONE','RATING PENDING','ADULT ONLY')),
TITLE                                   VARCHAR(100),
PRIMARY KEY (GAME_ID));

CREATE TABLE CHARACTER_IN_GAME (
C_NAME                                  VARCHAR(50),
GAME_ID                                 INTEGER NOT NULL,
FOREIGN KEY (GAME_ID) REFERENCES GAME (GAME_ID) ON DELETE CASCADE,
PRIMARY KEY (C_NAME));

CREATE TABLE GAME_SALES(
GAME_ID                                 INTEGER NOT NULL,
M_MONTH                                 INTEGER NOT NULL
											CONSTRAINT CHK_MONTH 
											CHECK (M_MONTH   >= 1 AND M_MONTH   <= 12),
Y_YEAR                                  INTEGER NOT NULL
											CONSTRAINT CHK_YEAR 
											CHECK (Y_YEAR   >= 1 AND Y_YEAR   <= 9999),
AMOUNT                                  INTEGER NOT NULL,    
FOREIGN KEY (GAME_ID) REFERENCES GAME (GAME_ID) ON DELETE CASCADE,
PRIMARY KEY (GAME_ID,M_MONTH,Y_YEAR));

/*SUPER CLASS*/
CREATE TABLE PERSON (
SSN                                     INTEGER NOT NULL
                                            CONSTRAINT CHK_SSN_ID_LENGTH 
                                            CHECK (SSN  >= 0 AND SSN  <= 999999999),
FIRST_NAME                              VARCHAR(15),
LAST_NAME                               VARCHAR(15),
DOB                                     DATE,
FULL_NAME                               VARCHAR(31) GENERATED ALWAYS AS (CONCAT(FIRST_NAME, ' ', LAST_NAME)), 
PRIMARY KEY (SSN));
/*END SUPER CLASS*/

/*SUB CLASSES*/
CREATE TABLE END_USER (
END_USER_NAME                           VARCHAR(15),
ADMIN_FLAG                              BOOLEAN,
SSN                                     INTEGER NOT NULL,
FOREIGN KEY (SSN) REFERENCES PERSON (SSN) ON DELETE CASCADE,
PRIMARY KEY (END_USER_NAME));

CREATE TABLE COMPOSER (
SSN                                     INTEGER NOT NULL,
GAME_ID                                 INTEGER NOT NULL,
FOREIGN KEY (SSN) REFERENCES PERSON (SSN) ON DELETE CASCADE,
FOREIGN KEY (GAME_ID) REFERENCES GAME (GAME_ID) ON DELETE CASCADE,
PRIMARY KEY (SSN));

CREATE TABLE PUBLISHER (
PUBLISHING_COMPANY_NAME                 VARCHAR(30),
GAME_ID                                 INTEGER NOT NULL,
FOREIGN KEY (GAME_ID) REFERENCES GAME (GAME_ID) ON DELETE CASCADE,
PRIMARY KEY (GAME_ID));

CREATE TABLE DEVELOPER (
SSN                                     INTEGER NOT NULL,
GAME_ID                                 INTEGER NOT NULL,
FOREIGN KEY (SSN) REFERENCES PERSON (SSN) ON DELETE CASCADE,
FOREIGN KEY (GAME_ID) REFERENCES GAME (GAME_ID) ON DELETE CASCADE,
PRIMARY KEY (SSN));
/*END SUB CLASSES*/