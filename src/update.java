
public class update {

	public void insert() {
		Statement updateS = con.createStatement();

		// again passing here first parameter for update method
		String table = " ";
		String gameID;
		String ssn;

		if (table.equals("GAME")) {

			gameID = game.gameID;
			String pageViews = game.pageViews;
			String approvedFlag = game.approvedFlag;
			String genre = game.genre;
			String score = game.score;
			String plot = game.plot;
			String retailers = game.retailers;
			String platform = game.platform;
			String rating = game.rating;
			String title = game.title;

			updateS.executeUpdate("UPDATE" + table
					+ "SET GAME_ID = ?, PAGE_VIEWS = ?, GENRE = ?, SCORE = ?, PLOT = ?, RETAILERS = ?, PLATFORM = ?, RATING = ?, TITLE = ? WHERE GAME_ID = ?");

		}

		if (table.equals("CHARACTER_IN_GAME")) {

			String cName = character.cName;
			gameID = character.gameID;

			updateS.executeUpdate("UPDATE" + table + "SET C_NAME = cName, GAME_ID = gameID WHERE C_NAME = cName");
		}

		if (table.equals("GAME_SALES")) {

			gameID = gamesales.gameID;
			String mMonth = gamesales.mMonth;
			String yYear = gamesales.yYear;
			String amount = gamesales.amount;

			updateS.executeUpdate("UPDATE" + table
					+ "SET GAME_ID = gameID, M_MONTH = mMonth, Y_YEAR = yYear, AMOUNT = amount WHERE GAME_ID = gameID AND M_MONTH = mMonth AND Y_YEAR = yYear");

		}

		if (table.equals("PERSON")) {

			ssn = person.SSN;
			String firstName = person.firstName;
			String lastName = person.lastName;
			String dob = person.DOB;
			String fullName = person.getFullName();

			updateS.executeUpdate("UPDATE" + table
					+ "SET SSN = ssn, FIRST_NAME = firstName, LAST_NAME = lastName, DOB = dob, FULL_NAME = fullName WHERE SSN = ssn");

		}

		if (table.equals("END_USER")) {
			String endUserName = user.EndUserName;
			String adminFlag = user.AdminFlag;
			ssn = user.SSN;

			updateS.executeUpdate("UPDATE" + table
					+ "SET END_USER_NAME = endUserName, ADMIN_FLAG = adminFlag, SSN = ssn WHERE END_USER_NAME = endUserName");

		}

		if (table.equals("COMPOSER")) {

			ssn = composer.SSN;
			gameID = composer.GameID;

			updateS.executeUpdate("UPDATE" + table + "SET SSN = ssn, GAME_ID = gameID WHERE SSN = ssn");

		}

		if (table.equals("PUBLISHER")) {

			String publishingCompanyName = publisher.CompanyName;
			gameID = publisher.GameID;

			updateS.executeUpdate("UPDATE" + table
					+ "SET PUBLISHING_COMPANY_NAME = publishingCompanyName, GAME_ID = gameID WHERE GAME_ID = gameID");

		}

		if (table.equals("DEVELOPER")) {

			ssn = developer.SSN;
			gameID = developer.SSN;

			updateS.executeUpdate("UPDATE" + table + "SET SSN = ssn, GAME_ID = gameID WHERE SSN = ssn");

		}

	}
}
