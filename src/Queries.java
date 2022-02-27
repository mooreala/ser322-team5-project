import java.sql.*;
import java.text.DecimalFormat;

public class Queries {
    public static void main(String[] args){
        System.out.println("Beginning Program");

        if(args[4].equals("query1")) {
            queryListAllGames(args[0], args[1], args[2]);
        }
        else if (args[4].equals("query2")) {
            queryListSpecificGameInfo(args[0], args[1], args[2], args[5]);
        }
        else if (args[4].equals("query3")) {
            queryListSpecificGameDataWithAdditionalInfo(args[0], args[1], args[2], args[5]);
        }
        else if (args[4].equals("query4")) {
            queryGamesForSpecificCharacter(args[0], args[1], args[2], args[5]);
        }
        else if (args[4].equals("query5")) {
            queryCharactersInGame(args[0], args[1], args[2], args[5]);
        }
        else if (args[4].equals("query6")) {
            queryListSpecificGameSales(args[0], args[1], args[2], args[5]);
        }

    }

    public static void queryListAllGames(String url, String username, String password){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Query-> List all Games and Information");
            System.out.println();
            String sql = "SELECT \n" +
                    "TITLE,\n" +
                    "GENRE,\n" +
                    "RATING,\n" +
                    "SCORE,\n" +
                    "PLATFORM,\n" +
                    "RETAILERS\n" +
                    " FROM game\n" +
                    " where APPROVED_FLAG = 1";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            System.out.println("[Game Title]                             [Genre]         [Rating]   [Score] [Platform] [Retailers]");

            while(result.next()) {

                String gameTitle = result.getString(1);
                String gameGenre = result.getString(2);
                String gameRating = result.getString(3);
                int gameScore = result.getInt(4);
                String gamePlatform = result.getString(5);
                String gameRetailers = result.getString(6);

                System.out.printf("%-40s %-15s %-10s %-5d   %-10s %-10s \n", gameTitle, gameGenre, gameRating, gameScore, gamePlatform, gameRetailers);
            }
            System.out.println();
            statement.execute(sql);
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error cannot connect");
            e.printStackTrace();
        }
    }

    public static void queryListSpecificGameInfo(String url, String username, String password, String gameTitleSearch){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Query-> List Game and Information For Specific Game Title like: " + gameTitleSearch);
            System.out.println();
            String sql = "SELECT \n" +
                    "TITLE,\n" +
                    "GENRE,\n" +
                    "RATING,\n" +
                    "SCORE,\n" +
                    "PLATFORM,\n" +
                    "RETAILERS,\n" +
                    "PLOT\n" +
                    " FROM game\n" +
                    " where APPROVED_FLAG = 1 and TITLE like '%" + gameTitleSearch + "%'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {

                String gameTitle = result.getString(1);
                String gameGenre = result.getString(2);
                String gameRating = result.getString(3);
                int gameScore = result.getInt(4);
                String gamePlatform = result.getString(5);
                String gameRetailers = result.getString(6);
                String gamePlot = result.getString(7);
                System.out.println("[Game Title]                             [Genre]         [Rating]   [Score] [Platform] [Retailers]");
                System.out.printf("%-40s %-15s %-10s %-5d   %-10s %-10s \n\n", gameTitle, gameGenre, gameRating, gameScore, gamePlatform, gameRetailers);
                System.out.println("[Game Plot]");
                System.out.printf("%-200s \n\n", gamePlot);

            }
            System.out.println();
            statement.execute(sql);
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error cannot connect");
            e.printStackTrace();
        }
    }


    public static void queryListSpecificGameDataWithAdditionalInfo(String url, String username, String password, String gameTitleSearch){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Query-> List Game, Publisher, Developer and Composer for Specific Game title like: " + gameTitleSearch);
            System.out.println();
            String sql = "SELECT \n" +
                    "game.TITLE,\n" +
                    "game.GENRE,\n" +
                    "game.RATING,\n" +
                    "game.SCORE,\n" +
                    "game.PLATFORM,\n" +
                    "game.RETAILERS,\n" +
                    "game.PLOT,\n" +
                    "publisher.PUBLISHING_COMPANY_NAME,\n" +
                    "ComposerInfo.FULL_NAME as ComposerName,\n" +
                    "DeveloperInfo.FULL_NAME as DeveloperName\n" +
                    "FROM game\n" +
                    "left outer join publisher on game.GAME_ID = publisher.GAME_ID\n" +
                    "left outer join composer on game.GAME_ID = composer.GAME_ID\n" +
                    "left outer join person as ComposerInfo on composer.SSN = ComposerInfo.SSN\n" +
                    "left outer join developer on game.GAME_ID = developer.GAME_ID\n" +
                    "left outer join person as DeveloperInfo on developer.SSN = DeveloperInfo.SSN\n" +
                    " where APPROVED_FLAG = 1 and TITLE like '%" + gameTitleSearch + "%'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {

                String gameTitle = result.getString(1);
                String gameGenre = result.getString(2);
                String gameRating = result.getString(3);
                int gameScore = result.getInt(4);
                String gamePlatform = result.getString(5);
                String gameRetailers = result.getString(6);
                String gamePlot = result.getString(7);
                String gamePublisher = result.getString(8);
                String gameComposer = result.getString(9);
                String gameDeveloper = result.getString(10);
                System.out.println("[Game Title]                             [Genre]         [Rating]   [Score] [Platform] [Retailers]");
                System.out.printf("%-40s %-15s %-10s %-5d   %-10s %-10s \n\n", gameTitle, gameGenre, gameRating, gameScore, gamePlatform, gameRetailers);
                System.out.println("[Game Publisher]          [Developer]     [Composer]");
                System.out.printf("%-25s %-15s %-15s\n\n", gamePublisher, gameDeveloper, gameComposer);
                System.out.println("[Game Plot]");
                System.out.printf("%-200s \n\n", gamePlot);


            }
            System.out.println();
            statement.execute(sql);
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error cannot connect");
            e.printStackTrace();
        }
    }

    public static void queryGamesForSpecificCharacter(String url, String username, String password, String gameCharacterSearch){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Query-> List all games a specific character is in like: " + gameCharacterSearch);
            System.out.println();
            String sql = "SELECT\n" +
                    "character_in_game.C_NAME,\n" +
                    "game.TITLE\n" +
                    "FROM character_in_game\n" +
                    "left outer join game on character_in_game.GAME_ID = game.GAME_ID\n" +
                    "where character_in_game.C_NAME like '%" + gameCharacterSearch + "%'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {

                String gameCharacter = result.getString(1);
                String gameTitle = result.getString(2);
                System.out.println(gameCharacter + " is in: " + gameTitle);

            }
            System.out.println();
            statement.execute(sql);
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error cannot connect");
            e.printStackTrace();
        }
    }

    public static void queryCharactersInGame(String url, String username, String password, String gameGameSearch){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Query-> List all games a specific character is in like: " + gameGameSearch);
            System.out.println();
            String sql = "SELECT\n" +
                    "game.TITLE,\n" +
                    "character_in_game.C_NAME\n" +
                    "FROM game\n" +
                    "left outer join character_in_game on character_in_game.GAME_ID = game.GAME_ID\n" +
                    "where game.TITLE like '%" + gameGameSearch + "%'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
                String gameTitle = result.getString(1);
                String gameCharacter = result.getString(2);
                System.out.println(gameTitle + " has character: " + gameCharacter);

            }
            System.out.println();
            statement.execute(sql);
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error cannot connect");
            e.printStackTrace();
        }
    }

    public static void queryListSpecificGameSales(String url, String username, String password, String gameTitleSearch){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Query-> List Game, Publisher, Developer and Composer for Specific Game title like: " + gameTitleSearch);
            System.out.println();
            String sql = "SELECT \n" +
                    "game.TITLE,\n" +
                    "game_sales.Y_YEAR,\n" +
                    "game_sales.M_MONTH,\n" +
                    "game_sales.AMOUNT,\n" +
                    "sum(AMOUNT) over (partition by game.TITLE order by Y_YEAR, M_MONTH) as RunningTotal\n" +
                    "FROM game\n" +
                    "inner join game_sales on game.GAME_ID = game_sales.GAME_ID\n" +
                    " where TITLE like '%" + gameTitleSearch + "%'";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println("[Game Title]                             [Month]  [Sales]     [Running Total]");
            while(result.next()) {

                String gameTitle = result.getString(1);
                int gameYear = result.getInt(2);
                int gameMonth = result.getInt(3);
                int gameSaleAmt = result.getInt(4);
                int gameSaleRunningAmt = result.getInt(5);
                DecimalFormat formatter = new DecimalFormat("#,###,###");
                String gameSaleAmtFormatted = formatter.format(gameSaleAmt);
                String gameSaleRunningAmtFormatted = formatter.format(gameSaleRunningAmt);

                System.out.printf("%-40s %-4d-%-2d  $%9s  $%9s\n", gameTitle, gameYear, gameMonth, gameSaleAmtFormatted, gameSaleRunningAmtFormatted);

            }
            System.out.println();
            statement.execute(sql);
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error cannot connect");
            e.printStackTrace();
        }
    }
}
