import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class AddDataConnect {

	Connection connection = null;
	Statement stmt = null;
	Statement addMedia = null;

	String driverName = "oracle.jdbc.driver.OracleDriver"; // for Oracle
	// String driverName = “com.mysql.jdbc.Driver”; //for MySql

	String serverName = "141.165.201.104"; // Use this server.
	String portNumber = "1521";
	String sid = "oracle11gs1";

	String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":"
			+ sid; 
	String username = "student032";
	String password = "student032";
	int x;

	public AddDataConnect() {
		try {
			// Load the JDBC driver
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			stmt = connection.createStatement();
			String sql = "Select MAX(mediaid) from media";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			x = rs.getInt(1);
			

		} catch (ClassNotFoundException e) {
			// Could not find the database driver
			System.out.println("ClassNotFoundException : " + e.getMessage());
			
		} catch (SQLException e) {
			// Could not connect to the database
			System.out.println(e.getMessage());
			
		}
	}

	public void addBook(String title, String author, String date, String table) throws SQLException{
		addMedia = connection.createStatement();
		x++;
		String sql2 = "INSERT INTO media VALUES(" + x + ", '" + title + "', 1)";
		String sql3 = "INSERT INTO " + table + " VALUES(" + x + ", '" + author + "', '"+ date + "')";
		addMedia.executeUpdate(sql2);
		addMedia.executeUpdate(sql3);
		System.out.println("Action Performed: \n" + sql2 + "\n" + sql3);
	}
	
	public void addMagazine(String title, String publisher, String date){
		
	}
	
	public void addVideo(String title, String director, String date){
		
	}

}
