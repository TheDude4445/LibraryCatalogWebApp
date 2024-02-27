package model;

import javax.persistence.*;

/**
 * Class for Book objects
 */
@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="ISBN")
	private String isbn;
	
	//Constructors
	/**
	 * No arg Constructor
	 */
	public Book() {
		super();
	}
	
	/**
	 * @param title
	 * @param author
	 * @param isbn
	 */
	public Book(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	//Getters and Setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	//Helper Methods
	public String returnBookDetails() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
}
