package bs.dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Calendar;

import bs.models.Invoice;

public class ProfitDb {

	public static String getProfit(Date to, Date from) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		double profit = 0.0;

		String query = "select (Sum(Book.price * lineItem.quantity) - sum(Book.cost * lineItem.quantity)) AS Profit "
				+ "from lineItem inner join Book on book.Id = lineItem.BookId "
				+ "inner join Invoice on lineItem.InvoiceId = Invoice.Id "
				+ "where TransactionDate between ? and ? ";
		try {
			ps = conn.prepareStatement(query);
			ps.setDate(1, to);
			ps.setDate(2, from);
			rs = ps.executeQuery();
			if (rs.next()) {
				profit = rs.getDouble("Profit");
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
		return currency.format(profit);
	}

	public static String getSales(Date to, Date from) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		double profit = 0.0;

		String query = "select (Sum(Book.price * lineItem.quantity)) AS Profit "
				+ "from lineItem inner join Book on book.Id = lineItem.BookId "
				+ "inner join Invoice on lineItem.InvoiceId = Invoice.Id "
				+ "where TransactionDate between ? and ? ";
		try {
			ps = conn.prepareStatement(query);
			ps.setDate(1, to);
			ps.setDate(2, from);
			rs = ps.executeQuery();
			if (rs.next()) {
				profit = rs.getDouble("Profit");
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
		return currency.format(profit);
	}

	public static void processInvoice(int invoiceId) {
		Invoice i = InvoiceDb.getInvoice(invoiceId);
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		i.setProcessed(true);
		i.setTransactionDate(new java.sql.Date(currentDate.getTime()));
		i.setPaymentType("Credit Card");

		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select sum(book.price * lineItem.quantity) as bTotal FROM LineItem "
				+ "join book on book.id = lineItem.BookId "
				+ "join invoice on invoice.id = lineitem.InvoiceId "
				+ "where invoice.id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, invoiceId);
			rs = ps.executeQuery();
			if (rs.next()) {
				i.setTotalAmount(rs.getDouble("bTotal"));
			}
			if (i.getTotalAmount() != '\0') {
				InvoiceDb.updateInvoice(i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
