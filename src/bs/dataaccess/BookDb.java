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

		String query = "INSERT INTO Book (ISBN, Price, Summary, Title, Cost)"
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, book.getISBN());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getSummary());
			ps.setString(4, book.getTitle());
			ps.setDouble(5, book.getCost());
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
				+ "Summary = ?, " + "Title = ?, " + "Cost = ?" + "WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, book.getISBN());
			ps.setDouble(2, book.getPrice());
			ps.setString(3, book.getSummary());
			ps.setString(4, book.getTitle());
			ps.setDouble(5, book.getCost());
			ps.setInt(6, book.getId());
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
				book.setCost(rs.getDouble("Cost"));
				book.setTitle(rs.getString("Title"));
				book.setSummary(rs.getString("Summary"));
				book.setGenre(GenreDb.getGenre(rs.getInt("genreId")));
				book.setPublisher(PublisherDb.getPublisher(rs
						.getInt("publisherid")));
				book.setAuthorList(BookAuthorDb.getAuthorByBook(rs.getInt("Id")));
				book.setRatingList(RatingDb.getAllRatingByBook(book.getId()));
			}
			return book;
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
				book = getBook(rs.getInt("Id"));
				toReturn.add(book);
			}
			return toReturn;
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

	public static List<Book> getBookByISBN(String isbn) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> toReturn = null;

		String query = "SELECT * FROM Book" + " WHERE isbn = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(isbn));
			rs = ps.executeQuery();

			Book book = null;
			toReturn = new ArrayList<Book>();
			while (rs.next()) {
				book = new Book();
				book = getBook(rs.getInt("Id"));
				toReturn.add(book);
			}
			return toReturn;
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

	public static List<Book> getBookByTitle(String title) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> toReturn = null;

		String query = "SELECT * FROM Book" + " WHERE title Like ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + title + "%");
			rs = ps.executeQuery();

			Book book = null;
			toReturn = new ArrayList<Book>();
			while (rs.next()) {
				book = new Book();
				book = getBook(rs.getInt("Id"));
				toReturn.add(book);
			}
			return toReturn;
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

	public static List<Book> getBookByPub(String publisher) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> toReturn = null;

		String query = "SELECT * FROM Book "
				+ "join publisher on publisher.id = book.publisherid "
				+ " WHERE publisher.companyname Like ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + publisher + "%");
			rs = ps.executeQuery();

			Book book = null;
			toReturn = new ArrayList<Book>();
			while (rs.next()) {
				book = new Book();
				book = getBook(rs.getInt("Id"));
				toReturn.add(book);
			}
			return toReturn;
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

	public static List<Book> getBookByGenre(String key) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>();

		String query = "SELECT book.id FROM book "
				+ "join genre on book.genreid = genre.id "
				+ "Left JOIN lineItem ON book.id = lineitem.bookid "
				+ "where genre.genre = ? " + "group by book.id "
				+ "order by sum(lineitem.quantity) desc;";

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
			DBUtil.closeResultSet(rs);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Book> getAllBooks() {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>();

		String query = "SELECT * FROM book ";
		try {
			ps = conn.prepareStatement(query);
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
			DBUtil.closeResultSet(rs);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Book> getTop5ByGenre(String genre) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>();

		String query = "select book.id, book.title from book "
				+ "join genre on genre.id = book.genreid "
				+ "join lineitem on lineitem.bookid = book.id "
				+ "where genre.genre = ? " + "group by lineitem.bookid "
				+ "order by sum(lineitem.quantity) desc limit 5";

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + genre + "%");
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
			DBUtil.closeResultSet(rs);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Book> getTopTenBooks() {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>();

		String query = "select book.id, book.title, lineItem.Quantity FROM book "
				+ "join lineItem on book.id = lineItem.BookId "
				+ "join invoice on lineItem.InvoiceId = invoice.Id "
				+ "Where invoice.transactionDate between DATE_SUB(CURDATE(), INTERVAL 10 DAY) and CURDATE() "
				+ "Group By LineItem.bookid "
				+ "order by sum(quantity) desc limit 10;";

		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			Book book = null;
			while (rs.next()) {
				book = new Book();
				book = getBook(rs.getInt("Id"));
				bookList.add(book);

			}

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
		return bookList;
	}

	public static List<Book> getTrendingBooks() {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<Book>();

		String query = "select book.id, book.title FROM book "
				+ "join rating on book.id = rating.BookId "
				+ "where rating.ratingDate between DATE_SUB(CURDATE(), INTERVAL 14 DAY) and CURDATE() "
				+ "Group By book.id "
				+ "order by AVG(rating.rating) desc limit 10;";

		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			Book book = null;
			while (rs.next()) {
				book = new Book();
				book = getBook(rs.getInt("Id"));
				bookList.add(book);

			}

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
		return bookList;
	}

}
