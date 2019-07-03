
public interface ArticleDAOInterface {
	//create
		public abstract void createArticle(Article article);
	//read
		public abstract Article findArticleWithId(Article article);
		public abstract Article findArticleWithName(Article article);
	//update
		public abstract void changeArticleWithId(Article article);
		public abstract void changeArticleWithName(Article article, String oldName);
	//delete
		public abstract void removeArticleWithId(Article article);
		public abstract void removeArticleWithName(Article article);
}
