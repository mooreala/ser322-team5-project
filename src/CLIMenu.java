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
    public static DeleteHandler dHandler;
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

        dHandler = new DeleteHandler(db);
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
			dHandler.constructDelete();
            MainMenuDisplay();
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
            db.CloseConnection();
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
		//TODO INSERT
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
			break;
		case "2":
			System.out.print("New First Name:");
			input = reader.readLine();
			obj.firstName = input;
			break;
		case "3":
			System.out.print("New Last Name:");
			input = reader.readLine();
			obj.lastName = input;
			break;
		case "4":
			System.out.print("New DOB:");
			input = reader.readLine();
			obj.DOB = input;
			break;
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
		
	}
	private void UpdateGameMenu(Game obj) throws IOException {
		//Need to check if SSN is valid and pull data from DB
				System.out.println("Select attribute to update or press enter to execute changes:");
				Game.ListAttributes();
				System.out.print("Selection:");
				input = reader.readLine();//Which attribute to edit
				//Update Object value and loop
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
					break;
				case "2":
					System.out.print("New Title:");
					input = reader.readLine();
					obj.title = input;
					break;
				case "3":
					System.out.print("New PageViews:");
					input = reader.readLine();
					obj.pageViews = input;
					break;
				case "4":
					System.out.print("New Platform:");
					input = reader.readLine();
					obj.platform = input;
					break;
				case "5":
					System.out.print("New Score:");
					input = reader.readLine();
					obj.score = input;
					break;
					default:
						System.out.println(invalid);
				}
				UpdateGameMenu(obj);
	}

	
	
	private void DisplayExit() {
		 System.out.print("\tExit (X)\n\tMain Menu (M)\n-----------------\nCommand:");
	}
	

}
