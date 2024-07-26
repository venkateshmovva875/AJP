package com.example;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "articles")
public class Article {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "ArticleId")
	private int id;
	
	@Column(name = "Title")
	private String title;
	@Column(name = "Content")
	private String content;
	@Column(name = "Publication Date")
	private Date publicationDate;
	@Column(name = "Author Info")
	private String authorInformation;
	@Column(name = "Category")
	private String category;
	
	
	public Article(int id, String title, String content, Date publicationDate, String authorInformation, String category) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publicationDate = publicationDate;
		this.authorInformation = authorInformation;
		this.category = category;
	}
	
	public Article() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getAuthorInformation() {
		return authorInformation;
	}

	public void setAuthorInformation(String authorInformation) {
		this.authorInformation = authorInformation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	
	
}
