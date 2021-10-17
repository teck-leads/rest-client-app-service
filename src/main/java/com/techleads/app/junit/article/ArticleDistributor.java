package com.techleads.app.junit.article;

public class ArticleDistributor {

	private Channel sport;
	private Channel entertainment;
	private Channel others;
	private ArticleDataAccess dataAccess;

	public ArticleDistributor(Channel sport, Channel entertainment, Channel others, ArticleDataAccess dataAccess) {
		super();
		this.sport = sport;
		this.entertainment = entertainment;
		this.others = others;
		this.dataAccess = dataAccess;
	}

	public void disributeTodays() {
		for (Article article : dataAccess.getTodayArticles()) {
			switch (article.getType()) {
			case SPORT:
				sport.accept(article);
				break;

			case ENTERTAINMENT:
				entertainment.accept(article);
				break;

			default:
				others.accept(article);
				break;
			}
		}
	}

}
