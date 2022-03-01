import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//cd C:\Users\chris\eclipse-workspace\Project4\src\
//javac *.java
//java Project4Files.CLIMenu
public class CLIMenu {
	private  String input;
	private  BufferedReader reader;
	public int actionType;
	public static DBConnect db;
	public static boolean connected = false;
	public String invalid = "--Invalid Data - Try Again--";
	public static void main(String[] args) throws IOException {
		if(connected)
		{
			new CLIMenu().MainMenuDisplay();
		}
		System.out.print("Enter Database name, username,password and driver to connect to DB:");
		new CLIMenu().Connection();
		new CLIMenu().MainMenuDisplay();
		
	}
	private void Connection() throws IOException
	{
		reader = new BufferedReader(
	            new InputStreamReader(System.in));
		input = reader.readLine();
		String[] array = input.split(" ");
		 db = new DBConnect(array[0],array[1],array[2],array[3]);

        db.Connection();
        if (db.getConn() == null) {
            System.out.println("Connection to database failed. Aborting...");
            System.exit(1);
        } 
		System.out.println("Connection to DB Succesfull!");		
	}
	
	private void MainMenuDisplay() throws IOException
	{
		reader = new BufferedReader(
	            new InputStreamReader(System.in));
		System.out.println("----MAIN MENU----\nSelect command:");
		System.out.print("\tInsert (I)\n" + "\tUpdate (U)\n" + "\tDelete (D)\n" + "\tQuery (Q)\n");
		DisplayExit();
		input = reader.readLine();
		switch (input.toUpperCase()) {
		case "I":
			actionType = 1;
			Command("Insert");
			break;
		case "U":
			actionType = 2;
			Command("Update");
			break;
		case "D":
			//actionType = 3;
			//Call Delete
			break;
		case "Q":
			actionType = 4;
			Command("Query");
			break;
		case "M":
			MainMenuDisplay();
			break;
		case "X":
			System.out.println("Program terminated...");
			System.exit(0);
			break;
			default:
				System.out.println("--Invalid Command--");
				MainMenuDisplay();
		}
	}
	
	private void Command(String selection) throws IOException {
		System.out.println("Select which object to " + selection.toUpperCase() + ":");
		System.out.print(Game.Command() + Person.Command() + User.Command() + Character.Command() + Composer.Command());
		DisplayExit();
		input = reader.readLine();
		switch (input.toUpperCase()){
		case "P":
			switch (actionType) {
			case 1:
				InsertPersonMenu();
				break;
			case 2:
				System.out.print("Type person ID:");
				input = reader.readLine();
				UpdatePersonMenu(input);
				break;
			}
			break;
		case "G":
			switch (actionType) {
			case 1:
				InsertGameMenu();
				break;
			case 2:
				System.out.print("Type Game ID:");
				input = reader.readLine();
				Game obj = new Game();
				obj = db.QueryGame(input);
				UpdateGameMenu(obj);
				break;
			}
			break;
		case "M":
			MainMenuDisplay();
			break;
		case "X":
			System.out.println("Program terminated...");
			System.exit(0);
			break;
			default:
				System.out.println("--Invalid Command--");
				MainMenuDisplay();
		}
	}

	private void InsertPersonMenu() throws IOException {
		
		System.out.print("Format [SSN] [FIRST NAME] [LAST NAME] [DOB MM-DD-YYYY]\nType person information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 4)
		{
			System.out.println(invalid);
			InsertPersonMenu();
			return;
		}
		Person obj = new Person();
		obj.SSN = values[0];
		obj.firstName = values[1];
		obj.lastName = values[2];
		obj.DOB = values[3];
		System.out.println("TODO Insert Person");
		
			ssn = obj.SSN;
			String firstName = obj.firstName;
			String lastName = obj.lastName;
			String dob = obj.DOB;
			String fullName = obj.getFullName();

			insert.executeUpdate("INSERT INTO PERSON" + "VALUES (SSN, firstName, lastName, dob, fullName)");
		
	}
	private void UpdatePersonMenu(String SSN) throws IOException
	{
		//Need to check if SSN is valid and pull data from DB
		Person obj = new Person();
		System.out.println("Select attribute to update or press enter to execute changes:");
		Person.ListAttributes();
		System.out.print("Selection:");
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			System.out.println("TODO Update Person");
			MainMenuDisplay();
			return;
		case "1":
			System.out.print("New SSN:");
			input = reader.readLine();
			obj.SSN = input;
				
				String ssn = obj.SSN;
				updateStatement.executeUpdate("UPDATE PERSON SET SSN = ssn WHERE SSN=ssn");
			break;
		case "2":
			System.out.print("New First Name:");
			input = reader.readLine();
			obj.firstName = input;
				
				String firstName = obj.firstName;
				updateStatement.executeUpdate("UPDATE PERSON SET FIRST_NAME = firstName WHERE SSN=ssn");
				
			break;
		case "3":
			System.out.print("New Last Name:");
			input = reader.readLine();
			obj.lastName = input;
				
				String lastName = obj.lastName;
				updateStatement.executeUpdate("UPDATE PERSON SET LAST_NAME = lastName WHERE SSN=ssn");
					
			break;
		case "4":
			System.out.print("New DOB:");
			input = reader.readLine();
			obj.DOB = input;
			break;
				
				String dob = obj.DOB;
				updateStatement.executeUpdate("UPDATE PERSON SET DOB = dob WHERE SSN=ssn");
				
			default:
				System.out.println(invalid);
		}
		UpdatePersonMenu(SSN);
	}

	
	private void InsertGameMenu() throws IOException {
		System.out.print("Format [GAME_ID] [PAGE_VIEWS] [GENRE] [SCORE] [PLOT] [RETAILERS] [PLATFORM] [RATING] [TITLE]\nType game information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 9)
		{
			System.out.println(invalid);
			InsertGameMenu();
			return;
		}
		Game obj = new Game();
		obj.gameID = values[0];
		obj.pageViews = values[1];
		obj.approvedFlag = "TRUE";
		obj.genre = values[2];
		obj.score = values[3];
		obj.plot = values[4];
		obj.retialer = values[5];
		obj.platform = values[6];
		obj.rating = values[7];
		obj.title = values[8];
		System.out.println("TODO Insert Game");
		//TODO INSERT
		
		gameID = obj.gameID;
			String pageViews = obj.pageViews;
			String approvedFlag = obj.approvedFlag;
			String genre = obj.genre;
			String score = obj.score;
			String plot = obj.plot;
			String retailers = obj.retailers;
			String platform = obj.platform;
			String rating = obj.rating;
			String title = obj.title;

			insert.executeUpdate("INSERT INTO GAME"
					+ "VALUES (gameID, pageViews, genre, score, plot, retailers, platform, rating, title)");

	}
	private void UpdateGameMenu(Game obj) throws IOException {
		//Need to check if SSN is valid and pull data from DB
				System.out.println("Select attribute to update or press enter to execute changes:");
				Game.ListAttributes();
				System.out.print("Selection:");
				input = reader.readLine();//Which attribute to edit
				//Update Object value and loop
		
				String gameID = obj.gameID;
				switch (input) {
				case "":
					db.UpdateGame(obj);
					System.out.println("Game Updated!");
					MainMenuDisplay();
					return;
				case "1":
					System.out.print("New Genre:");
					input = reader.readLine();
					obj.genre = input;
						
						String genre = obj.genre;
						updateStatement.executeUpdate("UPDATE GAME SET GENRE = genre WHERE GAME_ID = gameID");
						
						
					break;
				case "2":
					System.out.print("New Title:");
					input = reader.readLine();
					obj.title = input;
						
						String title = obj.title;
						updateStatement.executeUpdate("UPDATE GAME SET TITLE = title WHERE GAME_ID = gameID");
					break;
				case "3":
					System.out.print("New PageViews:");
					input = reader.readLine();
					obj.pageViews = input;
						
						String pageViews = obj.pageViews;
						updateStatement.executeUpdate("UPDATE GAME SET PAGE_VIEWS = pageViews WHERE GAME_ID = gameID");
					break;
				case "4":
					System.out.print("New Platform:");
					input = reader.readLine();
					obj.platform = input;
						
						String platform = obj.platform;
						updateStatement.executeUpdate("UPDATE GAME SET PLATFORM = platform WHERE GAME_ID = gameID");
						
					break;
				case "5":
					System.out.print("New Score:");
					input = reader.readLine();
					obj.score = input;
						
						String score = obj.score;
						updateStatement.executeUpdate("UPDATE GAME SET SCORE = score WHERE GAME_ID = gameID");
						
					break;
					default:
						System.out.println(invalid);
				}
				UpdateGameMenu(obj);
	}

		private void InsertUserMenu() throws IOException {
		System.out.print("Format [USER_NAME] [ADMIN_FLAG] [SSN]\nType game information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 3)
		{
			System.out.println(invalid);
			InsertUserMenu();
			return;
		}
		User obj = new User();
		obj.EndUserName = values[0];	
		obj.AdminFlag = values[1];
		obj.SSN = values[2];
		//TODO
	}
	private void UpdateUserMenu(User obj) throws IOException
	{
		System.out.println("Select attribute to update or press enter to execute changes:");
		User.ListAttributes();
		System.out.print("Selection:");
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			MainMenuDisplay();
			return;
		case "1":
			System.out.print("New User Name:");
			input = reader.readLine();
			obj.SSN = input;
			break;
		case "2":
			System.out.print("Approved Flag:");
			input = reader.readLine();
			obj.firstName = input;
			break;
		case "3":
			System.out.print("New SSN:");
			input = reader.readLine();
			obj.lastName = input;
			break;
			default:
				System.out.println(invalid);
		}
		UpdateUserMenu(obj);
	}
	
	private void InsertCharacterMenu() throws IOException {
		System.out.print("Format [NAME] [GAME_ID]\nType game information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 2)
		{
			System.out.println(invalid);
			InsertCharacterMenu();
			return;
		}
		Character obj = new Character();
		obj.name = values[0];	
		obj.GameID = values[1];
		//TODO
	}
	private void UpdateCharacterMenu(Character obj) throws IOException
	{
		System.out.println("Select attribute to update or press enter to execute changes:");
		Character.ListAttributes();
		System.out.print("Selection:");
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			MainMenuDisplay();
			return;
		case "1":
			System.out.print("New Character Name:");
			input = reader.readLine();
			obj.name = input;
			break;
		case "2":
			System.out.print("Game_ID:");
			input = reader.readLine();
			obj.GameID = input;
			break;
			default:
				System.out.println(invalid);
		}
		UpdateCharacterMenu(obj);
	}
	
	private void InsertDeveloperMenu() throws IOException {
		System.out.print("Format [SSN] [GAME_ID]\nType game information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 2)
		{
			System.out.println(invalid);
			InsertDeveloperMenu();
			return;
		}
		Developer obj = new Developer();
		obj.SSN = values[0];	
		obj.GameID = values[1];
		//TODO
	}
	private void UpdateDeveloperMenu(Developer obj) throws IOException
	{
		System.out.println("Select attribute to update or press enter to execute changes:");
		Developer.ListAttributes();
		System.out.print("Selection:");
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			MainMenuDisplay();
			return;
		case "1":
			System.out.print("New SSN:");
			input = reader.readLine();
			obj.SSN = input;
			break;
		case "2":
			System.out.print("New Game_ID:");
			input = reader.readLine();
			obj.GameID = input;
			break;
			default:
				System.out.println(invalid);
		}
		UpdateDeveloperMenu(obj);
	}

	private void InsertComposerMenu() throws IOException {
		System.out.print("Format [SSN] [GAMEID]\nType game information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 3)
		{
			System.out.println(invalid);
			InsertComposerMenu();
			return;
		}
		Composer obj = new Composer();
		obj.SSN = values[0];	
		obj.GameID = values[1];
		//TODO
	}
	private void UpdateComposerMenu(Composer obj) throws IOException
	{
		System.out.println("Select attribute to update or press enter to execute changes:");
		Composer.ListAttributes();
		System.out.print("Selection:");
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			MainMenuDisplay();
			return;
		case "1":
			System.out.print("New SSN:");
			input = reader.readLine();
			obj.SSN = input;
			break;
		case "2":
			System.out.print("GameID:");
			input = reader.readLine();
			obj.GameID = input;
			break;
			default:
				System.out.println(invalid);
		}
		UpdateComposerMenu(obj);
	}
	
	private void InsertGameSalesMenu() throws IOException {
		System.out.print("Format [GAMEID] [MONTH] [YEAR] [AMOUNT]\nType game information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 3)
		{
			System.out.println(invalid);
			InsertGameSalesMenu();
			return;
		}
		GameSales obj = new GameSales();
		obj.GameID = values[0];	
		obj.Month = values[0];	
		obj.Year = values[0];	
		obj.Amount = values[1];
		//TODO
	}
	private void UpdateGameSalesMenu(GameSales obj) throws IOException
	{
		System.out.println("Select attribute to update or press enter to execute changes:");
		GameSales.ListAttributes();
		System.out.print("Selection:");
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			MainMenuDisplay();
			return;
		case "1":
			System.out.print("New GameID:");
			input = reader.readLine();
			obj.GameID = input;
			break;
		case "2":
			System.out.print("New Month:");
			input = reader.readLine();
			obj.Month = input;
			break;
		case "3":
			System.out.print("New Year:");
			input = reader.readLine();
			obj.Year = input;
			break;
		case "4":
			System.out.print("New Amount:");
			input = reader.readLine();
			obj.Amount = input;
			break;
			default:
				System.out.println(invalid);
		}
		UpdateGameSalesMenu(obj);
	}
	
	private void InsertPublisherMenu() throws IOException {
		System.out.print("Format [COMPANY NAME] [GAME_ID]\nType game information:");
		input = reader.readLine();
		String[] values = input.split(" ");
		if(values.length != 2)
		{
			System.out.println(invalid);
			InsertPublisherMenu();
			return;
		}
		Publisher obj = new Publisher();
		obj.CompanyName = values[0];	
		obj.GameID = values[1];
		//TODO
	}
	private void UpdatePublisherMenu(Publisher obj) throws IOException
	{
		System.out.println("Select attribute to update or press enter to execute changes:");
		Publisher.ListAttributes();
		System.out.print("Selection:");
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			MainMenuDisplay();
			return;
		case "1":
			System.out.print("New Company Name:");
			input = reader.readLine();
			obj.CompanyName = input;
			break;
		case "2":
			System.out.print("New Game_ID:");
			input = reader.readLine();
			obj.GameID = input;
			break;
			default:
				System.out.println(invalid);
		}
		UpdatePublisherMenu(obj);
	}
	
	
	private void DisplayExit() {
		 System.out.print("\tExit (X)\n\tMain Menu (M)\n-----------------\nCommand:");
	}
	

}
