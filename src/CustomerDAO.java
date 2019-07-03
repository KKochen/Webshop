import java.sql.*;

public class CustomerDAO implements CustomerDAOInterface {
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Customer found = new Customer();
	
	//create
			public void createCustomer(Customer newCustomer) {
				try{	prep = connection.prepareStatement("insert into Customer (firstName, lastName, email) values" +
						"(?, ?, ?)");
				prep.setString(1, newCustomer.getFirstName());
				prep.setString(2, newCustomer.getLastName());
				prep.setString(3, newCustomer.getEmailAddress());
				prep.executeUpdate();
				System.out.println("Customer has been added.");
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			
	//read
	public Customer findCustomerWithId(int id) {
		try {
			prep = connection.prepareStatement("select * from Customer where CustomerId = ?");
			prep.setInt(1, id);
			result = prep.executeQuery();
			result.last();
			System.out.println(result.getString("firstName") + " " + result.getString("lastName"));
			found.setFirstName(result.getString("firstName"));
			found.setLastName(result.getString("lastName"));
			found.setCustomerId(result.getInt("customerId"));
			found.setEmailAddress(result.getString("email"));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return found;
	}
		public Customer findCustomerWithLastName(String lastName) {
			try {
				prep = connection.prepareStatement("select * from Customer where lastName = ?");
				prep.setString(1, lastName);
				result = prep.executeQuery();
				result.last();
				System.out.println(result.getString("firstName") + " " + result.getString("lastName"));
				found.setFirstName(result.getString("firstName"));
				found.setLastName(result.getString("lastName"));
				found.setCustomerId(result.getInt("customerId"));
				found.setEmailAddress(result.getString("email"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return found;
		}
		public Customer findCustomerWithFullName(String firstName, String lastName) {
			try {
				prep = connection.prepareStatement("select * from Customer where firstName = ? and lastName = ?");
				prep.setString(1, firstName);
				prep.setString(2, lastName);
				result = prep.executeQuery();
				result.last();
				System.out.println(result.getString("firstName") + " " + result.getString("lastName"));
				found.setFirstName(result.getString("firstName"));
				found.setLastName(result.getString("lastName"));
				found.setCustomerId(result.getInt("customerId"));
				found.setEmailAddress(result.getString("email"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return found;
		}
		public Customer findCustomerWithEmail(String email) {
			try {
				prep = connection.prepareStatement("select * from Customer where email = ?");
				prep.setString(1, email);
				result = prep.executeQuery();
				result.last();
				System.out.println(result.getString("firstName") + " " + result.getString("lastName"));
				found.setFirstName(result.getString("firstName"));
				found.setLastName(result.getString("lastName"));
				found.setCustomerId(result.getInt("customerId"));
				found.setEmailAddress(result.getString("email"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return found;
		}
		
		//update
		public void setCustomerFullName(Customer customer) {
			try {
				prep = connection.prepareStatement("update Customer set firstName = ?, middleName = ?, lastName = ? where Customerid = ?");
				prep.setString(1, customer.getFirstName());
				prep.setString(2, customer.getMiddleName());
				prep.setString(3, customer.getLastName());
				prep.setInt(4, customer.getCustomerId());
				prep.executeUpdate();
				System.out.println("Name has been updated.");
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		public void setCustomerEmail(Customer customer) {
			try {
				prep = connection.prepareStatement("update Customer set email = ? where Customerid = ?");
				prep.setString(1, customer.getEmailAddress());
				prep.setInt(2, customer.getCustomerId());
				prep.executeUpdate();
				System.out.println("Email has been updated.");
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		//delete
		public void deleteCustomerWithId(Customer customer) {
			try {
				prep = connection.prepareStatement("delete from Customer where Customerid = ?");
				prep.setInt(1, customer.getCustomerId());
				prep.executeUpdate();
				System.out.println("Customer has been removed from the database.");
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		public void deleteCustomerWithFullName(Customer customer) {
			try {
				prep = connection.prepareStatement("delete from Customer where firstName = ? and lastName = ?");
				prep.setString(1, customer.getFirstName());
				prep.setString(2, customer.getLastName());
				prep.executeUpdate();
				System.out.println("Customer has been removed from the database.");
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
}
