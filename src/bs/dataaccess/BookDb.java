package bs.dataaccess;

import java.sql.*;
import bs.models.Book;

public class BookDb {

	public static Book createBook(Book book) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Book (ISBN, Price, Summary)"
				+ " VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, book.getISBN());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getSummary());
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
		return book;
	}

	public static Book updateBook(Book book) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE Book SET " + "ISBN = ?, " + "Price = ?, "
				+ "Summary = ? " + "WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, book.getISBN());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getSummary());
			ps.setInt(4, book.getId());
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
		return book;
	}

	public static Book getBook(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Book" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Book book = null;
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("Id"));
				book.setISBN(rs.getInt("ISBN"));
				book.setPrice(rs.getDouble("Price"));
				;
				book.setSummary(rs.getString("Summary"));
			}
			return book;
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

	public static int deleteBook(Book book) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM Book" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, book.getId());

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
