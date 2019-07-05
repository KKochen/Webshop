
public class Order {
	private int orderId;
	private int customerId;
	private int invoiceId;
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
	
	public int getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(int invoice) {
		this.invoiceId = invoice;
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