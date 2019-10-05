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
import model.ListDetails;
import model.CerealBox;
import model.Consumer;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createNewListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CerealBoxHelper cbh = new CerealBoxHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String consumerName = request.getParameter("consumerName");
		LocalDate locdate;
		try {
			locdate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			locdate = LocalDate.now();
		}

		String[] selectedBoxes = request.getParameterValues("allBoxesToAdd");
		List<CerealBox> selectedBoxesInList = new ArrayList<CerealBox>();
		if (selectedBoxes != null && selectedBoxes.length > 0) {
			for (int i = 0; i < selectedBoxes.length; i++) {
				System.out.println(selectedBoxes[i]);
				CerealBox cb = cbh.searchForBoxById(Integer.parseInt(selectedBoxes[i]));
				selectedBoxesInList.add(cb);
			}
		}

		Consumer consumer = new Consumer(consumerName);
		ListDetails ld = new ListDetails(listName, locdate, consumer);
		ld.setListOfBoxes(selectedBoxesInList);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(ld);

		System.out.println("Success!");
		System.out.println(ld.toString());

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}