import java.sql.*;

public class CustomerDAO implements CustomerDAOInterface {
	String temp = "To stop the red crosses from appearing.";
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;	
	
	public static void main(String[] args) {
		CustomerDAO tryout = new CustomerDAO();
		tryout.newCustomer();
		System.out.println("Hopefully added the Kangoo now.");
	}
	
	//create
			public void newCustomer() {
				try{prep = connection.prepareStatement("insert into Customer (firstName, lastName, email, streetName," +
					   "houseNumber, postalCode, residence) values (?, ?, ?, ?, ?, ?, ?)");
				prep.setString(1, "Renault");
				prep.setString(2, "Kangoo");
				prep.setString(3, "jumpyjumpjump@hotmail.com");
				prep.setString(4, "vroomRoad");
				prep.setInt(5, 5);
				prep.setString(6, "9876SB");
				prep.setString(7, "DriveTown");
				prep.executeUpdate();
				//result = prep.executeQuery();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			
	//read
	public String findCustomerWithId() {
		return temp;
	}
		public String findCustomerWithLastName() {
			return temp;
		}
		public String findCustomerWithFullName() {
			return temp;
		}
		public String findCustomerWithEmail() {
			return temp;
		}
		
		//update
		public void setCustomerFullName(int id) {
			
		}
		public void setCustomerAddress(int id) {
			
		}
		public void setCustomerEmail(int id) {
			
		}
		
		//delete
		public boolean deleteCustomer(int id) {
			boolean succes = false;
			
			return succes;
		}
		
}
