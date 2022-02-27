import java.sql.Statement;

public class insert {

	int gameID;
	int ssn;
	Statement insert = con.createStatement();

	String table = args[0];

	if(table.equals("GAME"))
	{

		gameID = args[2];
		int pageViews = args[3];
		String genre = args[4];
		int score = args[5];
		String plot = args[6];
		String retailers = args[7];
		String platform = args[8];
		char rating = args[9];
		String title = args[10];

		insert.executeUpdate("INSERT INTO" + table
				+ "VALUES (gameID, pageViews, genre, score, plot, retailers, platform, rating, title)");

	}

	if(table.equals("CHARACTER_IN_GAME"))
	{

		int cName = args[2];
		gameID = args[3];

		insert.executeUpdate("INSERT INTO" + table + "VALUES (cName, gameID)");
	}

	if(table.equals("GAME_SALES"))
	{

		gameID = args[2];
		int mMonth = args[3];
		int yYear = args[4];
		int amount = args[5];

		insert.executeUpdate("INSERT INTO" + table + "VALUES (gameID, mMonth, yYear, amount)");

	}

	if(table.equals("PERSON"))
	{

		ssn = args[2];
		String firstName = args[3];
		String lastName = args[4];
		String dob = args[5];
		String fullName = args[6];

		insert.executeUpdate("INSERT INTO" + table + "VALUES (SSN, firstName, lastName, dob, fullName)");

	}

	if(table.equals("END_USER"))
	{

		String endUserName = args[2];
		boolean adminFlag = args[3];
		ssn = args[4];

		insert.executeUpdate("INSERT INTO" + table + "VALUES (endUserName, adminFlag, ssn)");

	}

	if(table.equals("COMPOSER"))
	{

		ssn = args[2];
		gameID = args[3];

		insert.executeUpdate("INSERT INTO" + table + "VALUES (ssn, gameID)");

	}

	if(table.equals("PUBLISHER"))
	{

		String publishingCompanyName = args[2];
		gameID = args[3];

		insert.executeUpdate("INSERT INTO" + table + "VALUES (publishingCompanyName, gameID)");

	}

	if(table.equals("DEVELOPER"))
	{

		ssn = args[2];
		gameID = args[3];

		insert.executeUpdate("INSERT INTO" + table + "VALUES (ssn, gameID)");

	}

}
