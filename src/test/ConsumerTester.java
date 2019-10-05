package test;

import java.time.LocalDate;
import java.util.List;

import controller.ListDetailsHelper;
import controller.ConsumerHelper;
import model.ListDetails;
import model.Consumer;

public class ConsumerTester {

	public static void main(String[] args) {
		Consumer mallory = new Consumer("Mallory");
		ConsumerHelper cons = new ConsumerHelper();
		cons.insertConsumer(mallory);
		List<Consumer> allConsumers = cons.showAllConsumers();
		
		ListDetailsHelper bdh = new ListDetailsHelper();
		ListDetails malloryList = new ListDetails("Mallory's List", LocalDate.now(), mallory);
		bdh.insertNewListDetails(malloryList);
		List<ListDetails> allBoxes = bdh.getLists();
		
			for(Consumer c: allConsumers) {
				System.out.println(c.toString());
			}
			
			for (ListDetails bd : allBoxes) {
				System.out.println(bd.toString());
			}
	}

}
