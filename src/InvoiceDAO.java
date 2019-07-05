import java.sql.*;

public class InvoiceDAO implements InvoiceDAOInterface {
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Invoice fetchedBill = new Invoice();
	
	//create
	public void createInvoice() {
		try {
			prep = connection.prepareStatement("insert into Invoice (");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//read
	public Invoice findInvoiceWithId() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return fetchedBill;
	}
	public Invoice findInvoiceWithCustomerId() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return fetchedBill;
	}
	public Invoice findInvoiceUnpaid() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return fetchedBill;
	}
	
	//update
	public void setCustomerId() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void setOrderId() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void setIsPaid() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//delete
	public void removeInvoiceById() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void removeInvoiceByCustomerId() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public void removeInvoiceByOrderId() {
		try {
			prep = connection.prepareStatement("");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
