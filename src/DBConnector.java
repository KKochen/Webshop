import java.sql.*;

public class DBConnector {
	private static DBConnector DBConnect = new DBConnector();
	
	public Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/webshop","computer","yay");
		}		
	
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return connection;
	}	
	
	public static Connection getConnection() {
		return DBConnect.createConnection();
	}
}
