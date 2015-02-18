package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bs.models.Invoice;

public class InvoiceDb {
	public static Invoice createInvoice(Invoice invoice) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Invoice  (CustomerId, paymentType, "
				+ "transactionDate, totalAmount, isProcessed)"
				+ " VALUES (?, ?, ?, ?, ?)";

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, invoice.getCustomer().getId());
			ps.setString(2, invoice.getPaymentType());
			ps.setDate(3, invoice.getTransactionDate());
			ps.setDouble(4, invoice.getTotalAmount());
			ps.setBoolean(5, invoice.isProcessed());
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

	public static Invoice updateInvoice(Invoice invoice) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE Invoice SET " + "Customer = ?, "
				+ "PaymentType = ?, " + "TransactionDate = ?, "
				+ "TotalAmount = ?, " + "isProcessed = ? " + "WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, invoice.getCustomer().getId());
			ps.setString(2, invoice.getPaymentType());
			ps.setDate(3, invoice.getTransactionDate());
			ps.setDouble(4, invoice.getTotalAmount());
			ps.setBoolean(5, invoice.isProcessed());
			ps.setInt(6, invoice.getId());
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

	public static List<Invoice> selectUnprocessedInvoices() {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "Select * From Invoice " + "WHERE isProcessed = "
				+ false;
		List<Invoice> invList = new ArrayList<Invoice>();

		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Invoice i = InvoiceDb.getInvoice(rs.getInt("Id"));
				invList.add(i);
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
		return invList;
	}

	public static Invoice getInvoice(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Invoice" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Invoice invoice = null;
			if (rs.next()) {
				invoice = new Invoice();
				invoice.setId(rs.getInt("Id"));
				invoice.setCustomer(CustomerDb.getCustomer(rs
						.getInt("CustomerId")));
				invoice.setPaymentType(rs.getString("PaymentType"));
				invoice.setTransactionDate(rs.getDate("TransactionDate"));
				invoice.setTotalAmount(rs.getDouble("TotalAmount"));
				invoice.setProcessed(rs.getBoolean("isProcessed"));
				invoice.setLineItems(LineItemDb.selectLineItems(rs.getInt("Id")));
			}
			return invoice;
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
