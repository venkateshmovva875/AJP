package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.example.Book;

public class UpdateBookAction extends ActionSupport {
	private int id;
	private Book book;

	public String post() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// Fetch the existing book from the database using ISBN
			Book existingBook = session.get(Book.class, id);

			if (existingBook != null) {
				// Update the book details
				existingBook.setId(id);
				existingBook.setTitle(book.getTitle());
				existingBook.setAuthor(book.getAuthor());
				existingBook.setGenre(book.getGenre());
				existingBook.setNumCopies(book.getNumCopies());

				// Save the changes
				session.merge(existingBook);

				tx.commit();
				addActionMessage("Book updated successfully!");
				return SUCCESS;
			} else {
				addActionError("Book with Id " + id + " not found.");
				return ERROR;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			addActionError("Error updating book: " + e.getMessage());
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
