import java.util.Scanner;

public class CustomerMenu {
	Scanner input = new Scanner(System.in);
	boolean keepWorking = true;
	CustomerDAO dao = new CustomerDAO();
	Customer retrieved = new Customer();
	Customer query = new Customer();
	public void loadMenu() {
		CustomerMenu menu = new CustomerMenu(); 
		do {
			System.out.println("	#### CUSTOMER MENU ####\n	(1) Add a customer\n	(2) Find a customer with their id\n" +
					"	(3) Find a customer with their last name \n	(4) Find a customer with their full name \n	(5) Find a " + 
					"customer with their email \n	(6) Set the customers full name\n	(7) Set the customers email\n	(8) Delete" + 
					" the customer using their Id\n	(9) Delete the customer using their full name\n	(0) Return to Main menu\n\n");
			System.out.print("Please enter the number of your choice: ");
			int choice = input.nextInt();
		
			switch(choice) {
			case 1: menu.addCustomer();break;
			case 2: menu.findCustomerById();break;
			case 3: menu.findCustomerByLastName();break;
			case 4: menu.findCustomerByFullName();break;
			case 5: menu.findCustomerByEmail();break;
			case 6: menu.changeCustomerFullName();break;
			case 7: menu.changeCustomerEmail();break;
			case 8: menu.removeCustomerById();break;
			case 9: menu.removeCustomerByFullName();break;
			case 0: System.out.println("Leaving Customer Menu and returning to the Main Menu"); keepWorking = false;
			}
		} while(keepWorking);
	}
	
	public void addCustomer() {
		Customer newCustomer = new Customer();
		System.out.print("Enter the customers first name: ");
		newCustomer.setFirstName(input.nextLine());
		System.out.print("Enter the customers middle name if they have one. Otherwise, enter a space: ");
		newCustomer.setMiddleName(input.nextLine());
		System.out.print("Enter the customers last name: ");
		newCustomer.setLastName(input.nextLine());
		System.out.print("Enter the customers email address: ");
		newCustomer.setEmailAddress(input.nextLine());
		dao.createCustomer(newCustomer);
	}
	
	public void findCustomerById() {
		System.out.print("Please enter the customers id-number: ");
		retrieved = dao.findCustomerWithId(input.nextInt());
		if(retrieved == null) {
			System.out.println("Customer not found");
		}
		else {
			System.out.println("CustomerId     Customer Name           Customer email");
			System.out.println(retrieved.getCustomerId() + "      " + retrieved.getFirstName() + " " 
			+ retrieved.getMiddleName() + " " + retrieved.getLastName() + "     " + retrieved.getEmailAddress());
		}
	}
	
	public void findCustomerByLastName() {
		System.out.print("Please enter the customers last name: ");
		query.setLastName(input.nextLine());
		retrieved = dao.findCustomerWithLastName(query);
		if(retrieved == null) {
			System.out.println("Customer not found");
		}
		else {
			System.out.println("CustomerId     Customer Name           Customer email");
			System.out.println(retrieved.getCustomerId() + "     " + retrieved.getFirstName() + " " 
			+ retrieved.getMiddleName() + " " + retrieved.getLastName() + "     " + retrieved.getEmailAddress());
		}
	}
	
	public void findCustomerByFullName() {		
		System.out.print("Please enter the customers first name: ");
		query.setFirstName(input.nextLine());
		System.out.print("Please enter the customers middle name. If they don't have one, enter a space: ");
		query.setMiddleName(input.nextLine());
		System.out.print("Please enter the customers last name: ");
		query.setLastName(input.nextLine());
		retrieved = dao.findCustomerWithFullName(query);
		if(retrieved == null) {
			System.out.println("Customer not found");
		}
		else {
			System.out.println("CustomerId     Customer Name           Customer email");
			System.out.println(retrieved.getCustomerId() + "      " + retrieved.getFirstName() + " " 
			+ retrieved.getMiddleName() + " " + retrieved.getLastName() + "     " + retrieved.getEmailAddress());
		}
	}
	
	public void findCustomerByEmail() {
		System.out.print("Please enter the customers email address: ");
		query.setEmailAddress(input.nextLine());
		retrieved = dao.findCustomerWithEmail(query);
		if(retrieved == null) {
			System.out.println("Customer not found");
		}
		else {
			System.out.println("CustomerId     Customer Name           Customer email");
			System.out.println(retrieved.getCustomerId() + "      " + retrieved.getFirstName() + " " 
			+ retrieved.getMiddleName() + " " + retrieved.getLastName() + "     " + retrieved.getEmailAddress());
		}
	}
	
	public void changeCustomerFullName() {
		System.out.print("Please enter the customers Id number: ");
		query.setCustomerId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the customers first name: ");
		query.setFirstName(input.nextLine());
		System.out.print("Please enter the customers middle name. If they don't have one, enter a space: ");
		query.setMiddleName(input.nextLine());
		System.out.print("Please enter the customers last name: ");
		query.setLastName(input.nextLine());
		dao.setCustomerFullName(query);
	}
	
	public void changeCustomerEmail() {
		System.out.print("Please enter the customers Id number: ");
		query.setCustomerId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the customers email address: ");
		query.setEmailAddress(input.nextLine());
		dao.setCustomerEmail(query);
	}
	
	public void removeCustomerById() {
		System.out.print("Please enter the customers id number: ");
		query.setCustomerId(input.nextInt());
		dao.deleteCustomerWithId(query);
	}
	
	public void removeCustomerByFullName() {
		System.out.print("Please enter the customers first name: ");
		query.setFirstName(input.nextLine());
		System.out.print("Please enter the customers middle name. If they don't have one, enter a space: ");
		query.setMiddleName(input.nextLine());
		System.out.print("Please enter the customers last name: ");
		query.setLastName(input.nextLine());
		dao.deleteCustomerWithFullName(query);
	}
}
