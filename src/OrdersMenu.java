import java.util.ArrayList;
import java.util.Scanner;

public class OrdersMenu {
	Scanner input = new Scanner(System.in);
	OrderDAO dao = new OrderDAO();
	Order query = new Order();
	Order retrieved = new Order();
	Article article = new Article();
	ArrayList<Article> list = new ArrayList<>();
	boolean keepWorking = true;
	
	public void loadMenu() {
		OrdersMenu menu = new OrdersMenu();
		do {
			System.out.println("	#### ORDERS MENU ####\n	(1) Add an order\n	(2) Find an order with the" +
			" orders id\n" +	"	(3) Find an order with the customers id \n	(4) Find an order with the" +
			" invoice status \n	(5) Add an article to an order\n	(6) Add an article list to an order \n" +
			"	(7) Change an article amount\n	(8) Remove an article from an order\n	(9) Remove a customers order\n" + 
			"	(0) Return to Main menu\n\n");
			System.out.print("Please enter the number of your choice: ");
			int choice = input.nextInt();
		
			switch(choice) {
			case 1: menu.newOrder(); break;
			case 2: menu.findOrderByOrderId(); break;
			case 3: menu.findOrderByCustomerId(); break;
			case 4: menu.findOrderByInvoice(); break;
			case 5: menu.addAnArticle(); break;
			case 6: menu.addAnArticleList(); break;
			case 7: menu.changeAnArticleAmount(); break;
			case 8: menu.removeArticleFromOrder(); break;
			case 9: menu.removeOrder(); break;
			case 0: System.out.println("Leaving Orders Menu and returning to the Main Menu"); keepWorking = false;
			}
		} while(keepWorking);
	}
	
	public void newOrder() {
		System.out.print("Please enter the customers Id number: ");
		query.setCustomerId(input.nextInt());
		input.nextLine();
		dao.createOrder(query);
	}
	
	public void findOrderByOrderId() {
		System.out.print("Please enter the orders Id number: ");
		query.setOrderId(input.nextInt());
		input.nextLine();
		retrieved = dao.findOrderWithOrderId(query);
		if(retrieved == null) {
			System.out.println("Order was not found.");
		}
		else {
			System.out.println("Order Id     Customer Id     Invoice Id");
			System.out.println(retrieved.getOrderId() + " " + retrieved.getCustomerId() + " " + retrieved.getInvoiceId());
		}
	}
	
	public void findOrderByCustomerId() {
		System.out.print("Please enter the customers Id number: ");
		query.setOrderId(input.nextInt());
		input.nextLine();
		retrieved = dao.findOrderWithCustomerId(query);
		if(retrieved == null) {
			System.out.println("Order was not found.");
		}
		else {
			System.out.println("Order Id     Customer Id     Invoice Id");
			System.out.println(retrieved.getOrderId() + " " + retrieved.getCustomerId() + " " + retrieved.getInvoiceId());
		}
	}
	
	public void findOrderByInvoice() {
		//implement when InvoiceMenu is made
	}
	
	public void addAnArticle() {
		System.out.print("Please enter the order Id: ");
		query.setOrderId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the article Id: ");
		article.setArticleId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the article amount: ");
		article.setArticleAmount(input.nextInt());
		dao.addArticle(article, query);
	}
	
	public void addAnArticleList() {//implement this with a batch thingy
		dao.addArticleList(list,query);
	}
	
	public void changeAnArticleAmount() {
		System.out.print("Please enter the order Id: ");
		query.setOrderId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the article Id: ");
		article.setArticleId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the new article amount: ");
		article.setArticleAmount(input.nextInt());
		input.nextLine();
		dao.setArticleAmount(article, query);
	}
	
	public void removeArticleFromOrder() {
		System.out.print("Please enter the order id: ");
		query.setOrderId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the article Id: ");
		article.setArticleId(input.nextInt());
		input.nextLine();
		dao.removeArticleWithId(article, query);		
	}
	
	public void removeOrder() {
		System.out.print("Please enter the order id: ");
		query.setOrderId(input.nextInt());
		input.nextLine();
		dao.removeOrderWithId(query);
	}
}
