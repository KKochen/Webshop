import java.sql.*;
import java.util.ArrayList;

public class OrderDAO implements OrderDAOInterface {
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Order fetchedOrder = new Order();

	//create
		public void createOrder(Order order) {
			try {
				prep = connection.prepareStatement("insert into Orders (customerId) values (?)");
				prep.setInt(1, order.getCustomerId());
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
				fetchedOrder.setOrderId(result.getInt("orderId"));
				fetchedOrder.setCustomerId(result.getInt("customerId"));
				fetchedOrder.setInvoiceId(result.getInt("invoiceId"));
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
				fetchedOrder.setInvoiceId(result.getInt("invoiceId"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return fetchedOrder;
		}
		
		public Order findOrderWithInvoice(Order order) {
			try {
				prep = connection.prepareStatement("select * from Orders where invoiceId = ?");
				prep.setInt(1, order.getInvoiceId());
				result = prep.executeQuery();
				result.last();
				System.out.println(result.getInt("OrderId") + " " + result.getInt("customerId"));
				fetchedOrder.setOrderId(result.getInt("orderId"));
				fetchedOrder.setCustomerId(result.getInt("customerId"));
				fetchedOrder.setInvoiceId(result.getInt("invoiceId"));
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
		
		public void addArticleList(ArrayList<Article> list,Order order) {
			
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
		
		/*public void setInvoice(Order order) {//this needs to go in the InvoiceDAO when it's made
			try {
				prep = connection.prepareStatement("update Orders set invoice = ? where orderId = ?");
				prep.setInt(1, order.getInvoiceId());
				prep.setInt(2, order.getOrderId());
				prep.executeUpdate();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println("Payment has been changed.");
		}*/
		
		//delete
		public void removeArticleWithId(Article article, Order order) {
			try {
				prep = connection.prepareStatement("delete from OrdersArticle where orderId = ? and articleId = ?");
				prep.setInt(1, order.getOrderId());
				prep.setInt(2, article.getArticleId());
				prep.executeUpdate();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println("Article has been deleted from Order.");
		}
		
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
