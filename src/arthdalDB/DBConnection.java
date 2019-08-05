package arthdalDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getCon() throws SQLException {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			con = DriverManager.getConnection(url, "SCOTT", "TIGER");
			return con;
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			return null;
		}
	}
}
