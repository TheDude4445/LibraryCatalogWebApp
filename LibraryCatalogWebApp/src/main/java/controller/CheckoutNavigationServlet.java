package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Checkout;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/CheckoutNavigationServlet")
public class CheckoutNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutNavigationServlet() {
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
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
				// TODO Auto-generated method stub
				CheckoutHelper dao = new CheckoutHelper();
				String act = request.getParameter("doThisToCheckout");
				if (act == null) {
					// no button has been selected
					getServletContext().getRequestDispatcher("/ViewAllCheckoutsServlet").forward(request, response);
				} else if (act.equals("delete")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));						
						Checkout CheckoutToDelete = dao.searchForCheckoutById(tempId);
						dao.deleteCheckout(CheckoutToDelete);
					} catch (NumberFormatException e) {
						System.out.println("Forgot to click a button");
					} finally {
						getServletContext().getRequestDispatcher("/ViewAllCheckoutsServlet").forward(request, response);
					}
				} else if (act.equals("edit")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						System.out.println("Current ID Nav: " + request.getParameter("id"));
						Checkout checkoutToUpdate = dao.searchForCheckoutById(tempId);
						request.setAttribute("CheckoutToUpdate", checkoutToUpdate);
						request.setAttribute("id", checkoutToUpdate.getId());
						request.setAttribute("checkoutName", checkoutToUpdate.getCheckoutName());
						request.setAttribute("personName", checkoutToUpdate.getPerson().getPersonName());
						request.setAttribute("month", checkoutToUpdate.getCheckoutDate().getMonthValue());
						request.setAttribute("date", checkoutToUpdate.getCheckoutDate().getDayOfMonth());
						request.setAttribute("year", checkoutToUpdate.getCheckoutDate().getYear());
						BookHelper daoForBooks = new BookHelper();
						request.setAttribute("allBooks", daoForBooks.getAllBooks());
						if(daoForBooks.getAllBooks().isEmpty()){
							request.setAttribute("allBooks", " ");
						}
						getServletContext().getRequestDispatcher("/edit-checkout.jsp").forward(request, response);
					} catch (NumberFormatException e) {
						getServletContext().getRequestDispatcher("/ViewAllCheckoutsServlet").forward(request, response);
					}
				} else if (act.equals("add")) {
					getServletContext().getRequestDispatcher("/new-checkout.html").forward(request, response);
				}
	}
}

