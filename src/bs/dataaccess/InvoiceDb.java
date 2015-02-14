package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bs.models.Invoice;

public class InvoiceDb {
	public static Invoice createInvoice(Invoice invoice){
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Invoice (BookId, AuthorId, paymentType, "
				+ "transactionDate, totalAmount, isProcessed)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1,0);
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
		
		return invoice;
	}
}
