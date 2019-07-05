import java.util.Scanner;

public class ArticleMenu {
	Scanner input = new Scanner(System.in);
	ArticleDAO dao = new ArticleDAO();
	Article query = new Article();
	Article retrieved = new Article();
	boolean keepWorking = true;
	
	public void loadMenu() {
		ArticleMenu menu = new ArticleMenu();
		do {
			System.out.println("	#### ARTICLE MENU ####\n	(1) Add an article\n	(2) Find an article by id\n	" +
			"(3) Find an article by name\n	(4) Change an article by id\n	(5) Change an article by name\n	(6) " +
			"Remove an article by id\n	(7) Remove an article by name\n	(0) Return to Main menu\n\n");
			System.out.print("Please enter the number of your choice: ");
			int choice = input.nextInt();
		
			switch(choice) {
			case 1: menu.createNewArticle(); break;
			case 2: menu.findArticleById(); break;
			case 3: menu.findArticleByName(); break;
			case 4: menu.changeArticleById(); break;
			case 5: menu.changeArticleByName(); break;
			case 6: menu.removeArticleById(); break;
			case 7: menu.removeArticleByName(); break;
			case 0: System.out.println("Leaving Article Menu and returning to the Main Menu"); keepWorking = false;
			}
		} while(keepWorking);
	}
	
	public void createNewArticle() {
		System.out.print("Please enter the article name: ");
		query.setArticleName(input.nextLine());
		System.out.print("Please enter the article stock: ");
		query.setArticleStock(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the article price (use a , instead of .): ");
		query.setArticlePrice(input.nextDouble());
		input.nextLine();
		dao.createArticle(query);
	}
	
	public void findArticleById() {
		System.out.print("Please enter the article Id: ");
		query.setArticleId(input.nextInt());
		input.nextLine();
		retrieved = dao.findArticleWithId(query);
		if(retrieved == null) {
			System.out.println("Article was not found.");
		}
		else {
			System.out.println("Article id     Article name     Article price     Article Stock");
			System.out.println(retrieved.getArticleId() + " " + retrieved.getArticleName() + " " + 
			retrieved.getArticlePrice() + " " + retrieved.getArticleStock());
		}
	}
	
	public void findArticleByName() {
		System.out.print("Please enter the article name: ");
		query.setArticleName(input.nextLine());
		retrieved = dao.findArticleWithName(query);
		if(retrieved == null) {
			System.out.println("Article was not found.");
		}
		else {
			System.out.println("Article id     Article name     Article price     Article Stock");
			System.out.println(retrieved.getArticleId() + " " + retrieved.getArticleName() + " " + 
			retrieved.getArticlePrice() + " " + retrieved.getArticleStock());
		}
	}
	
	public void changeArticleById() {
		System.out.print("Please enter the article Id: ");
		query.setArticleId(input.nextInt());
		input.nextLine();
		System.out.print("Please enter the new article name: ");
		query.setArticleName(input.nextLine());
		System.out.print("Please enter the new article price (use a , instead of .): ");
		query.setArticlePrice(input.nextDouble());
		input.nextLine();
		System.out.print("Please enter the new stock: ");
		query.setArticleStock(input.nextInt());
		input.nextLine();
		dao.changeArticleWithId(query);
	}
	
	public void changeArticleByName() {
		String oldName;
		System.out.print("Please enter the article's old name: ");
		oldName = input.nextLine();
		input.nextLine();
		System.out.print("Please enter the new article name: ");
		query.setArticleName(input.nextLine());
		System.out.print("Please enter the new article price  (use a , instead of .): ");
		query.setArticlePrice(input.nextDouble());
		input.nextLine();
		System.out.print("Please enter the new stock: ");
		query.setArticleStock(input.nextInt());
		input.nextLine();
		dao.changeArticleWithName(query, oldName);
	}
	
	public void removeArticleById() {
		System.out.print("Please enter the article Id: ");
		query.setArticleId(input.nextInt());
		input.nextLine();
		dao.removeArticleWithId(query);
	}
	
	public void removeArticleByName() {
		System.out.print("Please enter the article name: ");
		query.setArticleName(input.nextLine());
		dao.removeArticleWithName(query);
	}
}
