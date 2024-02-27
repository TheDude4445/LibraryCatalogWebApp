/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 25, 2024
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Checkout;

/**
 * The Helper class for Object Checkout
 */
public class CheckoutHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LibraryCatalog");
	
	public void insertNewCheckout(Checkout co) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		em.persist(co); 
		em.getTransaction().commit(); 
		em.close();
	}
	
	public List<Checkout> getCheckouts(){
		EntityManager em = emfactory.createEntityManager();
		List<Checkout> allCheckouts = em.createQuery("SELECT c FROM Checkout c").getResultList();
		return allCheckouts;
	}
	
	public Checkout searchForCheckoutById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		Checkout foundCheckout = em.find(Checkout.class, tempId); 
		em.close(); 
		return foundCheckout;
	}
	
	public void deleteCheckout(Checkout toDelete) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		TypedQuery<Checkout> typedQuery = em.createQuery("select co from Checkout co where co.id = :selectedId", Checkout.class); 
		typedQuery.setParameter("selectedId", toDelete.getId()); 
		typedQuery.setMaxResults(1); 
		Checkout result = typedQuery.getSingleResult(); 
		em.remove(result); 
		em.getTransaction().commit(); 
		em.close();
	}
	
	public void updateCheckout(Checkout toEdit) {
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin(); 
		em.merge(toEdit); 
		em.getTransaction().commit(); 
		em.close();
	}
}
