
public class Game {
	String gameID;
	String pageViews;
	String approvedFlag;
	String genre;
	String score;
	String plot;
	String retailers;
	String platform;
	String title;
	String rating;

	public static String Command() {
		return "\tGame (G)\n";
	}

	public static void ListAttributes() {
		System.out.println("\t1 GenreID\n\t2 Title\n\t3 PageViews\n\t4 Platform\n\t5 Score");
	}

}