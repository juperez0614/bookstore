package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bs.models.Genre;

public class GenreDb {
	public static Genre createGenre(Genre genre) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Genre (Genre)"
				+ " VALUES (?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, genre.getGenre());
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
		return genre;
	}


	public static Genre getGenre(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Genre" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Genre genre = null;
			if (rs.next()) {
				genre = new Genre();
				genre.setId(rs.getInt("Id"));
				genre.setGenre(rs.getString("genre"));
			}
			return genre;
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
	
	public static List<Genre> getAll(){
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Genre> genreList = new ArrayList<Genre>();

		String query = "SELECT * FROM Genre";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			Genre genre = null; 
			while (rs.next()) {
				genre = new Genre();
				genre.setId(rs.getInt("Id"));
				genre.setGenre(rs.getString("genre"));
				genreList.add(genre);
			}
			return genreList;
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
	
	

	public static int deleteGenre(Genre genre) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM Genre" 
		+ " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, genre.getId());

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
