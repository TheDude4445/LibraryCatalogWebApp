package main;

import java.time.LocalDate;
import java.util.List;

import controller.CheckoutHelper;
import controller.PersonHelper;
import model.Checkout;
import model.Person;

public class CheckoutDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person cameron = new Person("Cameron");
		PersonHelper sh = new PersonHelper();
		sh.insertPerson(cameron);
		CheckoutHelper ldh = new CheckoutHelper();
		
		Checkout cameronsCheckout = new Checkout("Cameron's Checkout", LocalDate.now(), cameron);
				ldh.insertNewCheckout(cameronsCheckout);
				List<Checkout> allCheckouts = ldh.getCheckouts();
				for (Checkout a : allCheckouts) {
				System.
				out.println(a.toString());
				}
	}

}
