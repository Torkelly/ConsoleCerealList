package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CerealBox;

/**
 * Servlet implementation class addBoxServlet
 */
@WebServlet("/addBoxServlet")
public class addBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String flavor = request.getParameter("flavor");
		
		CerealBox cb = new CerealBox(name, flavor);
		CerealBoxHelper cbh = new CerealBoxHelper();
		cbh.insertBox(cb);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
