import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class DatabaseConnect {

	Connection connection = null;

	String driverName = "oracle.jdbc.driver.OracleDriver"; // for Oracle
	// String driverName = “com.mysql.jdbc.Driver”; //for MySql

	String serverName = "141.165.201.104"; // Use this server.
	String portNumber = "1521";
	String sid = "oracle11gs1";

	String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":"
			+ sid; // for Oracle
	// uri =”jdbc:mysql://server ip or address:port/database name”;
	// //for Mysql

	String username = "student032";
	String password = "student032";
	int x;

	public DatabaseConnect() {
	}

	public boolean doConnection() {
		try {
			// Load the JDBC driver
			Class.forName(driverName);
			// Create a connection to the database
			connection = DriverManager.getConnection(url, username, password);

			Statement stmt = connection.createStatement();
			String sql = "Select MAX(mediaid) from media";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			x = rs.getInt(1);
			
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			System.out.println("ClassNotFoundException : " + e.getMessage());
			return false;
		} catch (SQLException e) {
			// Could not connect to the database
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public void printBySearch(String table, String search, String option)
			throws SQLException {
		Statement stmt = null;
		String[] columnNames = new String[5];
		String query = null;
		if (table == "book") {
			query = "select title, author, publicationdate, mediaid, instock from book join media on book.bookid = media.mediaid where upper("
					+ option + ") like upper('%" + search + "%') order by title";

			columnNames[0] = "Title";
			columnNames[1] = "Author";
			columnNames[2] = "Publish Date";
			columnNames[3] = "Media ID";
			columnNames[4] = "InStock";
		}
		if (table == "magazine") {
			query = "select title, publisher, issuedate, mediaid, instock from magazine join media on magazine.magazineid = media.mediaid where upper("
					+ option + ") like upper('%" + search + "%') order by title";

			columnNames[0] = "Title";
			columnNames[1] = "Publisher";
			columnNames[2] = "Issue Date";
			columnNames[3] = "Media ID";
			columnNames[4] = "InStock";
		}
		if (table == "video") {
			query = "select title, director, releasedate, mediaid, instock from video join media on video.videoid = media.mediaid where upper("
					+ option + ") like upper('%" + search + "%') order by title";

			columnNames[0] = "Title";
			columnNames[1] = "Director";
			columnNames[2] = "Release Date";
			columnNames[3] = "Media ID";
			columnNames[4] = "InStock";
		}

		System.out.println("TABLE: " + table + " SEARCH: " + search
				+ " OPTION: " + option);
		
		stmt = connection.createStatement();
		String queryCount = "SELECT COUNT(mediaid) from "+table+" join media on "+table+"."+table+"id = media.mediaid";
		ResultSet rsCount = stmt.executeQuery(queryCount);
		int count = 0;
		while(rsCount.next()){
			count = rsCount.getInt(1);
		}
		ResultSet rs = stmt.executeQuery(query);
		Object[][] data = new Object[count][columnNames.length];

		int i = 0;
		while (rs.next()) {
			String title = rs.getString(1);
			String author = rs.getString(2);
			String publicationdate = rs.getString(3);
			int mediaid = rs.getInt(4);
			boolean instock;
			if (rs.getInt(5) == 0)
				instock = false;
			else
				instock = true;

			data[i][0] = title;
			data[i][1] = author;
			data[i][2] = publicationdate;
			data[i][3] = mediaid;
			data[i][4] = instock;

			System.out.println("TITLE: " + title);
			System.out.println("AUTHOR: " + author);
			System.out.println("PUBL DATE: " + publicationdate);
			System.out.println("MEDIAID: " + mediaid);
			System.out.println("INSTOCK: " + instock);

			if (count - 1 > i)
				i++;
		}
		stmt.close();

		Search.MyTableModel.setData(data);
		Search.MyTableModel.setColumnNames(columnNames);
	}

	public void printBooksByStock(int stock) throws SQLException {
		Statement stmt = null;
		String query = "SELECT title, author, publicationdate, mediaid, instock FROM BOOK join MEDIA ON book.bookid = media.mediaid WHERE INSTOCK="
				+ stock + " order by title";

		// String query = "SELECT * FROM Book";

		stmt = connection.createStatement();
		String queryCount = "SELECT COUNT(mediaid) from book join media on book.bookid = media.mediaid where instock = "+stock+" order by title";
		ResultSet rsCount = stmt.executeQuery(queryCount);
		int count = 0;
		while(rsCount.next()){
			count = rsCount.getInt(1);
		}
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		String[] columnNames = { "Title", "Author", "Publish Date", "Media ID",
				"InStock" };
		Object[][] data = new Object[count][columnNames.length];
		System.out.println(rs.getFetchSize());

		int i = 0;
		while (rs.next()) {
			String title = rs.getString(1);
			String author = rs.getString(2);
			String publicationdate = rs.getString(3);
			int mediaid = rs.getInt(4);
			boolean instock;
			if (rs.getInt(5) == 0)
				instock = false;
			else
				instock = true;

			data[i][0] = title;
			data[i][1] = author;
			data[i][2] = publicationdate;
			data[i][3] = mediaid;
			data[i][4] = instock;

			// System.out.println("TITLE: " + title);
			// System.out.println("AUTHOR: " + author);
			// System.out.println("PUBL DATE: " + publicationdate);
			// System.out.println("MEDIAID: " + mediaid);
			// System.out.println("INSTOCK: " + instock);

			if (count - 1 > i)
				i++;
		}
		stmt.close();

		Search.MyTableModel.setData(data);
		Search.MyTableModel.setColumnNames(columnNames);
	}
	

	public void addMedia(String title, String author, String date, String table) throws SQLException{
		Statement stmt = null;
		stmt = connection.createStatement();
		x++;
		String sql2 = "INSERT INTO media VALUES(" + x + ", '" + title + "', 1)";
		String sql3 = "INSERT INTO " + table + " VALUES(" + x + ", '" + author + "', '"+ date + "')";
		stmt.executeUpdate(sql2);
		stmt.executeUpdate(sql3);
		System.out.println("Action Performed: \n" + sql2 + "\n" + sql3);
	}
}
