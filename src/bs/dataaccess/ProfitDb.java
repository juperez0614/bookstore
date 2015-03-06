package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Calendar;

import bs.models.Invoice;
import bs.models.MonthlyProfit;
import bs.models.WeeklyProfit;

public class ProfitDb {
	public static WeeklyProfit createWeekProfit(WeeklyProfit profit) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO WeeklyProfit (Profit)" + " VALUES (?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setDouble(1, profit.getProfit());
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
		return profit;
	}

	public static MonthlyProfit createMonthProfit(MonthlyProfit profit) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO MonthlyProfit (Profit)" + " VALUES (?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setDouble(1, profit.getProfit());
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
		return profit;
	}

	public static WeeklyProfit getWeeklyProfit(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM WeeklyProfit" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			WeeklyProfit profit = null;
			if (rs.next()) {
				profit = new WeeklyProfit();
				profit.setWeekId(rs.getInt("Id"));
				profit.setProfit(rs.getDouble("Profit"));
			}
			return profit;
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
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return currency.format(profit);
	}

	public static MonthlyProfit getMonthlyProfit(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM MonthlyProfit" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			MonthlyProfit profit = null;
			if (rs.next()) {
				profit = new MonthlyProfit();
				profit.setMonthId(rs.getInt("Id"));
				profit.setProfit(rs.getDouble("Profit"));
			}
			return profit;
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

	public static void processInvoice(int invoiceId) {
		Invoice i = InvoiceDb.getInvoice(invoiceId);
		System.out.println("customer id: " + i.getCustomer().getId());
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
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
