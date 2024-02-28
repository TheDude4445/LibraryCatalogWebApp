package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

/**
 * Class for Checkout objects
 */
@Entity
public class Checkout {
	@Id
	@GeneratedValue
	private int id; 
	private String checkoutName; 
	private LocalDate checkoutDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Person person; 
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Book> listOfBook;
	
	//Constructors
	/**
	 * No arg Constructor
	 */
	public Checkout() {
		super();
	}
	/**
	 * @param checkoutName
	 * @param person
	 */
	public Checkout(String checkoutName, Person person) {
		super();
		this.checkoutName = checkoutName;
		this.person = person;
	}
	/**
	 * @param checkoutName
	 * @param person
	 * @param listOfBook
	 */
	public Checkout(String checkoutName, Person person, List<Book> listOfBook) {
		super();
		this.checkoutName = checkoutName;
		this.person = person;
		this.listOfBook = listOfBook;
	}
	/**
	 * @param id
	 * @param checkoutName
	 * @param person
	 * @param listOfBook
	 */
	public Checkout(int id, String checkoutName, Person person, List<Book> listOfBook) {
		super();
		this.id = id;
		this.checkoutName = checkoutName;
		this.person = person;
		this.listOfBook = listOfBook;
	}
	public Checkout(String checkoutName, LocalDate checkoutDate, Person person) {
        this.checkoutName = checkoutName;
        this.checkoutDate = checkoutDate;
        this.person = person;
        // Assuming listOfItems is initialized as an empty list
        this.listOfBook = List.of(); // Available in Java 9 and later, or use new ArrayList<>() for earlier versions
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
	 * @return the checkoutName
	 */
	public String getCheckoutName() {
		return checkoutName;
	}
	/**
	 * @param checkoutName the checkoutName to set
	 */
	public void setCheckoutName(String checkoutName) {
		this.checkoutName = checkoutName;
	}
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the listOfBook
	 */
	public List<Book> getListOfBook() {
		return listOfBook;
	}
	/**
	 * @param listOfBook the listOfBook to set
	 */
	public void setListOfBook(List<Book> listOfBook) {
		this.listOfBook = listOfBook;
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	//Helper Methods
	@Override
	public String toString() {
		return "Checkout [id=" + id + ", checkoutName=" + checkoutName + ", person=" + person + ", listOfBook="
				+ listOfBook + "]";
	}
}
