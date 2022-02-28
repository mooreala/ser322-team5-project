package Project4Files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIMenu {
	private  String input;
	private  BufferedReader reader;
	public int actionType;
	public String invalid = "--Invalid Data - Try Again--";
	public static void main(String[] args) throws IOException {
		new CLIMenu().MainMenuDisplay();
	}
	
	private void MainMenuDisplay() throws IOException
	{
		reader = new BufferedReader(
	            new InputStreamReader(System.in));
		System.out.println("----MAIN MENU----\nSelect command:");
		System.out.print(Insert.Command() + Update.Command() + Delete.Command() + "\tQuery (Q)\n");
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
			actionType = 3;
			Command("Delete");
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
			case 3:
				DeletePersonMenu();
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
		input = reader.readLine();//Which attribute to edit
		//Update Object value and loop
		switch (input) {
		case "":
			//TODO UPDATE The obj is passed as argument
			System.out.println("TODO Update Person");
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
	private void DeletePersonMenu() throws IOException {
		System.out.print("Enter SSN of Person to be deleted:");
		input = reader.readLine();
		System.out.println("TODO Delete Person");
		//TODO DELETE the input is passed as argument
		System.out.println("----Person Deleted----");
		MainMenuDisplay();
	}
	
	
	private void DisplayExit() {
		 System.out.print("\tExit (X)\n\tMain Menu (M)\nCommand:");
	}
	

}
