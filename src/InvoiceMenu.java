import java.util.Scanner;

public class InvoiceMenu {
	Scanner input = new Scanner(System.in);
	InvoiceDAO dao = new InvoiceDAO();
	boolean keepWorking = true;
	Invoice query = new Invoice();
	Invoice retrieved = new Invoice();
	Customer customer = new Customer();
	Order order = new Order();
	Address address = new Address();
	
	
	public void loadMenu() {
		InvoiceMenu menu = new InvoiceMenu();
		do {
			System.out.println("	#### INVOICE MENU ####\n	(1) Add an invoice\n	(2) Find an invoice with the" +
			" invoice id\n" +	"	(3) Find an invoice with the customers id \n	(4) Find unpaid invoices" +
			"\n	(5) Set invoice to order id\n	(6) Set the paid/unpaid status of an invoice\n	(7) Set " +
			"invoice address\n	(8) Remove an invoice by id\n	(9) Remove an invoice by customer id\n	(10) Remove an" +
			" order by order id\n	(0) Return to Main menu\n\n");
			System.out.print("Please enter the number of your choice: ");
			int choice = input.nextInt();
		
			switch(choice) {
			case 1: menu.newInvoice(); break;
			case 2: menu.findInvoiceById(); break;
			case 3: menu.findInvoiceByCustomerId(); break;
			case 4: menu.findUnpaidInvoices(); break;
			case 5: menu.setInvoiceOrderId(); break;
			case 6: menu.setPaidStatus(); break;
			case 7: menu.setAddress(); break;
			case 8: menu.removeInvoiceById(); break;
			case 9: menu.removeInvoiceByCustomerId(); break;
			case 10: menu.removeInvoiceByOrderId(); break;
			case 0: System.out.println("Leaving Orders Menu and returning to the Main Menu"); keepWorking = false;
			}
		} while(keepWorking);
	}
	
	public void newInvoice() {
		System.out.print("Please enter the invoice address id: ");
		query.setInvoiceAddressId(input.nextInt());
		input.nextLine();
		dao.createInvoice(query);
	}
	
	public void findInvoiceById() {
		System.out.print("Please enter the invoice id: ");
		query.setInvoiceId(input.nextInt());
		input.nextLine();
		retrieved = dao.findInvoiceWithId(query);
		if(retrieved == null) {
			System.out.println("Invoice was not found.");
		}
		else {
			System.out.println("Invoice Id     Invoice address Id     Paid? (true/false)");
			System.out.println(retrieved.getInvoiceId() + " " + retrieved.getInvoiceAddressId() + " " + retrieved.isPaid());
		}
	}
	
	public void findInvoiceByCustomerId() {
		System.out.print("Please enter the customer id: ");
		customer.setCustomerId(input.nextInt());
		input.nextLine();
		retrieved = dao.findInvoiceWithCustomerId(customer);
		if(retrieved == null) {
			System.out.println("Invoice was not found.");
		}
		else {
			System.out.println("Invoice Id     Invoice address Id     Paid? (true/false)");
			System.out.println(retrieved.getInvoiceId() + " " + retrieved.getInvoiceAddressId() + " " + retrieved.isPaid());
		}
	}
	
	public void findUnpaidInvoices() {
		query.setPaid(false);
		retrieved = dao.findInvoiceUnpaid(query);
		if(retrieved == null) {
			System.out.println("Invoice was not found.");
		}
		else {
			System.out.println("Invoice Id     Invoice address Id     Paid? (true/false)");
			System.out.println(retrieved.getInvoiceId() + " " + retrieved.getInvoiceAddressId() + " " + retrieved.isPaid());
		}
	}
	
	public void setInvoiceOrderId() {
		System.out.print("Please enter the invoice id: ");
		query.setInvoiceId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the order id: ");
		order.setOrderId(input.nextInt());
		input.nextLine();
		dao.setInvoiceIdToOrder(query, order);
	}
	
	public void setPaidStatus() {
		System.out.print("Please enter the invoice id: ");
		query.setInvoiceId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter true or false to indicate whether the invoice has been paid or not: ");
		query.setPaid(input.nextBoolean());
		input.nextLine();
		dao.setIsPaid(query);
	}
	
	public void setAddress() {
		System.out.print("Please enter the streetname: ");
		address.setStreetname(input.nextLine());
		System.out.print("Please enter the house number: ");
		address.setHouseNumber(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the addition: ");
		address.setAddition(input.nextLine());
		System.out.print("Please enter the postal code: ");
		address.setPostalCode(input.nextLine());
		System.out.print("Please enter the place of residence: ");
		address.setPlaceOfResidence(input.nextLine());
		System.out.print("Please enter the invoice id: ");
		query.setInvoiceId(input.nextInt());
		input.nextLine();
		dao.setInvoiceAddress(query, address);
	}
	
	public void removeInvoiceById() {
		System.out.print("Please enter the invoice id: ");
		query.setInvoiceId(input.nextInt());
		input.nextLine();
		dao.removeInvoiceWithId(query);
	}
	
	public void removeInvoiceByCustomerId() {
		System.out.print("Please enter the customer id: ");
		customer.setCustomerId(input.nextInt());
		input.nextLine();
		dao.removeInvoiceWithCustomerId(customer);
	}
	
	public void removeInvoiceByOrderId() {
		System.out.print("Please enter the order id: ");
		order.setOrderId(input.nextInt());
		input.nextLine();
		dao.removeInvoiceWithOrderId(order);
	}
}
