
public interface AddressDAOInterface {
	//create
	public abstract void createAddress(Address address, Customer customer);
	
	//read
	public abstract Address findAddressWithCustomerId(Customer customer);
	public abstract Address findAddressWithLastName(Customer customer);
	public abstract Address findAddresWithFullName(Customer customer);
	
	//update
	public abstract void changeFullAddress(Address address, Customer customer);
	
	//delete
	public abstract void removeAddressWithBothIds(Address address, Customer customer);
	public abstract void removeAddressWithAddressId(Address address);
}
