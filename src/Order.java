
public class Order {
	private int orderId;
	private int customerId;
	private Article article1;
	private Article article2;
	private Article article3;

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int id) {
		this.orderId = id;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int id) {
		this.customerId = id;
	}
	
	public Article getArticle1() {
		return article1;
	}
	
	public void setArticle1(Article a1) {
		this.article1 = a1;
	}
	
	public Article getArticle2() {
		return article2;
	}
	
	public void setArticle2(Article a2) {
		this.article2 = a2;
	}
	
	public Article getArticle3() {
		return article3;
	}
	
	public void setArticle3(Article a3) {
		this.article3 = a3;
	}
}
