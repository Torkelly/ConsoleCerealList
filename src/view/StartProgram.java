package view;

import java.util.List;
import java.util.Scanner;

import controller.CerealBoxHelper;
import model.CerealBox;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static CerealBoxHelper cbh = new CerealBoxHelper();

		private static void addAnflavor() {
			// TODO Auto-generated method stub
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter a flavor: ");
			String flavor = in.nextLine();
			CerealBox cb = new CerealBox(name, flavor);
			cbh.insertBox(cb);
		}

		private static void deleteAnflavor() {
			// TODO Auto-generated method stub
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the flavor to delete: ");
			String flavor = in.nextLine();
			CerealBox toDelete = new	CerealBox(name, flavor);
			cbh.deleteflavor(toDelete);
		}

		private static void editAnflavor() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Flavor");
			int searchBy = in.nextInt();
			in.nextLine();
			List<CerealBox> foundflavors;
			if (searchBy == 1) {
				System.out.print("Enter the name name: ");
				String nameName = in.nextLine();
				
			} else {
				System.out.print("Enter the flavor: ");
				String flavorName = in.nextLine();
			}
			
			if (searchBy ==	1)	{
				System.out.print("Enter	the	name name:	");
				String cerealName =	in.nextLine();
				foundflavors = cbh.searchForflavorByname(cerealName);
				} else {
				System.out.print("Enter	the	flavor:	");
				String cerealFlavor	= in.nextLine();
				foundflavors = cbh.searchForBoxByflavor(cerealFlavor);
			}

			if (!foundflavors.isEmpty()) {
				System.out.println("Found Results.");
				for (CerealBox l : foundflavors) {
					System.out.println(l.getCerealID() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				CerealBox toEdit = cbh.searchForBoxById(idToEdit);
				System.out.println("Retrieved " + toEdit.getFlavor() + " from " + toEdit.getName());
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
			// TODO Auto-generated method stub
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select a flavor:");
				System.out.println("*  1 -- Add a box");
				System.out.println("*  2 -- Edit a box");
				System.out.println("*  3 -- Delete a box");
				System.out.println("*  4 -- View all boxes");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnflavor();
				} else if (selection == 2) {
					editAnflavor();
				} else if (selection == 3) {
					deleteAnflavor();
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
			// TODO Auto-generated method stub
			List<CerealBox>	allBoxes = cbh.showAllflavors();
			for(CerealBox singleBox : allBoxes){
			System.out.println(singleBox.print());
			}

		}

	}