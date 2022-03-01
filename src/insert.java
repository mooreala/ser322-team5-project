import java.sql.Statement;

public class insert {

	public void insert() {

		String gameID;
		String ssn;
		Statement insert = con.createStatement();

		// so here we pass whatever the first thing is of the parameters entered to
		// insert
		String table = "";

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

			insert.executeUpdate("INSERT INTO" + table
					+ "VALUES (gameID, pageViews, genre, score, plot, retailers, platform, rating, title)");

		}

		if (table.equals("CHARACTER_IN_GAME")) {

			String cName = character.cName;
			gameID = character.gameID;

			insert.executeUpdate("INSERT INTO" + table + "VALUES (cName, gameID)");
		}

		if (table.equals("GAME_SALES")) {

			gameID = gamesales.gameID;
			String mMonth = gamesales.mMonth;
			String yYear = gamesales.yYear;
			String amount = gamesales.amount;

			insert.executeUpdate("INSERT INTO" + table + "VALUES (gameID, mMonth, yYear, amount)");

		}

		if (table.equals("PERSON")) {

			ssn = person.SSN;
			String firstName = person.firstName;
			String lastName = person.lastName;
			String dob = person.DOB;
			String fullName = person.getFullName();

			insert.executeUpdate("INSERT INTO" + table + "VALUES (SSN, firstName, lastName, dob, fullName)");

		}

		if (table.equals("END_USER")) {

			String endUserName = user.EndUserName;
			String adminFlag = user.AdminFlag;
			ssn = user.SSN;

			insert.executeUpdate("INSERT INTO" + table + "VALUES (endUserName, adminFlag, ssn)");

		}

		if (table.equals("COMPOSER")) {

			ssn = composer.SSN;
			gameID = composer.GameID;

			insert.executeUpdate("INSERT INTO" + table + "VALUES (ssn, gameID)");

		}

		if (table.equals("PUBLISHER")) {

			String publishingCompanyName = publisher.CompanyName;
			gameID = publisher.GameID;

			insert.executeUpdate("INSERT INTO" + table + "VALUES (publishingCompanyName, gameID)");

		}

		if (table.equals("DEVELOPER")) {

			ssn = developer.SSN;
			gameID = developer.SSN;

			insert.executeUpdate("INSERT INTO" + table + "VALUES (ssn, gameID)");

		}

	}
}
