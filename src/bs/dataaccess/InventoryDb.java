package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bs.models.Inventory;

public class InventoryDb {

	public static Inventory createInventory(Inventory inventory) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;
		String query = "INSERT INTO inventory (bookid, quantity )"
				+ " VALUES (?, ?)";
		
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, inventory.getBookid());
			ps.setInt(2, inventory.getQuantity());
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
		return inventory;
	}

	public static Inventory updateInventory(Inventory inventory) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE Inventory SET "
				+ "quantity = ? " + "WHERE bookid = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, inventory.getQuantity());
			ps.setInt(2, inventory.getBookid());
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
		return inventory;
	}

	public static Inventory getInventory(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Inventory" + " WHERE bookId = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Inventory inventory = null;
			if (rs.next()) {
				inventory = new Inventory();
				inventory.setBookid(rs.getInt("bookid"));
				inventory.setQuantity(rs.getInt("quantity"));


			}
			return inventory;
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

}
