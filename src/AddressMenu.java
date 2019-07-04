import java.util.Scanner;

public class AddressMenu {
	Scanner input = new Scanner(System.in);
	boolean keepWorking = true;
	AddressDAO dao = new AddressDAO();
	Address retrieved = new Address();
	Address query = new Address();
	Customer customer = new Customer();
	
	public void loadMenu() {
		AddressMenu menu = new AddressMenu(); 
		do {
			System.out.println("	#### ADDRESS MENU ####\n	(1) Add an address\n	(2) Find an address with the" +
			" customers id\n" +	"	(3) Find an address with the customers last name \n	(4) Find an address with the" +
			" full name \n	(5) Change an address \n	(6) Delete a customers address\n	(7) Delete an address\n	(0) Return to Main menu\n\n");
			System.out.print("Please enter the number of your choice: ");
			int choice = input.nextInt();
		
			switch(choice) {
			case 1: menu.addNewAddress(); break;
			case 2: menu.findAddressByCustomerId(); break;
			case 3: menu.findAddressByLastName(); break;
			case 4: menu.findAddressByFullName();break;
			case 5: menu.changeAddress();break;
			case 6: menu.deleteAddressByCustomerId();break;
			case 7: menu.deleteAddress();break;
			case 0: System.out.println("Leaving Customer Menu and returning to the Main Menu"); keepWorking = false;
			}
		} while(keepWorking);
	}
	
	public void addNewAddress() {
		System.out.print("Please enter the customers Id number: ");
		customer.setCustomerId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the streetname: ");
		query.setStreetname(input.nextLine());
		System.out.print("Please enter the house number: ");
		query.setHouseNumber(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the addition. If there is none, enter a space: ");
		query.setAddition(input.nextLine());
		System.out.print("Please enter the postal code: ");
		query.setPostalCode(input.nextLine());
		System.out.print("Please enter the place of residence: ");
		query.setPlaceOfResidence(input.nextLine());
		dao.createAddress(query, customer);
	}
	
	public void findAddressByCustomerId() {
		System.out.print("Please enter the customers Id number: ");
		customer.setCustomerId(input.nextInt());
		input.nextLine();
		retrieved = dao.findAddressWithCustomerId(customer);
		if(retrieved == null) {
			System.out.println("Address was not found.");
		}
		else {
			System.out.println("Customer Id     Streetname     Housenumber     Addition     Postal code     Place of Residence");
			System.out.println(customer.getCustomerId() + "     " + retrieved.getStreetname() + "     " + retrieved.getHouseNumber() + 
			"     " + retrieved.getAddition() + "     " + retrieved.getPostalCode() + "     " + retrieved.getPlaceOfResidence());
		}
	}
	
	public void findAddressByLastName() {
		System.out.print("Please enter the customers last name: ");
		customer.setLastName(input.nextLine());
		retrieved = dao.findAddressWithLastName(customer);
		if(retrieved == null) {
			System.out.println("Address was not found.");
		}
		else {
			System.out.println("Customer Id     Streetname     Housenumber     Addition     Postal code     Place of Residence");
			System.out.println(customer.getCustomerId() + "     " + retrieved.getStreetname() + "     " + retrieved.getHouseNumber() + 
			"     " + retrieved.getAddition() + "     " + retrieved.getPostalCode() + "     " + retrieved.getPlaceOfResidence());
		}
	}
	
	public void findAddressByFullName() {
		System.out.print("Please enter the customers first name: ");
		customer.setFirstName(input.nextLine());
		System.out.print("Please enter the customers middle name. If there is none, enter a space: ");
		customer.setMiddleName(input.nextLine());
		System.out.print("Please enter the customers last name: ");
		customer.setLastName(input.nextLine());
		retrieved = dao.findAddresWithFullName(customer);
		if(retrieved == null) {
			System.out.println("Address was not found.");
		}
		else {
			System.out.println("Customer Id     Streetname     Housenumber     Addition     Postal code     Place of Residence");
			System.out.println(customer.getCustomerId() + "     " + retrieved.getStreetname() + "     " + retrieved.getHouseNumber() + 
			"     " + retrieved.getAddition() + "     " + retrieved.getPostalCode() + "     " + retrieved.getPlaceOfResidence());
		}
	}
	
	public void changeAddress() {
		System.out.print("Please enter the customers Id number: ");
		customer.setCustomerId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the streetname: ");
		query.setStreetname(input.nextLine());
		System.out.print("Please enter the house number: ");
		query.setHouseNumber(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the addition. If there is none, enter a space: ");
		query.setAddition(input.nextLine());
		System.out.print("Please enter the postal code: ");
		query.setPostalCode(input.nextLine());
		System.out.print("Please enter the place of residence: ");
		query.setPlaceOfResidence(input.nextLine());
		dao.changeFullAddress(query, customer);
	}
	
	public void deleteAddressByCustomerId() {
		System.out.print("Please enter the customers Id number: ");
		customer.setCustomerId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the streetname: ");
		query.setStreetname(input.nextLine());
		System.out.print("Please enter the house number: ");
		query.setHouseNumber(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the addition. If there is none, enter a space: ");
		query.setAddition(input.nextLine());
		System.out.print("Please enter the postal code: ");
		query.setPostalCode(input.nextLine());
		System.out.print("Please enter the place of residence: ");
		query.setPlaceOfResidence(input.nextLine());
		dao.removeAddressWithBothIds(query, customer);
	}
	
	public void deleteAddress() {
		System.out.println("Please enter the address Id number: ");
		query.setAddressId(input.nextInt());
		input.nextLine();
		dao.removeAddressWithAddressId(query);
	}
}
