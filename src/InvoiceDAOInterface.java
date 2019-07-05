
public interface InvoiceDAOInterface {
	//create
	public abstract void createInvoice();
	
	//read
	public abstract Invoice findInvoiceWithId();
	public abstract Invoice findInvoiceWithCustomerId();
	public abstract Invoice findInvoiceUnpaid();
	
	//update
	public abstract void setCustomerId();
	public abstract void setOrderId();
	public abstract void setIsPaid();
	
	//delete
	public abstract void removeInvoiceById();
	public abstract void removeInvoiceByCustomerId();
	public abstract void removeInvoiceByOrderId();
}
