package controller;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ListDetails;
import model.CerealBox;
import model.Consumer;

/**
 * Servlet implementation class editExistingListServlet
 */
@WebServlet("/editExistingListServlet")
public class editExistingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editExistingListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ListDetailsHelper ldh = new ListDetailsHelper();
		CerealBoxHelper cbh = new CerealBoxHelper();
		ConsumerHelper ch = new ConsumerHelper();

		int idToEdit = Integer.parseInt(request.getParameter("id"));
		ListDetails toEdit = ldh.searchForListById(idToEdit);

		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		toEdit.setListName(listName);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		toEdit.setStockDate(ld);

		String consumerName = request.getParameter("consumerName");
		Consumer consumer;
		try {
			consumer = ch.searchForConsumerByName(consumerName);
		} catch (NoResultException ex) {
			consumer = new Consumer(consumerName);
		} catch (Exception ex) {
			consumer = new Consumer(consumerName);
		}

		toEdit.setConsumer(consumer);

		List<CerealBox> previousListOfBoxes = toEdit.getListOfBoxes();

		String[] selectedBoxes = request.getParameterValues("boxesToAdd");
		List<CerealBox> selectedBoxesInList = new ArrayList<CerealBox>();

		if (selectedBoxes != null && selectedBoxes.length > 0 ) {
			for (int i = 0; i < selectedBoxes.length; i++) {
				System.out.println(selectedBoxes[i]);
				CerealBox c = cbh.searchForBoxById(Integer.parseInt(selectedBoxes[i]));
				selectedBoxesInList.add(c);

			}

			previousListOfBoxes.addAll(selectedBoxesInList);
		}

		toEdit.setListOfBoxes(previousListOfBoxes);

		ldh.updateList(toEdit);

		System.out.println("Success!");
		System.out.println(toEdit.toString());

		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}