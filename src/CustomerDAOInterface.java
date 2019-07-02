
public interface CustomerDAOInterface {
	//create
	public abstract void newCustomer();
	
	//read
	public abstract String findCustomerWithId();
	public abstract String findCustomerWithLastName();
	public abstract String findCustomerWithFullName();
	public abstract String findCustomerWithEmail();
	
	//update
	public abstract void setCustomerFullName(int id);
	public abstract void setCustomerAddress(int id);
	public abstract void setCustomerEmail(int id);
	
	//delete
	public abstract boolean deleteCustomer(int id);
	
}
