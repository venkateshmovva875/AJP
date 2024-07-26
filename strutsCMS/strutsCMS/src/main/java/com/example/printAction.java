package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;


public class printAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Article article;

	public String post() {
		System.out.println("posted . This is print Action");
		System.out.println(id + 10);
		System.out.println("ID: " + id);
        System.out.println("Title: " + article.getTitle());
        System.out.println("Content: " + article.getContent());
        System.out.println("Publication Date: " + article.getPublicationDate());
        System.out.println("Author Information: " + article.getAuthorInformation());
        System.out.println("Category: " + article.getCategory());
        return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}