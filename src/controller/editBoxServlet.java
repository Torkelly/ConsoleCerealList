package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CerealBox;

/**
 * Servlet implementation class editBoxServlet
 */
@WebServlet("/editBoxServlet")
public class editBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CerealBoxHelper cbh = new CerealBoxHelper();
		
		String name = request.getParameter("name");
		String flavor = request.getParameter("flavor");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		CerealBox boxToUpdate = cbh.searchForBoxById(tempId);
		boxToUpdate.setName(name);
		boxToUpdate.setFlavor(flavor);
		
		cbh.updateBox(boxToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBoxesServlet").forward(request, response);
	}

}
