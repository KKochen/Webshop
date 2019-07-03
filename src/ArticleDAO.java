import java.sql.*;

public class ArticleDAO implements ArticleDAOInterface{
	Connection connection = DBConnector.getConnection();
	PreparedStatement prep;
	ResultSet result;
	Article found = new Article();
	
	public static void main(String[] args) {
		ArticleDAO tryout = new ArticleDAO();
		Article a1 = new Article();
		a1.setArticleName("Turtlewax");
		a1.setArticleAmount(25);
		a1.setArticlePrice(5.95);
		Article tester = new Article();
		tester.setArticleId(1);
		tester.setArticleName("Engine oil");
		tester.setArticleAmount(75);
		tester.setArticlePrice(15.95);
		
		//tryout.createArticle(a1);
		tryout.removeArticleWithName(a1);
	}
	
	//create
	public void createArticle(Article article) {
		try {
			prep = connection.prepareStatement("insert into Article (articleName, articlePrice, articleAmount)" +
			"values (?, ?, ?)");
			prep.setString(1, article.getArticleName());
			prep.setDouble(2, article.getArticlePrice());
			prep.setInt(3, article.getArticleAmount());
			prep.executeUpdate();
			System.out.println("Article has been added.");
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
		//read
			public Article findArticleWithId(Article article) {
				try {
					prep = connection.prepareStatement("select * from Article where articleId = ?");
					prep.setInt(1, article.getArticleId());
					result = prep.executeQuery();
					result.last();
					found.setArticleId(result.getInt("articleId"));
					found.setArticleName(result.getString("articleName"));
					found.setArticleAmount(result.getInt("articleAmount"));
					found.setArticlePrice(result.getDouble("articlePrice"));
					System.out.println(found.getArticleName() + " " + found.getArticlePrice());
				}
				
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				return found;
			}
			public Article findArticleWithName(Article article) {
				try {
					prep = connection.prepareStatement("select * from Article where articleName = ?");
					prep.setString(1, article.getArticleName());
					result = prep.executeQuery();
					result.last();
					found.setArticleId(result.getInt("articleId"));
					found.setArticleName(result.getString("articleName"));
					found.setArticleAmount(result.getInt("articleAmount"));
					found.setArticlePrice(result.getDouble("articlePrice"));
					System.out.println(found.getArticleName() + " " + found.getArticlePrice());
				}
				
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				return found;
			}
		//update
			public void changeArticleWithId(Article article) {
				try {
					prep = connection.prepareStatement("update Article set articleName = ?, articleAmount = ?," + 
					"articlePrice = ? where articleId = ?");
					prep.setString(1, article.getArticleName());
					prep.setInt(2, article.getArticleAmount());
					prep.setDouble(3, article.getArticlePrice());
					prep.setInt(4, article.getArticleId());
					prep.executeUpdate();
					System.out.println("Article has been changed.");					
				}
				
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			public void changeArticleWithName(Article article, String oldName) {
				try {
					prep = connection.prepareStatement("update Article set articleName = ?, articleAmount = ?," + 
					"articlePrice = ? where articleName = ?");
					prep.setString(1, article.getArticleName());
					prep.setInt(2, article.getArticleAmount());
					prep.setDouble(3, article.getArticlePrice());
					prep.setString(4, oldName);
					prep.executeUpdate();
					System.out.println("Article has been changed.");	
				}
				
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		//delete
			public void removeArticleWithId(Article article) {
				try {
					prep = connection.prepareStatement("delete from Article where articleId = ?");
					prep.setInt(1, article.getArticleId());
					prep.executeUpdate();
					System.out.println("Article has been removed.");
				}
				
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			public void removeArticleWithName(Article article) {
				try {
					prep = connection.prepareStatement("delete from Article where articleName = ?");
					prep.setString(1, article.getArticleName());
					prep.executeUpdate();
					System.out.println("Article has been removed.");
				}
				
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
}
