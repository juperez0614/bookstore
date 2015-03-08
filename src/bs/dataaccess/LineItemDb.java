package bs.dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bs.models.*;

public class LineItemDb {
	public static LineItem createLineItem(LineItem lineItem, Invoice invoice){
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null; 
		ResultSet rs = null;
		String query = "INSERT INTO lineitem (BookId, Quantity, InvoiceId)"
				+ " VALUES (?, ?, ?)";
		
		try{
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, lineItem.getBook().getId());
			ps.setInt(2, lineItem.getQuantity());
			ps.setInt(3, invoice.getId());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				lineItem.setId(rs.getInt(1));
			}
		}catch(SQLException e){
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
		
		return lineItem; 
	}
	
	public static List<LineItem> selectLineItems(int invoiceId){
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null; 
		List<LineItem> ls = new ArrayList<LineItem>();
		String query = "Select * FROM LineItem "
				+ "Where InvoiceId =" + invoiceId;
		
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int bookid = rs.getInt("BookId");
				int quantity = rs.getInt("Quantity");
				Book b = BookDb.getBook(bookid);
				int id = rs.getInt("id");
				ls.add(new LineItem(b, quantity, id));
			}
		}catch(SQLException e){
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
		return ls; 
	}
	
	
	public static LineItem updateLineItems(LineItem toChange){
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		String query = "UPDATE LineItem SET " + "BookId = ?, " 
				+ "quantity = ?, " + "InvoiceId = ? "
						+ "WHERE id = ?";
		
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, toChange.getBook().getId());
			ps.setInt(2, toChange.getQuantity());
			ps.setInt(3, toChange.getInvoice().getId());
			ps.setInt(4, toChange.getId());
			ps.executeUpdate();
		}catch(SQLException e){
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
		return toChange; 
	}
	
	public static LineItem getLineItem(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM LineItem" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			LineItem item = null;
			if (rs.next()) {
				item = new LineItem();
				item.setId(rs.getInt("Id"));
				item.setBook(BookDb.getBook(rs.getInt("BookId")));
				item.setInvoice(InvoiceDb.getInvoice(rs.getInt("InvoiceId")));
				item.setQuantity(rs.getInt("quantity"));

			}
			return item;
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
	
	public static int deleteLineItem(LineItem toDelete) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM LineItem" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, toDelete.getId());

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
