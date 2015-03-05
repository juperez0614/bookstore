package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import bs.models.Invoice;
import bs.models.MonthlyProfit;
import bs.models.WeeklyProfit;

public class ProfitDb {
	public static WeeklyProfit createWeekProfit(WeeklyProfit profit) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO WeeklyProfit (Profit)"
				+ " VALUES (?)";
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

		String query = "INSERT INTO MonthlyProfit (Profit)"
				+ " VALUES (?)";
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
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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
	
	public static void processInvoice(int invoiceId){
		Invoice i = InvoiceDb.getInvoice(invoiceId);
		System.out.println("customer id: " +i.getCustomer().getId());
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		i.setProcessed(true);
		i.setTransactionDate(new java.sql.Date(currentDate.getTime()));
		i.setPaymentType("Credit Card");
		
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select sum(book.price * lineItem.quantity) as bTotal FROM LineItem " + 
				"join book on book.id = lineItem.BookId " +
				"join invoice on invoice.id = lineitem.InvoiceId " +
				"where invoice.id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, invoiceId);
			rs = ps.executeQuery();
			if(rs.next()){
				i.setTotalAmount(rs.getDouble("bTotal"));
			}	
			if(i.getTotalAmount() != '\0'){
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
