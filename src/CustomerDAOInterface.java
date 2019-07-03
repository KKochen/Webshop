
public interface CustomerDAOInterface {
	//create
	public abstract void createCustomer(Customer newCustomer);
	
	//read
	public abstract Customer findCustomerWithId(int id);
	public abstract Customer findCustomerWithLastName(String lastName);
	public abstract Customer findCustomerWithFullName(String fullName, String lastName);
	public abstract Customer findCustomerWithEmail(String email);
	
	//update
	public abstract void setCustomerFullName(Customer customer);
	public abstract void setCustomerEmail(Customer customer);
	
	//delete
	public abstract void deleteCustomerWithId(Customer customer);
	public abstract void deleteCustomerWithFullName(Customer customer);
	
}
