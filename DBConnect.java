
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	String url;
	String userName;
	String password;
	String driver;

	Connection conn;

	public DBConnect(String pUrl, String pUsername, String pPassword, String pDriver) {
		url = pUrl;
		userName = pUsername;
		password = pPassword;
		driver = pDriver;
		conn = null;
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

	public void QueryGame() {
		ResultSet rs = null;
		Statement stmnt = null;
		try {
			// Load the JDBC driver
			Class.forName(driver);
			// Make connection
			conn = DriverManager.getConnection(url, userName, password);
			// Make query
			String sql = "SELECT * FROM Game";
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			System.out.println("GameID" + "\tPageViews" + "\tApprovedFlag" + "\tGenre" + "\t\tScore" + "\tRetailers"
					+ "\tPlatform" + "\tRating" + "\tTitle");
			System.out.println(
					"---------------------------------------------------------------------------------------------");

			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t"
						+ rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(7) + "\t" + rs.getString(8)
						+ "\t" + rs.getString(9));
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	}

	public Game QueryGame(String GameID) {
		ResultSet rs = null;
		Statement stmnt = null;
		Game obj = new Game();
		try {
			String sql = "SELECT *\r\n" + "FROM Game\r\n" + "WHERE GAME_ID=" + GameID;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.gameID = rs.getString(1);
				obj.genre = rs.getString(4);
				obj.pageViews = rs.getString(2);
				obj.title = rs.getString(10);
				obj.platform = rs.getString(8);
				obj.score = rs.getString(5);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public User QueryUser(String SSN) {
		ResultSet rs = null;
		Statement stmnt = null;
		User obj = new User();
		try {
			String sql = "SELECT *\r\n" + "FROM END_USER\r\n" + "WHERE SSN=" + SSN;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.EndUserName = rs.getString(1);
				obj.AdminFlag = rs.getString(2);
				obj.SSN = rs.getString(3);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public Person QueryPerson(String SSN) {
		ResultSet rs = null;
		Statement stmnt = null;
		Person obj = new Person();
		try {
			// Load the JDBC driver
			Class.forName(driver);
			// Make connection
			conn = DriverManager.getConnection(url, userName, password);
			// Make query
			String sql = "SELECT *\r\n" + "FROM PERSON\r\n" + "WHERE SSN=" + SSN;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.SSN = rs.getString(1);
				obj.firstName = rs.getString(2);
				obj.lastName = rs.getString(3);
				obj.DOB = rs.getString(4);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public Character QueryCharacter(String GameID) {
		ResultSet rs = null;
		Statement stmnt = null;
		Character obj = new Character();
		try {
			// Make query
			String sql = "SELECT *\r\n" + "FROM CHARACTER_IN_GAME\r\n" + "WHERE GAME_ID=" + GameID;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.name = rs.getString(1);
				obj.GameID = rs.getString(2);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public Developer QueryDeveloper(String SSN) {
		ResultSet rs = null;
		Statement stmnt = null;
		Developer obj = new Developer();
		try {
			// Load the JDBC driver
			Class.forName(driver);
			// Make connection
			conn = DriverManager.getConnection(url, userName, password);
			// Make query
			String sql = "SELECT *\r\n" + "FROM DEVELOPER\r\n" + "WHERE SSN=" + SSN;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.SSN = rs.getString(1);
				obj.GameID = rs.getString(2);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public Composer QueryComposer(String SSN) {
		ResultSet rs = null;
		Statement stmnt = null;
		Composer obj = new Composer();
		try {
			String sql = "SELECT *\r\n" + "FROM COMPOSER\r\n" + "WHERE SSN=" + SSN;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.SSN = rs.getString(1);
				obj.GameID = rs.getString(2);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public GameSales QueryGameSales(String GameID) {
		ResultSet rs = null;
		Statement stmnt = null;
		GameSales obj = new GameSales();
		try {
			String sql = "SELECT *\r\n" + "FROM GAME_SALES\r\n" + "WHERE GAME_ID=" + GameID;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.GameID = rs.getString(1);
				obj.Month = rs.getString(2);
				obj.Year = rs.getString(3);
				obj.Amount = rs.getString(4);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public Publisher QueryPublisher(String GameID) {
		ResultSet rs = null;
		Statement stmnt = null;
		Publisher obj = new Publisher();
		try {
			String sql = "SELECT *\r\n" + "FROM PUBLISHER\r\n" + "WHERE SSN=" + GameID;
			stmnt = conn.createStatement();
			rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				obj.CompanyName = rs.getString(1);
				obj.GameID = rs.getString(2);
			}
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	// This method updates data, not sure if we will use it
	public void UpdateGame(Game obj) {
		ResultSet rs = null;
		Statement stmnt = null;
		try {
			// Load the JDBC driver
			Class.forName(driver);
			// Make connection
			conn = DriverManager.getConnection(url, userName, password);
			// Make query
			String sql = "UPDATE Game\r\n" + "SET TITLE='" + obj.title + "'," + "PAGE_VIEWS='" + obj.pageViews + "'\r\n"
					+ "WHERE GAME_ID=" + obj.gameID;
			stmnt = conn.createStatement();
			stmnt.executeUpdate(sql);
			// Close connections
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmnt != null)
					stmnt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}