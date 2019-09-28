package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CerealBox;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CerealBoxHelper cbh = new CerealBoxHelper();
		String act = request.getParameter("doThisToBox");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllBoxesServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ID"));
				CerealBox boxToDelete = cbh.searchForBoxById(tempId);
				cbh.deleteBox(boxToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllBoxesServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ID"));
				CerealBox boxToEdit = cbh.searchForBoxById(tempId);
				request.setAttribute("boxToEdit", boxToEdit);
				getServletContext().getRequestDispatcher("/edit-box.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllBoxesServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}

	}

}
