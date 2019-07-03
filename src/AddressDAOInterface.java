
public interface AddressDAOInterface {
	//create
	public abstract void createAddress(Address address, Customer customer);
	
	//read
	public abstract Address findAddressWithCustomerId(Customer customer);
	public abstract Address findAddressWithLastName(Customer customer);
	public abstract Address findAddresWithFullName(Customer customer);
	
	//update
	public abstract void changeFullAddress(Address address);
	
	//delete
	public abstract void removeAddressWithAddressId(Address address);
}
