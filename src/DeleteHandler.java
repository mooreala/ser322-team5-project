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
                    case 1:
                        validInput = true;
                        query += "GAME WHERE GAMEID=?";
                        stmt = conn.prepareStatement(query);
                        break;
                    case 2:
                        query += "CHARACTER_IN_GAME WHERE C_NAME=?";
                        stmt = conn.prepareStatement(query);
                        validInput = true;
                        break;
                    case 3:
                        query += "GAME_SALES WHERE GAMEID=?";
                        stmt = conn.prepareStatement(query);
                        validInput = true;
                        break;
                    case 4:
                        query += "PERSON WHERE SSN=?";
                        stmt = conn.prepareStatement(query);
                        validInput = true;
                        break;
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
