
public class update {

	Statement updateS = con.createStatement();
	String table = args[0];
	int gameID;
	int ssn;

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

		updateS.executeUpdate("UPDATE" + table
				+ "SET GAME_ID = gameID, PAGE_VIEWS = pageViews, GENRE = genre, SCORE = score, PLOT = plot, RETAILERS = retailers, PLATFORM = platform, RATING = rating, TITLE = title WHERE GAME_ID = gameID");

	}

	if(table.equals("CHARACTER_IN_GAME"))
	{

		int cName = args[2];
		gameID = args[3];

		updateS.executeUpdate("UPDATE" + table + "SET C_NAME = cName, GAME_ID = gameID WHERE C_NAME = cName");
	}

	if(table.equals("GAME_SALES"))
	{

		gameID = args[2];
		int mMonth = args[3];
		int yYear = args[4];
		int amount = args[5];

		updateS.executeUpdate("UPDATE" + table + "SET GAME_ID = gameID, M_MONTH = mMonth, Y_YEAR = yYear, AMOUNT = amount WHERE GAME_ID = gameID AND M_MONTH = mMonth AND Y_YEAR = yYear");

	}

	if(table.equals("PERSON"))
	{

		ssn = args[2];
		String firstName = args[3];
		String lastName = args[4];
		String dob = args[5];
		String fullName = args[6];

		updateS.executeUpdate("UPDATE" + table + "SET SSN = ssn, FIRST_NAME = firstName, LAST_NAME = lastName, DOB = dob, FULL_NAME = fullName WHERE SSN = ssn");

	}

	if(table.equals("END_USER"))
	{

		String endUserName = args[2];
		boolean adminFlag = args[3];
		ssn = args[4];

		updateS.executeUpdate("UPDATE" + table + "SET END_USER_NAME = endUserName, ADMIN_FLAG = adminFlag, SSN = ssn WHERE END_USER_NAME = endUserName");

	}

	if(table.equals("COMPOSER"))
	{

		ssn = args[2];
		gameID = args[3];

		updateS.executeUpdate("UPDATE" + table + "SET SSN = ssn, GAME_ID = gameID WHERE SSN = ssn");

	}

	if(table.equals("PUBLISHER"))
	{

		String publishingCompanyName = args[2];
		gameID = args[3];

		updateS.executeUpdate("UPDATE" + table + "SET PUBLISHING_COMPANY_NAME = publishingCompanyName, GAME_ID = gameID WHERE GAME_ID = gameID");

	}

	if(table.equals("DEVELOPER"))
	{

		ssn = args[2];
		gameID = args[3];

		updateS.executeUpdate("UPDATE" + table + "SET SSN = ssn, GAME_ID = gameID WHERE SSN = ssn");

	}

}
