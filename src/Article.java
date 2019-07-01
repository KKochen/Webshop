
public class Article {
	private int articleId;
	private String articleName;
	private double articlePrice;
	private int articleAmount;
	
	public int getArticleId() {
		return articleId;
	}
	
	public void setArticleId(int id) {
		this.articleId = id;
	}
	
	public String getArticleName() {
		return articleName;
	}
	
	public void setArticleName(String name) {
		this.articleName = name;
	}
	
	public double getArticlePrice() {
		return articlePrice;
	}
	
	public void setArticlePrice(double price) {
		this.articlePrice = price;
	}
	
	public int getArticleAmount() {
		return articleAmount;
	}
	
	public void setArticleAmount(int amount) {
		this.articleAmount = amount;
	}
}
