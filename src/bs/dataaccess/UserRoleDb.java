package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bs.models.UserRole;

public class UserRoleDb {
	public static UserRole createUserRole(UserRole user) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO UserRole (role, username)"
				+ " VALUES (?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getRole());
			ps.setString(2, user.getUser().getUsername());
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

	public static UserRole updateUserRole(UserRole user) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE UserRole SET " + "role = ? "
				+ "WHERE username = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getRole());
			ps.setString(2, user.getUser().getUsername());
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

	public static UserRole getUserRole(String username) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM UserRole" + " WHERE username = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			UserRole user = null;
			if (rs.next()) {
				user = new UserRole();
				user.setRole(rs.getString("role"));
				user.setUser(UserAuthDb.getUserAuth(rs.getString("username")));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static int deleteUserRole(UserRole user) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM UserRole" + " WHERE username = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUser().getUsername());

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
