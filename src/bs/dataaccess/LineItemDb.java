package bs.dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bs.models.*;

public class LineItemDb {

	public static LineItem createLineItem(LineItem lineItem, Invoice invoice){
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null; 
		String query = "INSERT INTO LineItem (InvoiceId, BookId, Quantity "
				+ ")"
				+ " VALUES (?, ?, ?)";
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, invoice.getId());
			ps.setInt(2, lineItem.getBook().getId());
			ps.setInt(3, lineItem.getQuantity());
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
				
				ls.add(new LineItem(b, quantity));
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
}
