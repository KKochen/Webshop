
public interface OrderDAOInterface {
	//create
	public abstract void createOrder();
	//read
	public abstract Order findOrderWithOrderId(Order order);
	public abstract Order findOrderWithCustomerId(Order order);
	//update
	public abstract void setArticle(Order order);
	//delete
	public abstract void removeOrderWithId(Order order);
}
