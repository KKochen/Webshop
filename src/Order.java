
public class Order {
	private int orderId;
	private int customerId;
	private boolean invoice;
	private int articleId;
	private int articleAmount;

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
	
	public boolean isInvoice() {
		return invoice;
	}
	
	public void setInvoice(boolean invoice) {
		this.invoice = invoice;
	}
	
	public int getArticleAmount() {
		return articleAmount;
	}
	
	public void setArticleAmount(int amount) {
		this.articleAmount = amount;
	}
	
	public int getArticleId() {
		return articleId;
	}
	
	public void setArticleId(int id) {
		this.articleId = id;
	}
}