
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteHandler {
	private Connection conn;
	private Scanner input;

	public DeleteHandler(DBConnect db) {
		this.conn = db.getConn();
		this.input = new Scanner(System.in);
	}

	public void constructDelete() {
		PreparedStatement stmt;
		String delete = "";
		int dataSelect = 0;

		boolean quit = false;
		while (!quit) {

			/* get information about deletion */
			System.out.println("Please choose data type to delete:");
			System.out.println("1 - Game\n2 - Character\n3 - Game Sales\n4 - Person\n0 - Return to main menu");

			try {
				try {
					dataSelect = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Selection must be an integer. Try again!!\n");
					input.next();
					continue;
				}

				switch (dataSelect) {
				case 0:
					quit = true;
					System.out.println("Returning to main menu...");
					break;
				/*
				 * CASE 1
				 *********************************************************************************************************************************/
				case 1:
					delete = "DELETE FROM GAME WHERE GAME_ID=?";
					stmt = conn.prepareStatement(delete);

					/* get gameID */
					int gameId = -1;
					try {
						System.out.println("Please enter <int>game ID:");
						gameId = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Invalid gameID input. Try again.");
						input.next();
						break;
					}

					/* execute deletion */
					try {
						if (gameId == -1) {
							System.out.println("Bad deletion request. Aborting...");
							break;
						}

						stmt.setInt(1, gameId);
						stmt.execute();
						System.out.println("Game with gameId " + gameId + " has been succesfully deleted.");
					} catch (SQLException e) {
						System.out.println("Unable to execute query. Try again.");
						break;
					}
					break;
				/*
				 * CASE 2
				 *********************************************************************************************************************************/
				case 2:
					delete = "DELETE FROM CHARACTER_IN_GAME WHERE C_NAME=?";
					stmt = conn.prepareStatement(delete);

					/* get character name */
					String c_name = null;
					try {
						System.out.println("Please enter <String> character name:");
						c_name = input.next();
					} catch (Exception e) {
						System.out.println("Error grabbing character name information. Try again.");
						break;
					}

					/* execute delete */
					try {
						if (c_name == null) {
							System.out.println("Bad deletion request. Aborting...");
							break;
						}

						stmt.setString(1, c_name);
						stmt.execute();
						System.out.println("Character with name " + c_name + " has been successfully deleted.");
					} catch (SQLException e) {
						System.out.println("Unable to execute query. Try again.");
						break;
					}
					break;
				/*
				 * CASE 3
				 *********************************************************************************************************************************/
				case 3:
					delete = "DELETE FROM GAME_SALES WHERE GAME_ID=? AND M_MONTH=? AND Y_YEAR=?";
					stmt = conn.prepareStatement(delete);

					/* get gameId */
					int saleId = -1;
					int month = -1;
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
						input.next();
						break;
					}

					/* execute deletion */
					try {
						if (saleId == -1 || month == -1 || year == -1) {
							System.out.println("Bad deletion request. Aborting...");
							break;
						}

						stmt.setInt(1, saleId);
						stmt.setInt(2, month);
						stmt.setInt(3, year);
						stmt.execute();
						System.out.println("Sales information for game with ID " + saleId + " month " + month + "year "
								+ " has been successfully deleted.");
					} catch (SQLException e) {
						System.out.println("Unable to execute query. Try again.");
						break;
					}
					break;
				/*
				 * CASE 4
				 *********************************************************************************************************************************/
				case 4:
					delete = "DELETE FROM PERSON WHERE SSN=?";
					stmt = conn.prepareStatement(delete);

					/* get ssn */
					int ssn = -1;
					try {
						System.out.println("Please enter <int> ssn [LENGTH=9]:");
						ssn = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Invalid ssn input. Try again.");
						input.next();
						break;
					}

					/* execute deletion */
					try {
						if (ssn == -1) {
							System.out.println("Bad deletion request. Aborting...");
							break;
						}

						stmt.setInt(1, ssn);
						stmt.execute();
						System.out.println("Person with associated ssn " + ssn + " has been successfully deleted.");
					} catch (SQLException e) {
						System.out.println("Unable to execute query. Try again.");
						break;
					}
					break;
				/*
				 * DEFAULT
				 *********************************************************************************************************************************/
				default:
					System.out.println("Please select a valid selection...\n");
					break;
				}
			} catch (SQLException e) {
				System.out.println("Unexpected error with built deletion query. Try again...");
				e.printStackTrace();
			}
		}
		return;
	}
}