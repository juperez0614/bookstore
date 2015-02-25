package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bs.models.UserAuth;

public class UserAuthDb {
	public static UserAuth createUserAuth(UserAuth user) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO UserAuth (username, userpassword)"
				+ " VALUES (?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closePreparedStatement(ps);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public static UserAuth updateUserAuth(UserAuth user) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE UserAuth SET " 
				+ "userpassword = ? " + "WHERE username = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closePreparedStatement(ps);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public static UserAuth getUserAuth(String username) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM UserAuth" + " WHERE username = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			UserAuth user = null;
			if (rs.next()) {
				user = new UserAuth();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("userpassword"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closePreparedStatement(ps);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static int deleteUserAuth(UserAuth user) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM UserAuth" 
		+ " WHERE username = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtil.closePreparedStatement(ps);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
