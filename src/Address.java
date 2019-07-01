
public class Address {
	private int addressId;
	private String streetname;
	private int houseNumber;
	private String addition;
	private String postalCode;
	private String placeOfResidence;
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressId(int id) {
		this.addressId = id;
	}
	
	public String getStreetname() {
		return streetname;
	}
	
	public void setStreetname(String street) {
		this.streetname = street;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(int number) {
		this.houseNumber = number;
	}
	
	public String getAddition() {
		return addition;
	}
	
	public void setAddition(String suffix) {
		this.addition = suffix;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String code) {
		this.postalCode = code;
	}
	
	public String getPlaceOfResidence() {
		return placeOfResidence;
	}
	
	public void setPlaceOfResidence(String home) {
		this.placeOfResidence = home;
	}
}
