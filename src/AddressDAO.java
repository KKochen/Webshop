import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class AddressDAO implements AddressDAOInterface {
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Address found = new Address();
	
	//create
	public void createAddress(Address address, Customer customer) {
		try {
			prep = connection.prepareStatement("insert into Address (customerId,streetName, houseNumber, addition, postalCode," + 
			"residence) values (?, ?, ?, ?, ?, ?)");
			prep.setInt(1, customer.getCustomerId());
			prep.setString(2, address.getStreetname());
			prep.setInt(3, address.getHouseNumber());
			prep.setString(4, address.getAddition());
			prep.setString(5, address.getPostalCode());
			prep.setString(6, address.getPlaceOfResidence());
			prep.executeUpdate();
			System.out.println("Address has been added.");
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//read
	public Address findAddressWithCustomerId(Customer customer) {
		try {
		prep = connection.prepareStatement("select * from Address where customerId = ?");
		prep.setInt(1, customer.getCustomerId());
		result = prep.executeQuery();
		result.last();
		found.setStreetname(result.getString("streetName"));
		found.setAddressId(result.getInt("AddressId"));
		found.setHouseNumber(result.getInt("houseNumber"));
		found.setAddition(result.getString("addition"));
		found.setPostalCode(result.getString("postalCode"));
		found.setPlaceOfResidence(result.getString("residence"));
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println(found.getStreetname() + " " + found.getPlaceOfResidence());
		
		return found;
	}
	public Address findAddressWithLastName(Customer customer) {
		try {
			prep = connection.prepareStatement("select * from Address inner join Customer on Customer.customerId where lastName = ?");
			prep.setString(1, customer.getLastName());
			result = prep.executeQuery();
			result.last();
			found.setStreetname(result.getString("streetName"));
			found.setAddressId(result.getInt("AddressId"));
			found.setHouseNumber(result.getInt("houseNumber"));
			found.setAddition(result.getString("addition"));
			found.setPostalCode(result.getString("postalCode"));
			found.setPlaceOfResidence(result.getString("residence"));
			}
			
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println(found.getStreetname() + " " + found.getPlaceOfResidence());
			return found;
	}
	public Address findAddresWithFullName(Customer customer) {
		try {
			prep = connection.prepareStatement("select * from Address inner join Customer on Customer.customerId where firstName = ? and lastName = ?");
			prep.setString(1, customer.getFirstName());
			prep.setString(2, customer.getLastName());
			result = prep.executeQuery();
			result.last();
			found.setStreetname(result.getString("streetName"));
			found.setAddressId(result.getInt("AddressId"));
			found.setHouseNumber(result.getInt("houseNumber"));
			found.setAddition(result.getString("addition"));
			found.setPostalCode(result.getString("postalCode"));
			found.setPlaceOfResidence(result.getString("residence"));
			}
			
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println(found.getStreetname() + " " + found.getPlaceOfResidence());
			return found;
	}
	
	//update
	public void changeFullAddress(Address address) {
		try {
		prep = connection.prepareStatement("update Address set streetName = ?, houseNumber = ?, addition = ?," +
		"postalCode = ?, residence = ? where addressId = ?");
		prep.setString(1, address.getStreetname());
		prep.setInt(2, address.getHouseNumber());
		prep.setString(3, address.getAddition());
		prep.setString(4, address.getPostalCode());
		prep.setString(5, address.getPlaceOfResidence());
		prep.setInt(6, address.getAddressId());
		prep.executeUpdate();
		System.out.println("Address has been changed.");
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	//delete
	public void removeAddressWithAddressId(Address address) {
		try {
			prep = connection.prepareStatement("delete from Address where addressId = ?");
			prep.setInt(1, address.getAddressId());
			prep.executeUpdate();
			System.out.println("Address have been removed.");
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
