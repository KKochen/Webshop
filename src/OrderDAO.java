import java.sql.*;

public class OrderDAO {
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Order fetchedOrder = new Order();

	
	public static void main(String[] args) {
		OrderDAO tryout = new OrderDAO();
		Order order = new Order();
		order.setCustomerId(1);
		order.setOrderId(2);
		order.setInvoice(true);
		Article article1 = new Article();
		article1.setArticleId(1);
		article1.setArticleName("TurtleWax");
		article1.setArticleAmount(1);
		article1.setArticlePrice(5.95);
		Order testing = new Order();
		testing.setOrderId(2);
		testing.setCustomerId(1);
		Article a2 = new Article();
		a2.setArticleId(1);
		a2.setArticleName("Car shampoo");
		a2.setArticleAmount(2);
		a2.setArticlePrice(7.9);

		//tryout.createOrder(order);
		tryout.removeOrderWithId(order);
	}
	//create
		public void createOrder(Order order) {
			try {
				prep = connection.prepareStatement("insert into Orders (customerId, invoice) values (?, ?)");
				prep.setInt(1, order.getCustomerId());
				prep.setBoolean(2, order.isInvoice());
				prep.executeUpdate();
				System.out.println("Order has been created.");
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
		}
		//read
		public Order findOrderWithOrderId(Order order) {
			try {
				prep = connection.prepareStatement("select * from Orders where OrderId = ?");
				prep.setInt(1, order.getOrderId());
				result = prep.executeQuery();
				result.last();
				System.out.println(result.getInt("OrderId") + " " + result.getInt("customerId"));
				fetchedOrder.setOrderId(result.getInt("orderId"));
				fetchedOrder.setCustomerId(result.getInt("customerId"));
				fetchedOrder.setInvoice(result.getBoolean("invoice"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return fetchedOrder;
		}
		public Order findOrderWithCustomerId(Order order) {
			try {
				prep = connection.prepareStatement("select * from Orders where CustomerId = ?");
				prep.setInt(1, order.getCustomerId());
				result = prep.executeQuery();
				result.last();
				System.out.println(result.getInt("OrderId") + " " + result.getInt("customerId"));
				fetchedOrder.setOrderId(result.getInt("orderId"));
				fetchedOrder.setCustomerId(result.getInt("customerId"));
				fetchedOrder.setInvoice(result.getBoolean("invoice"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return fetchedOrder;
		}
		
		public Order findOrderWithInvoice(Order order) {
			try {
				prep = connection.prepareStatement("select * from Orders where invoice = ?");
				prep.setBoolean(1, order.isInvoice());
				result = prep.executeQuery();
				result.last();
				System.out.println(result.getInt("OrderId") + " " + result.getInt("customerId"));
				fetchedOrder.setOrderId(result.getInt("orderId"));
				fetchedOrder.setCustomerId(result.getInt("customerId"));
				fetchedOrder.setInvoice(result.getBoolean("invoice"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return fetchedOrder;
		}
		
		//update
		public void addArticle(Article article, Order order) {
			try {
				prep = connection.prepareStatement("insert into OrdersArticle (articleId, articleAmount,OrderId)" + 
				"values (?,?,?)");
				prep.setInt(1, article.getArticleId());
				prep.setInt(2, article.getArticleAmount());
				prep.setInt(3, order.getOrderId());
				prep.executeUpdate();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println("Article has been added.");
		}
		
		public void setArticleAmount(Article article, Order order) {
			try {
				prep = connection.prepareStatement("update OrdersArticle set articleAmount = ? where articleId = ? and orderId = ?");
				prep.setInt(1, article.getArticleAmount());
				prep.setInt(2, article.getArticleId());
				prep.setInt(3, order.getOrderId());
				prep.executeUpdate();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println("Article amount has been changed.");
		}
		public void setInvoice(Order order) {
			try {
				prep = connection.prepareStatement("update Orders set invoice = ? where orderId = ?");
				prep.setBoolean(1, order.isInvoice());
				prep.setInt(2, order.getOrderId());
				prep.executeUpdate();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println("Payment has been changed.");
		}
		
		//delete
		public void removeOrderWithId(Order order) {
			try {
				prep = connection.prepareStatement("delete from Orders where orderId = ?");
				prep.setInt(1,order.getOrderId());
				prep.executeUpdate();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println("Order has been deleted.");
		}
}
