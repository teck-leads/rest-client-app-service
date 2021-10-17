package com.techleads.app.junit.article;

public class Article {

	private String content;
//	private String type;
	private Type type;
	
	
	public Article() {
		
	}


	public Article(String content, Type type) {
		super();
		this.content = content;
		this.type = type;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Article [content=" + content + ", type=" + type + "]";
	}
	
	
	
	
}
