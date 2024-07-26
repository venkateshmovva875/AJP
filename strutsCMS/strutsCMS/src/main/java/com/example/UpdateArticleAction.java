package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;


public class UpdateArticleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Article article;

	public String post() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;
		System.out.println("Id " + id);
		try {
			tx = session.beginTransaction();

			// Fetch the existing book from the database using book id
			
			Article existingArticle = session.get(Article.class, id);

			if (existingArticle != null) {
				// Update the book details
				
				existingArticle.setId(id);
				existingArticle.setTitle(article.getTitle());
				existingArticle.setContent(article.getContent());
				existingArticle.setPublicationDate(article.getPublicationDate());
				existingArticle.setAuthorInformation(article.getAuthorInformation());

				// Save the changes
				session.merge(existingArticle);

				tx.commit();
				addActionMessage("article updated successfully!");
				return SUCCESS;
			} else {
				addActionError("article with Id " + id + " not found.");
				return ERROR;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			addActionError("Error updating article: " + e.getMessage());
			return ERROR;
		} finally {
			session.close();
		}
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