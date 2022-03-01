***********************************
*  SER 322 Project Deliverable 4  *
***********************************

        _     _                                                 ___      _        _                    
 /\   /(_) __| | ___  ___   __ _  __ _ _ __ ___   ___  ___     /   \__ _| |_ __ _| |__   __ _ ___  ___ 
 \ \ / / |/ _` |/ _ \/ _ \ / _` |/ _` | '_ ` _ \ / _ \/ __|   / /\ / _` | __/ _` | '_ \ / _` / __|/ _ \
  \ V /| | (_| |  __/ (_) | (_| | (_| | | | | | |  __/\__ \  / /_// (_| | || (_| | |_) | (_| \__ \  __/
   \_/ |_|\__,_|\___|\___/ \__, |\__,_|_| |_| |_|\___||___/ /___,' \__,_|\__\__,_|_.__/ \__,_|___/\___|
                           |___/                                                                       

***************************************************************************
* Simple Videogames database application.                                 *
* Authors: Alana Moore, Christopher Alfaro, Josh McMillen and Luca Fulmor *
***************************************************************************

///////////////////////////////////////
/       Project Environment           /
///////////////////////////////////////

Application Prerequisites:
    - MySQL version version 8.0.28
    - MySQL Workbench version 8.0.28
    - Java version 11.0.13
    - MySQL Connector/J 8.0.28 (JAR IS INCLUDED IN PROJECT LIB FOLDER)
        https://dev.mysql.com/downloads/connector/j/ 

///////////////////////////////////////
/       Creating the Database         /
///////////////////////////////////////

1. Open MySQL Workbench and connect to MySQL Server local instance

2. From Schemas side-menu, right click and select 'Create Schema'

3. Enter schema name (example will be 'videogames') and select Apply

4. Under File, select 'Open SQL Script' and select the create and insert scripts provided in Project folder SQL-Scripts
    • Video-games_Team 5_create.sql
    • Video-games_Team5 _insert.sql

5. Double-click on the videogames schema from the Schemas side menu and execute the create and insert scripts (in this order)

6. Verify database is populated by running 
    SELECT * FROM videogames.GAME;

    • Note: [videogames] will be replaced with whatever name was given to the schema in step 3

///////////////////////////////////////
/   Compilation and Run Description   /
///////////////////////////////////////

------------- COMPILING IN TERMINAL -------------

1. Navigate to SER322-TEAM5-PROJECT folder

2. Run 
    javac -cp ./lib/mysql-connector-java-8.0.28.jar src/*.java -d classes/

-------- RUNNING APPLICATION IN TERMINAL --------

1. Run
    java -cp ./lib/mysql-connector-java-8.0.28.jar:classes CLIMenu

2. Answer application prompt by providing: <database-url> <username> <password> <driver>
    EXAMPLE: 
        Enter Database name, username,password and driver to connect to DB:jdbc:mysql://localhost:3306/videogames 
        root password com.mysql.cj.jdbc.Driver

-------------- OTHER INSTRUCTIONS --------------

If executing through IDE such as Eclipse or using building tools such as gradle and maven,
the mysql-connector-java-8.028.jar file should be added to the classpath/referenced library/ 
dependencies to run the application.

Main method: CLIMenu.main

///////////////////////////////////////
/           Project Video             /
///////////////////////////////////////

Link: 

///////////////////////////////////////
/     Team Member Contributions       /
///////////////////////////////////////

Alana:
    - Version control (setup github repository for project)

    - Created ReadMe.txt and filled each section (discluding team member contributions)

    - Wrote DeleteHandler class for building and executing sql deletions to the database

    - Restructured DBConnect class to have a Connection attribute to better handle seperate
      delete/insert/update queries, additionally added connection and disconnect methods.

    - Modified sql create script to add delete cascades to all child tables.

Christopher:

Josh:

Luca:


