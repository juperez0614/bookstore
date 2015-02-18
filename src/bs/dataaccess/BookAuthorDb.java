package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bs.models.Author;
import bs.models.Book;

public class BookAuthorDb 
{
	public static void insertIntoBA(int bookId, int authorId){
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO BookAuthor (BookId, AuthorId)"
				+ " VALUES (?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, bookId);
			ps.setInt(2, authorId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<Book> getBookByAuthor(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> toReturn = null;
		String query = "SELECT * FROM BookAuthor" + " WHERE AuthorId = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Book b = null;
			toReturn = new ArrayList<Book>();
			while (rs.next()) {
				b = new Book();
				b = BookDb.getBook(rs.getInt("BookId"));
				toReturn.add(b);
			}
			return toReturn;
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
	
	
	public static List<Author> getAuthorByBook(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Author> toReturn = null;
		String query = "SELECT * FROM BookAuthor" + " WHERE BookId = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Author a = null;
			toReturn = new ArrayList<Author>();
			while (rs.next()) {
				a = new Author();
				a = AuthorDb.getAuthor(rs.getInt("AuthorId"));
				toReturn.add(a);
			}
			return toReturn;
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

}
