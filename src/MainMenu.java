import java.util.Scanner;

public class MainMenu {
	Scanner input = new Scanner(System.in);
	
	public void loadMenu() {
		System.out.println("	#### MAIN MENU ####\n	(1) Customer menu\n	(2) Address menu\n	(3) Orders menu\n	" + 
				"(4) Article menu\n	(5) Invoice menu\n	(6) Logout\n\n");
		System.out.print("Please enter the number of your choice: ");
		int choice = input.nextInt();
		
		switch(choice) {
		case 1: CustomerMenu customerMenu = new CustomerMenu(); customerMenu.loadMenu(); break;
		case 2: ;break;
		case 3: ;break;
		case 4: ;break;
		case 5: ;break;
		case 6: ;
		}
	}
}
