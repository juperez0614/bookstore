package bs.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
