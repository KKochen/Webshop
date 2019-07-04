import java.util.Scanner;

public class LoginScreen {
	Scanner input = new Scanner(System.in);
	private String username;
	private String password;

	public static void main(String[] args) {
		LoginScreen login = new LoginScreen();
		login.startWebshop();
	}
	
	public void startWebshop() {
		boolean passwordCorrect = true;
		do {
			System.out.print("Do you wish to quit the program? Enter y or n: ");
			String keepGoing = input.nextLine();
			
			if(keepGoing.equals("y")) {
				break;
			}
			/*
			System.out.print("Please enter your username: ");
			username = input.nextLine();
			System.out.print("Please enter your password: ");
			password = input.nextLine();
			
			if(username.equals("admin") && password.equals("TreeDancer")) {*/
				MainMenu mainmenu = new MainMenu();
				mainmenu.loadMenu();
			/*}
			else {
				System.out.println("You have entered an incorrect combination of username and password. Please try again.");
			}*/
		} while(passwordCorrect);
	}
}
