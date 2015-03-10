package bs.dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bs.models.Author;

public class AuthorDb {

	public static Author createAuthor(Author author) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Author (firstName, lastName, biography)"
				+ " VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getLastName());
			ps.setString(3, author.getBiography());
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
		return author;
	}

	public static Author updateAuthor(Author author) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE Author SET " + "FirstName = ?, "
				+ "LastName = ?, " + "Biography = ? " + "WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getLastName());
			ps.setString(3, author.getBiography());
			ps.setInt(4, author.getId());
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
		return author;
	}

	public static List<Author> getAll() {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Author> authorList = new ArrayList<Author>();

		String query = "SELECT * FROM Author";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			Author author = null;
			while (rs.next()) {
				author = new Author();
				author.setId(rs.getInt("Id"));
				author.setFirstName(rs.getString("firstName"));
				author.setLastName(rs.getString("LastName"));
				author.setBiography(rs.getString("Biography"));
				authorList.add(author);
			}
			return authorList;
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

	public static Author getAuthor(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Author" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Author author = null;
			if (rs.next()) {
				author = new Author();
				author.setId(rs.getInt("Id"));
				author.setFirstName(rs.getString("firstName"));
				author.setLastName(rs.getString("LastName"));
				author.setBiography(rs.getString("Biography"));
			}
			return author;
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

	public static int deleteAuthor(Author author) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM Author" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, author.getId());

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
