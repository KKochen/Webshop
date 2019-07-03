import java.util.Scanner;

public class CustomerMenu {
	Scanner input = new Scanner(System.in);
	public void loadMenu() {
		System.out.println("	#### CUSTOMER MENU ####\n	(1) Add a customer\n	(2) Find a customer with their id\n" +
			"	(3) Find a customer with their last name \n	(4) Find a customer with their full name \n	(5) Find a" + 
			"customer with their email \n	(6)Set the customers full name\n	(7) Set the customers email\n	(8) Delete" + 
			" the customer using their Id\n	(9) Delete the customer using their full name\n	(0) Return to Main menu\n\n");
		System.out.print("Please enter the number of your choice: ");
		int choice = input.nextInt();
	}
}
