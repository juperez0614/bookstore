package bs.dataaccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bs.models.Publisher;

public class PublisherDb {
	
		public static Publisher createPublisher(Publisher publisher) {
			Connection conn = DBUtil.connectToDb();

			PreparedStatement ps = null;

			String query = "INSERT INTO Publisher (CompanyName, Address, "
					+ "Address2, City, State, Zipcode, Phone, PointOfContact)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, publisher.getCompanyName());
				ps.setString(2, publisher.getAddress());
				ps.setString(3, publisher.getAddress2());
				ps.setString(4, publisher.getCity());
				ps.setString(5, publisher.getState());
				ps.setInt(6, publisher.getZipCode());
				ps.setString(7, publisher.getPhone());
				ps.setString(8, publisher.getPointOfContact());
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
			return publisher;
		}

		public static Publisher updatePublisher(Publisher publisher) {
			Connection conn = DBUtil.connectToDb();
			PreparedStatement ps = null;

			String query = "UPDATE Publisher SET " + "CompanyName = ?, "
					 + "Address = ?, " + "Address2 = ?, "
					+ "City = ?, " + "State = ?, "
							+ "Zipcode = ?, " + "Phone = ?, "
									+ "PointOfContact = ? " + "WHERE Id = ?";
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, publisher.getCompanyName());
				ps.setString(2, publisher.getAddress());
				ps.setString(3, publisher.getAddress2());
				ps.setString(4, publisher.getCity());
				ps.setString(5, publisher.getState());
				ps.setInt(6, publisher.getZipCode());
				ps.setString(7, publisher.getPhone());
				ps.setString(8, publisher.getPointOfContact());
				ps.setInt(9, publisher.getId());
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
			return publisher;
		}

		
		public static List<Publisher> getAll(){
			Connection conn = DBUtil.connectToDb();
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Publisher> publisherList = new ArrayList<Publisher>();

			String query = "SELECT * FROM Publisher";
			try {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();

				Publisher publisher = null; 
				while (rs.next()) {
					publisher = new Publisher();
					publisher.setId(rs.getInt("Id"));
					publisher.setCompanyName(rs.getString("CompanyName"));
					publisher.setAddress(rs.getString("Address"));
					publisher.setAddress2(rs.getString("Address2"));
					publisher.setCity(rs.getString("City"));
					publisher.setState(rs.getString("State"));
					publisher.setZipCode(rs.getInt("Zipcode"));
					publisher.setPhone(rs.getString("Phone"));
					publisher.setPointOfContact(rs.getString("PointofContact"));
					publisherList.add(publisher);
				}
				return publisherList;
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
		public static Publisher getPublisher(int id) {
			Connection conn = DBUtil.connectToDb();
			PreparedStatement ps = null;
			ResultSet rs = null;

			String query = "SELECT * FROM Publisher" + " WHERE Id = ?";
			try {
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();

				Publisher publisher = null;
				if (rs.next()) {
					publisher = new Publisher();
					publisher.setId(rs.getInt("Id"));
					publisher.setCompanyName(rs.getString("CompanyName"));
					publisher.setAddress(rs.getString("Address"));
					publisher.setAddress2(rs.getString("Address2"));
					publisher.setCity(rs.getString("City"));
					publisher.setState(rs.getString("State"));
					publisher.setZipCode(rs.getInt("Zipcode"));
					publisher.setPhone(rs.getString("Phone"));
					publisher.setPointOfContact(rs.getString("PointofContact"));
				}
				return publisher;
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

		public static int deletePublisher(Publisher publisher) {
			Connection conn = DBUtil.connectToDb();
			PreparedStatement ps = null;

			String query = "DELETE FROM Publisher" + " WHERE Id = ?";
			try {
				ps = conn.prepareStatement(query);
				ps.setInt(1, publisher.getId());

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



