import java.sql.*;

public class InvoiceDAO implements InvoiceDAOInterface {
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Invoice fetchedBill = new Invoice();
	Invoice invoice = new Invoice();
	
	//create
	public void createInvoice(Invoice invoice) {
		try {
			prep = connection.prepareStatement("insert into Invoice (InvoiceAddressId, paidStatus) values (?,?)");
			prep.setInt(1, invoice.getInvoiceAddressId());
			prep.setBoolean(2, false);
			prep.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Invoice has been created.");
	}
	
	//read
	public Invoice findInvoiceWithId(Invoice invoice) {
		try {
			prep = connection.prepareStatement("select * from Invoice where invoiceId = ?");
			prep.setInt(1, invoice.getInvoiceId());
			result = prep.executeQuery();
			result.last();
			fetchedBill.setInvoiceId(result.getInt("invoiceId"));
			fetchedBill.setInvoiceAddressId(result.getInt("invoiceAddressId"));
			fetchedBill.setPaid(result.getBoolean("paidStatus"));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return fetchedBill;
	}
	public Invoice findInvoiceWithCustomerId(Customer customer) {
		try {
			prep = connection.prepareStatement("select * from Orders,Invoice where customerId = ? and Orders.invoiceId = Invoice.invoiceId");
			prep.setInt(1, customer.getCustomerId());
			result = prep.executeQuery();
			result.last();
			fetchedBill.setInvoiceId(result.getInt("invoiceId"));
			fetchedBill.setInvoiceAddressId(result.getInt("invoiceAddressId"));
			fetchedBill.setPaid(result.getBoolean("paidStatus"));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return fetchedBill;
	}
	public Invoice findInvoiceUnpaid(Invoice invoice) {
		try {
			prep = connection.prepareStatement("select * from Invoice where paidStatus = ?");
			prep.setBoolean(1, false);
			result = prep.executeQuery();
			result.last();
			fetchedBill.setInvoiceId(result.getInt("invoiceId"));
			fetchedBill.setInvoiceAddressId(result.getInt("invoiceAddressId"));
			fetchedBill.setPaid(result.getBoolean("paidStatus"));
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return fetchedBill;
	}
	
	//update
	public void setInvoiceIdToOrder(Invoice invoice, Order order) {
		try {
			prep = connection.prepareStatement("Update Orders set invoiceId = ? where orderId = ?");
			prep.setInt(1, invoice.getInvoiceId());
			prep.setInt(2, order.getOrderId());
			prep.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Invoice Id has been set.");
	}

	public void setIsPaid(Invoice invoice) {
		try {
			prep = connection.prepareStatement("update Invoice set paidStatus = ? where invoiceId = ?");
			prep.setBoolean(1, invoice.isPaid());
			prep.setInt(2, invoice.getInvoiceId());
			prep.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Payment status has been changed.");
	}
	
	public void setInvoiceAddress(Invoice invoice, Address address) {//doesnt work yet when address already exists
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
				address.setAddressId(result.getInt("addressId"));
			}
			else {
				address.setAddressId(result.getInt("addressId"));
			}
			
			prep = connection.prepareStatement("update Invoice set invoiceAddressId = ? where invoiceId = ?");
			prep.setInt(1, address.getAddressId());
			prep.setInt(2, invoice.getInvoiceId());
			prep.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Address has been set as invoice address.");
	}
	
	//delete
	public void removeInvoiceWithId(Invoice invoice) {
		try {
			prep = connection.prepareStatement("delete from Invoice where invoiceId = ?");
			prep.setInt(1, invoice.getInvoiceId());
			prep.executeUpdate();
			prep = connection.prepareStatement("update Orders set invoiceId = null where invoiceId = ?");
			prep.setInt(1, invoice.getInvoiceId());
			prep.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Invoice has been removed.");
	}
	public void removeInvoiceWithCustomerId(Customer customer) {
		try {
			prep = connection.prepareStatement("select InvoiceId from Orders where customerId = ?");
			prep.setInt(1, customer.getCustomerId());
			result = prep.executeQuery();
			result.last();
			invoice.setInvoiceId(result.getInt("invoiceId"));			
			prep = connection.prepareStatement("update Orders set invoiceId = null where invoiceId = ?");
			prep.setInt(1, invoice.getInvoiceId());
			prep.executeUpdate();
			prep = connection.prepareStatement("delete from Invoice where invoiceId = ?");
			prep.setInt(1,invoice.getInvoiceId());
			prep.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Invoice and associated order have been removed.");
	}
	public void removeInvoiceWithOrderId(Order order) {
		try {
			prep = connection.prepareStatement("select InvoiceId from Orders where orderId = ?");
			prep.setInt(1, order.getOrderId());
			result = prep.executeQuery();
			result.last();
			invoice.setInvoiceId(result.getInt("invoiceId"));			
			prep = connection.prepareStatement("update Orders set invoiceId = null where invoiceId = ?");
			prep.setInt(1, invoice.getInvoiceId());
			prep.executeUpdate();
			prep = connection.prepareStatement("delete from Invoice where invoiceId = ?");
			prep.setInt(1,invoice.getInvoiceId());
			prep.executeUpdate();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
