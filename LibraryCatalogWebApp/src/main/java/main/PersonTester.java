package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.CheckoutHelper;
import model.Book;
import model.Checkout;
import model.Person;

public class PersonTester {
    public static void main(String[] args) {
    	Person cameron = new Person("Cameron");
    	CheckoutHelper ldh = new CheckoutHelper();
    	Book book1 = new Book("title", "author", "1234");
    	Book book2 = new Book("title2", "author2", "12345");
    	List<Book> cameronsBooks = new ArrayList<Book>();
    	cameronsBooks.add(book1);
    	cameronsBooks.add(book2);
    	Checkout cameronsCheckout = new Checkout("Cameron's ShoppingList", LocalDate.now(), cameron);
    	cameronsCheckout.setListOfBook(cameronsBooks);
    	ldh.insertNewCheckout(cameronsCheckout);
    	List<Checkout> allCheckouts = ldh.getCheckouts();
    	for(Checkout a: allCheckouts) {
    	System.out.println(a.toString());
    	}
    }
}
