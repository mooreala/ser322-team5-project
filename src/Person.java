package Project4Files;

public class Person {
	String SSN;
	String firstName;
	String lastName;
	String DOB;
	public String GetFullName(){
		return firstName + " " + lastName;
	}
	public static String Command()
	{
		return "\tPerson (P)\n";
	}
	public static void ListAttributes() {
		 System.out.println("\t1 SSN\n\t2 First Name\n\t3 Last Name\n\t4 DOB");
	}

}
