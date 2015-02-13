package bs.dataaccess;

import java.sql.*;

public class DBUtil {

	public static void closeStatement(Statement s) {
		try {
			if (s != null) {
				s.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void closePreparedStatement(Statement ps){
		try{
			if(ps != null){
				ps.close();
			}
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	public static void closeResultSet(ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	public static Connection connectToDb() {
		String url = "jdbc:mysql://localhost:3306/bookstore";
		String name = "newuser";
		String passwd = "01234";

		DBConnectionPool connPool = null;
		try {
			connPool = new DBConnectionPool(url, name, passwd);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = connPool.getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return conn;
	}

}
