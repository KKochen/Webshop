
public interface CustomerDAOInterface {
	//create
	public abstract void createCustomer(Customer newCustomer);
	
	//read
	public abstract Customer findCustomerWithId(int id);
	public abstract Customer findCustomerWithLastName(Customer customer);
	public abstract Customer findCustomerWithFullName(Customer customer);
	public abstract Customer findCustomerWithEmail(Customer customer);
	
	//update
	public abstract void setCustomerFullName(Customer customer);
	public abstract void setCustomerEmail(Customer customer);
	
	//delete
	public abstract void deleteCustomerWithId(Customer customer);
	public abstract void deleteCustomerWithFullName(Customer customer);
	
}
