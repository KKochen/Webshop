
public interface OrderDAOInterface {
	//create
	public abstract void createOrder();
	//read
	public abstract Order findOrderWithOrderId(Order order);
	public abstract Order findOrderWithCustomerId(Order order);
	public abstract Order findOrderWithInvoice(Order order);
	//update
	public abstract void addArticle(Article article, Order order);
	public abstract void setArticleAmount(Article article, Order order);
	public abstract void setInvoice(Order order);
	//delete
	public abstract void removeOrderWithId(Order order);
	public abstract void removeArticleWithId(Article article);
}
