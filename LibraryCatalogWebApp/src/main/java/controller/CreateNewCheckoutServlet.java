package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.Checkout;
import model.Person;


/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/CreateNewCheckoutServlet")
public class CreateNewCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookHelper lih = new BookHelper();
		String checkoutName = request.getParameter("checkoutName");
		System.out.println("Checkout Name: "+ checkoutName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String personName = request.getParameter("personName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedItems =
		request.getParameterValues("allBooksToAdd");
		List<Book> selectedItemsInList = new ArrayList<Book>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			
			for(int i = 0; i<selectedItems.length; i++) {
				
				System.out.println(selectedItems[i]);
				Book c = lih.searchForBookById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
				}
		}
		Person person = new Person(personName);
		Checkout sld = new Checkout(checkoutName, ld, person);
		sld.setListOfBook(selectedItemsInList);
		CheckoutHelper slh = new CheckoutHelper();
		slh.insertNewCheckout(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/ViewAllCheckoutsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
