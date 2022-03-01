public class GameSales {
	String GameID;
	String Month;
	String Year;
	String Amount;
	public static String Command()
	{
		return "\tGame Sales (GS)\n";
	}
	public static void ListAttributes() {
		 System.out.println("\t1 Game ID\n\t2 Month\n\t3 Year\n\t4 Amount");
	}
}
