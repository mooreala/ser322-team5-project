import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteHandler {
    Connection conn;
    Scanner input;

    DeleteHandler(Connection conn, Scanner scan) {
        this.conn = conn;
        this.input = scan;
    }

    public void constructQuery() {
        PreparedStatement stmt;
        String query = "DELETE FROM ";
        int dataSelect = 0;

        /* get information about deletion query */
        System.out.println("Please choose data type to delete:");
        System.out.println("1 - Game\n2 - Character\n3 - Game Sales\n4 - Person");

        boolean validInput = false;
        while (!validInput) {
            try {
                dataSelect = input.nextInt();

                switch (dataSelect) {
                /* CASE 1 *********************************************************************************************************************************/
                    case 1:
                        query += "GAME, CHARACTER_IN_GAME, PUBLISHER, DEVELOPER WHERE GAMEID=?";
                        stmt = conn.prepareStatement(query);

                        /* get gameID */
                        int gameId = -1;
                        try {
                            System.out.println("Please enter <int>game ID:");
                            gameId = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid gameID input. Try again.");
                            break;
                        }

                        /* execute query  */
                        try {
                            if (gameId == -1) {
                                System.out.println("Bad query. Aborting...");
                                break;
                            }

                            stmt.setInt(1, gameId);
                            stmt.executeQuery();
                            System.out.println("Game with gameId " + gameId + " has been succesfully deleted.");
                        } catch (SQLException e) {
                            System.out.println("Unable to execute query. Try again.");
                            break;
                        }

                        validInput = true;
                        break;
                /* CASE 2 *********************************************************************************************************************************/
                    case 2:
                        query += "CHARACTER_IN_GAME WHERE C_NAME=?";
                        stmt = conn.prepareStatement(query);

                        /* get character name */
                        String c_name = null;
                        try {
                            System.out.println("Please enter <String> character name:");
                            c_name = input.nextLine();
                        } catch (Exception e) {
                            System.out.println("Error grabbing character name information. Try again.");
                            break;
                        }

                        /* execute query */
                        try {
                            if (c_name == null) {
                                System.out.println("Bad query. Aborting...");
                                break;
                            }

                            stmt.setString(1, c_name);
                            stmt.executeQuery();
                            System.out.println("Character with name " + c_name + " has been successfully deleted.");
                        } catch (SQLException e) {
                            System.out.println("Unable to execute query. Try again.");
                            break;
                        }

                        validInput = true;
                        break;
                /* CASE 3 *********************************************************************************************************************************/
                    case 3:
                        query += "GAME_SALES WHERE GAMEID=?AND M_MONTH=? AND Y_YEAR=?";
                        stmt = conn.prepareStatement(query);

                        /* get gameId */
                        int saleId = -1;
                        int  month = -1;
                        int year = -1;
                        try {
                            System.out.println("Please enter <int>game ID:");
                            saleId = input.nextInt();
                            System.out.println("Please enter <int>month:");
                            month = input.nextInt();
                            System.out.println("Please enter <int>year:");
                            year = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Error processing input information, expected data is <int>. Try again.");
                            break;
                        }

                        /* execute query */
                        try {
                            if (saleId == -1 || month == -1 || year == -1) {
                                System.out.println("Bad query. Aborting...");
                                break;
                            }

                            stmt.setInt(1, saleId);
                            stmt.setInt(2, month);
                            stmt.setInt(3, year);
                            stmt.executeQuery();
                            System.out.println("Sales information for game with ID " + saleId + " month " + month + "year " + " has been successfully deleted.");
                        } catch (SQLException e) {
                            System.out.println("Unable to execute query. Try again.");
                            break;
                        }

                        validInput = true;
                        break;
                /* CASE 4 *********************************************************************************************************************************/
                    case 4:
                        query += "PERSON, END_USER, COMPOSER, PUBLISHER, DEVELOPER WHERE SSN=?"; 
                        stmt = conn.prepareStatement(query);

                        /* get ssn */
                        int ssn = -1;
                        try {
                            System.out.println("Please enter <int> ssn [LENGTH=9]:");
                            ssn = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid ssn input. Try again.");
                            break;
                        }

                        /* execute query */
                        try {
                            if (ssn == -1) {
                                System.out.println("Bad query. Aborting...");
                                break;
                            }

                            stmt.setInt(1, ssn);
                            stmt.executeQuery();
                            System.out.println("Person with associated ssn " + ssn + " has been successfully deleted.");
                        } catch (SQLException e) {
                            System.out.println("Unable to execute query. Try again.");
                            break;
                        }

                        validInput = true;
                        break;
                /* DEFAULT *********************************************************************************************************************************/
                    default:
                        System.out.println("Please select a valid selection...\n");
                        System.out.println("1 - Game\n2 - Character\n3 - Game Sales\n4 - Person");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer selection.");
            } catch (SQLException e) {
                System.out.println("Unexpected error with built query. Try again...");
            }
        }
    }
}
