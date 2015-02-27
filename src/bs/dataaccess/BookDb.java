package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bs.models.Book;

public class BookDb {

	public static Book createBook(Book book) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Book (ISBN, Price, Summary, Title)"
				+ " VALUES (?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, book.getISBN());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getSummary());
			ps.setString(4, book.getTitle());
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
				+ "Summary = ?, " +"Title = ?" + "WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, book.getISBN());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getSummary());
			ps.setString(4, book.getTitle());
			ps.setInt(5, book.getId());
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
				book.setTitle(rs.getString("Title"));
				book.setSummary(rs.getString("Summary"));
				book.setGenre(GenreDb.getGenre(rs.getInt("genreId")));
				book.setPublisher(PublisherDb.getPublisher(rs.getInt("publisherid")));
				book.setAuthorList(BookAuthorDb.getAuthorByBook(rs.getInt("Id")));
				book.setRatingList(RatingDb.getAllRatingByBook(book.getId()));
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
	
	
	public static List<Book> getAllBookByPrice(double price) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> toReturn = null;

		String query = "SELECT * FROM Book" + " WHERE Price <= ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setDouble(1, price);
			rs = ps.executeQuery();

			Book book = null;
			toReturn = new ArrayList<Book>();
			while (rs.next()) {
				book = new Book();
				book= getBook(rs.getInt("Id"));
				toReturn.add(book);
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
	
	public static List<Book> getBookByGenre(String key) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>(); 

		String query = "SELECT * FROM book "
				+ "inner join genre on book.genreid = genre.id" + ""
						+ " WHERE genre.genre = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, key);
			rs = ps.executeQuery();

			Book book = null;
			while (rs.next()) {
				book = new Book();
				book = getBook(rs.getInt("Id"));
				bookList.add(book);
				
			}
			return bookList; 
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
