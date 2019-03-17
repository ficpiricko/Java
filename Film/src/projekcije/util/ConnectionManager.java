package projekcije.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private ConnectionManager () {
		super();
	}
	
	private static Connection conn = null;
	
	public static Connection getConnection () {
		if (conn == null) {
			try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekcije","root","root");
					
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeConnection () {
		try {
			if (conn !=null)
				conn.close();
				conn=null;
		}catch(SQLException e) {
			e.printStackTrace();
		}

}
}
