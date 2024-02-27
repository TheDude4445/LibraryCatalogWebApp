/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Feb 24, 2024
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Book;

/**
 * The Helper class for Object Book
 */
public class BookHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LibraryCatalog");
	
	public void insertBook(Book bo) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bo);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Book> showAllBooks(){
		EntityManager em = emfactory.createEntityManager();
		List<Book> allBooks = em.createQuery("SELECT i FROM Book i").getResultList();
		return allBooks;
	}
	
	public void deleteBook(Book toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("SELECT bo FROM Book bo WHERE bo.title = :selectedTitle and bo.author = :selectedAuthor and bo.isbn = :selectedISBN", Book.class);
		//Substitute parameter with	actual data from the toDelete item
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
		typedQuery.setParameter("selectedISBN", toDelete.getIsbn());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		Book result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * @param idToEdit
	 * @return
	 */
	public Book searchForBookById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Book found = em.find(Book.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateBook(Book toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * @param bookTitle
	 * @return
	 */
	public List<Book> searchForBookByTitle(String bookTitle) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("SELECT bo FROM Book bo WHERE bo.title = :selectedTitle", Book.class);
		typedQuery.setParameter("selectedTitle", bookTitle);
		List<Book> foundBook = typedQuery.getResultList();
		em.close();
		return foundBook;
	}

	/**
	 * @param authorName
	 * @return
	 */
	public List<Book> searchForBookByAuthor(String authorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("SELECT bo FROM Book bo WHERE bo.author = :selectedAuthor", Book.class);
		typedQuery.setParameter("selectedAuthor", authorName);
		List<Book> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	/**
	 * @param bookISBN
	 * @return
	 */
	public List<Book> searchForBookByISBN(String bookISBN) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Book> typedQuery = em.createQuery("SELECT bo FROM Book bo WHERE bo.isbn = :selectedISBN", Book.class);
		typedQuery.setParameter("selectedISBN", bookISBN);
		List<Book> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
