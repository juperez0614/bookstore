package bs.dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bs.models.Customer;

public class CustomerDb {

	public static Customer createCustomer(Customer customer) {
		Connection conn = DBUtil.connectToDb();

		PreparedStatement ps = null;
		ResultSet rs = null; 

		String query = "INSERT INTO customer (FirstName, LastName, Address, "
				+ "Address2, City, State, ZipCode, Username, Email)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getAddress2());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setInt(7, customer.getZipcode());
			ps.setString(8, customer.getUserName().getUsername());
			ps.setString(9, customer.getEmail());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				customer.setId(rs.getInt(1));
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
		return customer;
	}

	public static Customer updateCustomer(Customer customer) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;

		String query = "UPDATE Customer SET " + "firstName = ?, "
				+ "lastName = ?, " + "Address = ?, " + "Address2 = ?, "
				+ "City = ?, " + "State = ?, "
						+ "Zipcode = ?, " + "Email = ? " + "WHERE id = ?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getAddress2());
			ps.setString(5, customer.getCity());
			ps.setString(6, customer.getState());
			ps.setInt(7, customer.getZipcode());
			ps.setString(8, customer.getEmail());
			ps.setInt(9, customer.getId());
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
				customer.setZipcode(rs.getInt("Zipcode"));
				customer.setEmail(rs.getString("Email"));
				customer.setUserName(UserAuthDb.getUserAuth(rs.getString("Username")));

			}
			return customer;
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

	
	public static Customer getCustomerByUsername(String username) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT * FROM Customer" + " WHERE username = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
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
				customer.setZipcode(rs.getInt("Zipcode"));
				customer.setEmail(rs.getString("Email"));

			}
			return customer;
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
	
	public static int emailExists(String email){
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "Select * FROM Customer" + " WHERE email = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, email);

			rs = ps.executeQuery();
			
			if (rs.next()){
				return rs.getInt("Id");
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
		return 0;
	}
	
	
	public static List<Customer> getPartialCustomer(Customer fromCustomer) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> custList = null;
		String query = "SELECT * FROM Customer " 
				+ "WHERE FirstName Like ? OR "
				+ "LastName Like ? OR (Address Like ? AND "
				+ "Address2 Like ?) OR City Like ? OR "
				+ "State Like ? OR Zipcode Like ? OR "
				+ "Email Like ? OR Id Like ? OR Username Like ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "%"+ fromCustomer.getFirstName() + "%");
			ps.setString(2, fromCustomer.getLastName());
			ps.setString(3, fromCustomer.getAddress());
			ps.setString(4, fromCustomer.getAddress2());
			ps.setString(5, fromCustomer.getCity());
			ps.setString(6, fromCustomer.getState());
			ps.setInt(7, fromCustomer.getZipcode());
			ps.setString(8, fromCustomer.getEmail());
			ps.setInt(9, fromCustomer.getId());
			ps.setString(10, fromCustomer.getUserName().getUsername());
			rs = ps.executeQuery();

			Customer customer = null;
			custList = new ArrayList<Customer>();
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setAddress(rs.getString("Address"));
				customer.setAddress2(rs.getString("Address2"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setZipcode(rs.getInt("Zipcode"));
				customer.setEmail(rs.getString("Email"));
				custList.add(customer);

			}
			return custList;
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
	
	public static List<Customer> getCustomerByBooktoQuantityPurchase(int bookid, int quantity) {
		Connection conn = DBUtil.connectToDb();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> custList = null;
		String query = "SELECT Distinct Invoice.CustomerId, lineItem.bookid, " 
				+ "lineItem.quantity FROM invoice "
				+ "join lineitem on lineitem.InvoiceId = invoice.Id "
				+ "WHERE lineitem.bookid = ? AND lineitem.quantity >= ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, bookid);
			ps.setInt(2, quantity);
			rs = ps.executeQuery();
			
			Customer customer = null;
			custList = new ArrayList<Customer>();
			while (rs.next()) {
				customer = new Customer();
				customer= CustomerDb.getCustomer(rs.getInt("CustomerId"));
				custList.add(customer);

			}
			return custList;
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
