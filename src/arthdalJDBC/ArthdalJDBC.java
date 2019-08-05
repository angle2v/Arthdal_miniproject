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
			// ?�� �����Ǵ� parameter value �ֱ�
			cstmt.setString(1, "Ÿ��");
			cstmt.setString(2, "�̱�Ʈ");
			cstmt.setString(3, "������");
			cstmt.setString(4, "�ƽ���");
			cstmt.setString(5, "�ƶ� �콽��");
			// procedure ȣ���ϱ�
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
