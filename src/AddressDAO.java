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
			prep = connection.prepareStatement("select addressId from Address where streetname = ? and houseNumber = ? and " +
					"postalCode = ? and residence = ?");
			prep.setString(1, address.getStreetname());
			prep.setInt(2, address.getHouseNumber());
			prep.setString(3, address.getPostalCode());
			prep.setString(4, address.getPlaceOfResidence());
			result = prep.executeQuery();
			if(!result.next()) {
				prep = connection.prepareStatement("insert into Address (streetName, houseNumber, addition, postalCode," + 
					"residence) values (?, ?, ?, ?, ?)");
				prep.setString(1, address.getStreetname());
				prep.setInt(2, address.getHouseNumber());
				prep.setString(3, address.getAddition());
				prep.setString(4, address.getPostalCode());
				prep.setString(5, address.getPlaceOfResidence());
				prep.executeUpdate();
			}
			else {
				prep = connection.prepareStatement("insert into CustomerAddress (customerId, addressId) values (?,?)");
				prep.setInt(1, customer.getCustomerId());
				prep.setInt(2, result.getInt("addressId"));
				prep.executeUpdate();
				System.out.println("Address has been added.");
			}
		}
		
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//read SELECT name, price, photo FROM drinks, drinks_photos WHERE drinks.id = drinks_id
	public Address findAddressWithCustomerId(Customer customer) {
		try {
		prep = connection.prepareStatement("select * from Address,CustomerAddress where customerId = ? and Address.addressId = CustomerAddress.addressId");
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
		return found;
	}
	public Address findAddressWithLastName(Customer customer) {
		try {
			prep = connection.prepareStatement("select customerId from Customer where lastName = ?");
			prep.setString(1,customer.getLastName());
			result = prep.executeQuery();
			result.last();
			customer.setCustomerId(result.getInt("customerId"));
			prep = connection.prepareStatement("select * from Address,CustomerAddress where customerId = ? and Address.addressId = CustomerAddress.addressId");
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
			return found;
	}
	public Address findAddresWithFullName(Customer customer) {
		try {
			prep = connection.prepareStatement("select customerId from Customer where firstName = ? and lastName = ?");
			prep.setString(1, customer.getFirstName());
			//prep.setString(2, customer.getMiddleName());
			prep.setString(2, customer.getLastName());
			result = prep.executeQuery();
			result.last();
			customer.setCustomerId(result.getInt("customerId"));
			prep = connection.prepareStatement("select * from Address,CustomerAddress where customerId = ? and Address.addressId = CustomerAddress.addressId");
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
	
	//update
	public void changeFullAddress(Address address, Customer customer) {
		Address old = new Address();
		Address newOne = new Address();
		try {
			prep = connection.prepareStatement("select addressId from Address where streetname = ? and houseNumber = ? and " +
					"postalCode = ? and residence = ?");
			prep.setString(1, address.getStreetname());
			prep.setInt(2, address.getHouseNumber());
			prep.setString(3, address.getPostalCode());
			prep.setString(4, address.getPlaceOfResidence());
			result = prep.executeQuery();
			if(!result.next()) {
				prep = connection.prepareStatement("insert into Address (streetName, houseNumber, addition, postalCode," + 
				"residence) values (?, ?, ?, ?, ?)");
				prep.setString(1, address.getStreetname());
				prep.setInt(2, address.getHouseNumber());
				prep.setString(3, address.getAddition());
				prep.setString(4, address.getPostalCode());
				prep.setString(5, address.getPlaceOfResidence());
				prep.executeUpdate();
				prep = connection.prepareStatement("select addressId from Address where streetName = ? and houseNumber = ?" +
				" and addition = ? and postalCode = ? and residence = ?");
				prep.setString(1, address.getStreetname());
				prep.setInt(2, address.getHouseNumber());
				prep.setString(3, address.getAddition());
				prep.setString(4, address.getPostalCode());
				prep.setString(5, address.getPlaceOfResidence());
				result = prep.executeQuery();
				result.last();
				newOne.setAddressId(result.getInt("addressId"));
				prep = connection.prepareStatement("select * from CustomerAddress where customerId = ?");
				prep.setInt(1, customer.getCustomerId());
				result = prep.executeQuery();
				if(!result.next()) {
					prep = connection.prepareStatement("insert into CustomerAddress (customerId,addressId) values (?,?)");
					prep.setInt(1, customer.getCustomerId());
					prep.setInt(2, newOne.getAddressId());
					prep.executeUpdate();
				}
				else {
					prep = connection.prepareStatement("update CustomerAddress set addressId = ? where CustomerId = ?");
					prep.setInt(1, newOne.getAddressId());
					prep.setInt(2, customer.getCustomerId());
					prep.executeUpdate();
				}
			}
			else {
				old.setAddressId(result.getInt("addressId"));
				prep = connection.prepareStatement("select * from CustomerAddress where customerId = ?");
				prep.setInt(1, customer.getCustomerId());
				result = prep.executeQuery();
				if(!result.next()) {
					prep = connection.prepareStatement("insert into CustomerAddress (customerId,addressId) values (?,?)");
					prep.setInt(1, customer.getCustomerId());
					prep.setInt(2, old.getAddressId());
					prep.executeUpdate();
				}
				else {
					prep = connection.prepareStatement("update CustomerAddress set addressId = ? where CustomerId = ?");
					prep.setInt(1, old.getAddressId());
					prep.setInt(2, customer.getCustomerId());
					prep.executeUpdate();
				}
			}
			
			System.out.println("Address has been changed.");
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	//delete
	public void removeAddressWithBothIds(Address address, Customer customer) {
		try {
			prep = connection.prepareStatement("select addressId from Address where streetName = ? and houseNumber = ?" +
				" and addition = ? and postalCode = ? and residence = ?");
				prep.setString(1, address.getStreetname());
				prep.setInt(2, address.getHouseNumber());
				prep.setString(3, address.getAddition());
				prep.setString(4, address.getPostalCode());
				prep.setString(5, address.getPlaceOfResidence());
				result = prep.executeQuery();
				result.last();
				found.setAddressId(result.getInt("addressId"));
				
				prep = connection.prepareStatement("delete from CustomerAddress where addressId = ? and customerId = ?");
				prep.setInt(1, found.getAddressId());
				prep.setInt(2, customer.getCustomerId());
				prep.executeUpdate();
				System.out.println("Address has been removed.");
				
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void removeAddressWithAddressId(Address address) {
		try {
			prep = connection.prepareStatement("delete from Address where addressId = ?");
			prep.setInt(1, address.getAddressId());
			prep.executeUpdate();
			System.out.println("Address has been removed.");
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
