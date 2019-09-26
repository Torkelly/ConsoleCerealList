package view;

import java.util.List;
import java.util.Scanner;

import controller.CerealBoxHelper;
import model.CerealBox;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static CerealBoxHelper cbh = new CerealBoxHelper();

		private static void add() {
			System.out.print("Enter name: ");
			String name = in.nextLine();
			System.out.print("Enter flavor: ");
			String flavor = in.nextLine();
			CerealBox cb = new CerealBox(name, flavor);
			cbh.insertBox(cb);
		}

		private static void delete() {
			System.out.print("Enter name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter flavor to delete: ");
			String flavor = in.nextLine();
			CerealBox toDelete = new CerealBox(name, flavor);
			cbh.deleteFlavor(toDelete);
		}

		private static void edit() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by name");
			System.out.println("2 : Search by flavor");
			int searchBy = in.nextInt();
			in.nextLine();	
			List<CerealBox> found;
			
			if (searchBy ==	1)	{
				System.out.print("Enter cereal name: ");
				String cerealName =	in.nextLine();
				found = cbh.searchForBoxByName(cerealName);
			} else {
				System.out.print("Enter flavor:	");
				String cerealFlavor	= in.nextLine();
				found = cbh.searchForBoxByFlavor(cerealFlavor);
			}

			if (!found.isEmpty()) {
				System.out.println("Found Results.");
				for (CerealBox l : found) {
					System.out.println(l.getCerealID() + " : " + l.getName() + ", " + l.getFlavor());
			}
				
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
				CerealBox toEdit = cbh.searchForBoxById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + ", " + toEdit.getFlavor() + " flavored.");
				System.out.println("1 : Update name");
				System.out.println("2 : Update flavor");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} else if (update == 2) {
					System.out.print("New flavor: ");
					String newFlavor = in.nextLine();
					toEdit.setFlavor(newFlavor);
				}

				cbh.updateBox(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the cereal box list! ---");
			while (goAgain) {
				System.out.println("*  Select a flavor:");
				System.out.println("*  1 -- Add a box");
				System.out.println("*  2 -- Edit a box");
				System.out.println("*  3 -- Delete a box");
				System.out.println("*  4 -- View all boxes");
				System.out.println("*  5 -- Exit program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					add();
				} else if (selection == 2) {
					edit();
				} else if (selection == 3) {
					delete();
				} else if (selection == 4) {
					viewTheList();
				} else {
					cbh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<CerealBox>	allBoxes = cbh.showAllBoxes();
			for(CerealBox singleBox : allBoxes){
			System.out.println(singleBox.print());
			}

		}

	}