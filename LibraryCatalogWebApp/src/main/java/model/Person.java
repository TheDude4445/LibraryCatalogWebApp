package model;

import javax.persistence.*;

/**
 * Class for Person objects
 */
@Entity
@Table(name="person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String personName;
	
	//Constructors
	/**
	 * No arg Constructor
	 */
	public Person() {
		super();
	}
	/**
	 * @param personName
	 */
	public Person(String personName) {
		super();
		this.personName = personName;
	}
	/**
	 * @param id
	 * @param personName
	 */
	public Person(int id, String personName) {
		super();
		this.id = id;
		this.personName = personName;
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
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	//Helper Methods
	public String returnPersonDetails() {
		return "Person [id=" + id + ", personName=" + personName + "]";
	}
}
