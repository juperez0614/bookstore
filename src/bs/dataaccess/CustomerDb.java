package bs.dataaccess;

import java.sql.*;
import bs.models.Customer;

public class CustomerDb {

	public static Customer createCustomer(Customer customer) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;

		String query = "INSERT INTO Customer (firstName, lastName, Address, "
				+ "Address2, City, State, Email)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getAddress2());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setString(7, customer.getEmail());
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
		return customer;
	}

	public static Customer updateCustomer(Customer customer) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE Book SET " + "firstName = ?, "
				+ "lastName = ?, " + "Address = ? " + "Address2 = ? "
				+ "City = ? " + "State = ? " + "Email = ? " + "WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getAddress2());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setString(7, customer.getEmail());
			ps.setInt(8, customer.getId());
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
		return customer;
	}

	public static Customer getCustomer(int id) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Customer" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Customer customer = null;
			if (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setAddress(rs.getString("Address"));
				customer.setAddress2(rs.getString("Address2"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setEmail(rs.getString("Email"));

			}
			return customer;
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

	public static int deleteCustomer(Customer customer) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "DELETE FROM Customer" + " WHERE Id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, customer.getId());

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
