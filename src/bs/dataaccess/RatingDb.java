package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bs.models.Rating;

public class RatingDb {
	public static Rating createRating(Rating rating) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Rating (Rating, Review, RatingDate, BookId, CustomerID)"
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, rating.getRating());
			ps.setString(2, rating.getReview());
			ps.setDate(3, rating.getRatingDate());
			ps.setInt(4, rating.getBookid());
			ps.setInt(5, rating.getCustomerid());
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
		return rating;
	}



	public static Rating getRating(int bookid) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT *, AVG(Rating) As Average FROM Rating" + " WHERE bookId = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, bookid);
			rs = ps.executeQuery();

			Rating rating = null;
			if (rs.next()) {
				rating = new Rating();
				rating.setId(rs.getInt("Id"));
				rating.setRating(rs.getInt("Rating"));
				rating.setReview(rs.getString("Review"));
				rating.setRatingDate(rs.getDate("RatingDate"));
				rating.setRatingAvg(rs.getDouble("Average"));
			}
			return rating;
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

	
	public static List<Rating> getAllRatingByBook(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Rating> ratingList =  new ArrayList<Rating>();

		String query = "SELECT * FROM Rating" + " WHERE bookId = ? order by RatingDate DESC";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Rating rating = null;
			while (rs.next()) {
				rating = new Rating();
				rating.setId(rs.getInt("Id"));
				rating.setRating(rs.getInt("Rating"));
				rating.setReview(rs.getString("Review"));
				rating.setRatingDate(rs.getDate("RatingDate"));
				ratingList.add(rating);
			}
			return ratingList;
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
	
	public static List<Rating> getRatingByCustomer(int customerId) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Rating> results = new ArrayList<Rating>();

		String query = "SELECT * FROM Rating" + " WHERE customerId = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, customerId);
			rs = ps.executeQuery();

			Rating rating = null;
			while (rs.next()) {
				rating = new Rating();
				rating.setId(rs.getInt("Id"));
				rating.setRating(rs.getInt("Rating"));
				rating.setReview(rs.getString("Review"));
				rating.setRatingDate(rs.getDate("RatingDate"));
				results.add(rating);
			}
			return results;
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

	public static List<Rating> getLast5RatingByBook(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Rating> ratingList =  new ArrayList<Rating>();

		String query = "SELECT * FROM Rating" + " WHERE bookId = ? order by RatingDate DESC limit 5";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Rating rating = null;
			while (rs.next()) {
				rating = new Rating();
				rating.setId(rs.getInt("Id"));
				rating.setRating(rs.getInt("Rating"));
				rating.setReview(rs.getString("Review"));
				rating.setRatingDate(rs.getDate("RatingDate"));
				ratingList.add(rating);
			}
			return ratingList;
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
	
	public static int deleteRating(Rating rating) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM Rating" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, rating.getId());

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
