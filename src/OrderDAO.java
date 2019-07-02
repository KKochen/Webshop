import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Order fetchedOrder = new Order();

	
	public static void main(String[] args) {
		OrderDAO tryout = new OrderDAO();
		Order order = new Order();
		Article article1 = new Article();
		article1.setArticleId(1);
		article1.setArticleName("TurtleWax");
		article1.setArticleAmount(1);
		article1.setArticlePrice(5.95);
		order.setArticle1(article1);
		order.setCustomerId(4);
		Order testing = new Order();
		Article a2 = new Article();
		a2.setArticleId(2);
		a2.setArticleName("Car shampoo");
		a2.setArticleAmount(2);
		a2.setArticlePrice(7.9);
		testing.setOrderId(2);
		testing.setCustomerId(4);
		testing.setArticle1(a2);
		
		//tryout.createOrder(order);
		//tryout.changeArticle(testing);
	}
	//create
		public void createOrder(Order order) {
			try {
				prep = connection.prepareStatement("insert into Orders (customerId, articleId1, articleName1," +
				"articleAmount1, articlePrice1) values (?, ?, ?, ?, ?)");
				prep.setInt(1, order.getCustomerId());
				prep.setInt(2, order.getArticle1().getArticleId());
				prep.setString(3, order.getArticle1().getArticleName());
				prep.setInt(4, order.getArticle1().getArticleAmount());
				prep.setDouble(5, order.getArticle1().getArticlePrice());
				prep.executeUpdate();
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
				System.out.println(result.getInt("OrderId") + " " + result.getString("articleName1"));
				Article a1 = new Article();
				a1.setArticleId(result.getInt("articleId1"));
				a1.setArticleName(result.getString("articleName1"));
				a1.setArticleAmount(result.getInt("ArticleAmount1"));
				a1.setArticlePrice(result.getDouble("ArticlePrice1"));
				fetchedOrder.setArticle1(a1);
				fetchedOrder.setOrderId(result.getInt("orderId"));
				fetchedOrder.setCustomerId(result.getInt("customerId"));
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
				System.out.println(result.getInt("OrderId") + " " + result.getString("articleName1"));
				Article a1 = new Article();
				a1.setArticleId(result.getInt("articleId1"));
				a1.setArticleName(result.getString("articleName1"));
				a1.setArticleAmount(result.getInt("ArticleAmount1"));
				a1.setArticlePrice(result.getDouble("ArticlePrice1"));
				fetchedOrder.setArticle1(a1);
				fetchedOrder.setOrderId(result.getInt("orderId"));
				fetchedOrder.setCustomerId(result.getInt("customerId"));
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return fetchedOrder;
		}
		//update
		public void changeArticle(Order order) {
			try {
				prep = connection.prepareStatement("update Orders set articleId1 = ?, articleName1 = ?, articleAmount1 = ?," + 
				"articlePrice1 = ? where OrderId = ?");
				prep.setInt(1, order.getArticle1().getArticleId());
				prep.setString(2, order.getArticle1().getArticleName());
				prep.setInt(3, order.getArticle1().getArticleAmount());
				prep.setDouble(4, order.getArticle1().getArticlePrice());
				prep.setInt(5, order.getOrderId());
				prep.executeUpdate();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			System.out.println("Article has been changed.");
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
