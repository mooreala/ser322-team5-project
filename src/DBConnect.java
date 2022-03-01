import java.sql.*;

public class DBConnect {
//C:\Users\chris\eclipse-workspace\Project4\src\
//java JdbcLab.java jdbc:mysql://localhost:3306/project5 root Id1034872 com.mysql.cj.jdbc.Driver
//[DATABASE NAME] [USERNAME] [PASSWORD] [DRIVER]
	String url;
	String userName;
	String password;
	String driver;

    Connection conn;

	public  DBConnect(String pUrl, String pUsername, String pPassword, String pDriver) {
		url = pUrl;
		userName = pUsername;
		password = pPassword;
		driver = pDriver;
        conn= null;
			}
	
    public void Connection() {
        try {
            /* load the driver */
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                System.out.println("Error loading driver...");
                e.printStackTrace();
            }

            /* open connection */
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
    }

    public void CloseConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing database connection...");
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return this.conn;
    }

	public void QueryGame()
	{
		ResultSet rs = null;
		Statement stmnt = null;
		Connection conn = null;
		try {
			//Load the JDBC driver
			Class.forName(driver);
			//Make connection
			conn = DriverManager.getConnection(url, userName, password);
			//Make query
			String sql = "SELECT * FROM Game";
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			System.out.println("GameID"
					+ "\tPageViews"
					+ "\tApprovedFlag"
					+ "\tGenre"
					+ "\t\tScore"
					+ "\tRetailers"
					+ "\tPlatform"
					+ "\tRating"
					+ "\tTitle");
			System.out.println("---------------------------------------------------------------------------------------------");

			while (rs.next())
			{
				System.out.println(rs.getString(1) 
						+ "\t" + rs.getString(2) 
						+ "\t\t" + rs.getString(3)
						+ "\t\t" + rs.getString(4) 
						+ "\t" + rs.getString(5)
						+ "\t" + rs.getString(7)
						+ "\t" + rs.getString(8)
						+ "\t" + rs.getString(9)
						);
			}
			//Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs !=null) rs.close();
				if(stmnt !=null) stmnt.close();
				if(conn !=null) conn.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	public Game QueryGame(String GameID) {

		Game obj = new Game();
		ResultSet rs = null;
		Statement stmnt = null;
		Connection conn = null;
		try {
			//Load the JDBC driver
			Class.forName(driver);
			//Make connection
			conn = DriverManager.getConnection(url, userName, password);
			//Make query
			String sql = "SELECT *\r\n"
					+ "FROM Game\r\n"
					+ "WHERE GAME_ID=" + GameID
					;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next())
			{
				obj.gameID = rs.getString(1);
				obj.genre = rs.getString(4);
				obj.pageViews = rs.getString(2);
				obj.title = rs.getString(10);
				obj.platform = rs.getString(8);
				obj.score = rs.getString(5);
			}
			//Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs !=null) rs.close();
				if(stmnt !=null) stmnt.close();
				if(conn !=null) conn.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		return obj;
	}
	public void UpdateGame(Game obj)
	{
		ResultSet rs = null;
		Statement stmnt = null;
		Connection conn = null;
		try {
			//Load the JDBC driver
			Class.forName(driver);
			//Make connection
			conn = DriverManager.getConnection(url, userName, password);
			//Make query
			String sql = "UPDATE Game\r\n"
					+ "SET TITLE='" + obj.title + "',"
					+ "PAGE_VIEWS='" + obj.pageViews + "'\r\n"
					+ "WHERE GAME_ID=" + obj.gameID
					;
			stmnt = conn.createStatement();
			stmnt.executeUpdate(sql);
			//Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs !=null) rs.close();
				if(stmnt !=null) stmnt.close();
				if(conn !=null) conn.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}

