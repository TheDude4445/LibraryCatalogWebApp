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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/EditCheckoutDetailsServlet")
public class EditCheckoutDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCheckoutDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CheckoutHelper dao = new CheckoutHelper();
		BookHelper lih = new BookHelper();
		PersonHelper sh = new PersonHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Checkout checkoutToUpdate = dao.searchForCheckoutById(tempId);
		String newCheckoutName = request.getParameter("checkoutName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String personName = request.getParameter("personName");
		//find our add the new shopper
		Person newPerson = sh.findPerson(personName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
			//items are selected in list to add
			String[] selectedBooks = request.getParameterValues("allBooksToAdd");
			List<Book> selectedBooksInCheckout = new ArrayList<Book>();
			for (int i = 0; i < selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);
				Book c = lih.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInCheckout.add(c);
			}
			checkoutToUpdate.setListOfBook(selectedBooksInCheckout);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Book> selectedBooksInCheckout = new ArrayList<Book>();
			checkoutToUpdate.setListOfBook(selectedBooksInCheckout);
		}
		checkoutToUpdate.setCheckoutName(newCheckoutName);
		checkoutToUpdate.setCheckoutDate(ld);
		checkoutToUpdate.setPerson(newPerson);
		dao.updateCheckout(checkoutToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllCheckoutsServlet").forward(request, response);
	}
}
