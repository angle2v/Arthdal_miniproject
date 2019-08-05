package arthdalJDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import arthdalDB.DBConnection;

class MyJDBC {
	public MyJDBC() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		CallableStatement cstmt = null;
		

		try {
			con = DBConnection.getCon();
			System.out.println("DB Connection Successful!");
			// String sql = "{call procedure(parameter,?,?,?,?,?)}";
			String sql = "{call arthdalproc(?,?,?,?,?)}";
			cstmt = con.prepareCall(sql);
			// ?에 대응되는 parameter value 넣기
			cstmt.setString(1, "타곤");
			cstmt.setString(2, "이그트");
			cstmt.setString(3, "새녘족");
			cstmt.setString(4, "아스달");
			cstmt.setString(5, "아라문 헤슬라");
			// procedure 호출하기
			cstmt.execute();
			System.out.println("Procedure Call Successful !");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			
				
			}
		}
	}
}


public class ArthdalJDBC {
	public static void main(String[] args) {

	}
}
