
public interface InvoiceDAOInterface {
	//create
	public abstract void createInvoice(Invoice invoice);
	
	//read
	public abstract Invoice findInvoiceWithId(Invoice invoice);
	public abstract Invoice findInvoiceWithCustomerId(Customer customer);
	public abstract Invoice findInvoiceUnpaid(Invoice invoice);
	
	//update
	public abstract void setInvoiceIdToOrder(Invoice invoice, Order order);
	public abstract void setIsPaid(Invoice invoice);
	public abstract void setInvoiceAddress(Invoice invoice, Address address);
	
	//delete
	public abstract void removeInvoiceWithId(Invoice invoice);
	public abstract void removeInvoiceWithCustomerId(Customer customer);
	public abstract void removeInvoiceWithOrderId(Order order);
}
