/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 25, 2024
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Person;

/**
 * The Helper class for People
 */
public class PersonHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LibraryCatalogWebApp");
	
	public void insertPerson(Person p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin(); 
		em.persist(p); 
		em.getTransaction().commit(); 
		em.close();
	}
	
	public List<Person> showAllPeople(){
		EntityManager em = emfactory.createEntityManager();
		List<Person> allPeople = em.createQuery("SELECT p FROM People p").getResultList();
		return allPeople;
	}
	
	public Person findPerson(String nameLookup) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		TypedQuery<Person> personQuery = em.createQuery("SELECT p FROM Person p WHERE p.personName = :selectedName", Person.class);
		
		personQuery.setParameter("selectedName", nameLookup);
		personQuery.setMaxResults(1);
		Person foundPerson;
		
		try {
			foundPerson = personQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundPerson = new Person(nameLookup);
		}
		
		em.close();
		return foundPerson;
	}
}
