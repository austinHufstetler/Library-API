package tests;

import java.util.Scanner;

import users.Manager;
import users.Member;
import users.UserManagement;
import users.UserSearch;

public class Simulation {


	public static void memberSimulation(Member m1, Scanner scan){
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.printf("MENU\n%s\n%s\n%s\n%s\n%s\n%s\n","1. Check Fines", "2. Pay Fines","3. Display All Information", "4. Display Checked Out Books","10. Logout", "11. Delete Account");
			int choice = scan.nextInt();
			switch(choice){
				case 1:
					System.out.println(m1.getFines());
					break;
				case 2:
					System.out.println("Payment: ");
					double amount = scan.nextDouble();
					((Member) m1).payFines(amount);
					break;
				case 3:
					System.out.println(m1.getInfo());
					break;
				case 4:
					System.out.println(m1.getCheckedOutBooks());
					break;
				case 10:
					System.out.println("Goodbye");
					keepGoing = false;
					break;
				default:
					System.out.println("Not a valid choice");
					break;
			}
			System.out.println();
		}
	}

	public static void managerSimulation(Manager m1, Scanner scan){
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.printf("MENU\n%s\n%s\n%s\n%s\n%s\n%s\n","1. Add Member", "2. Delete Member","3. Update Member", "4. Read Member Info","5. Search Member","10. Logout");
			int choice = scan.nextInt();
			switch(choice){
				case 1:

					break;

				case 5:
					System.out.println("Please enter search criteria: ");
					scan.nextLine();
					String searchBy = scan.nextLine();
					//System.out.println(m1.memberSearch(searchBy));
					break;
				case 10:
					System.out.println("Goodbye");
					keepGoing = false;
					break;
				default:
					System.out.println("Not a valid choice");
					break;
			}
			System.out.println();
		}
	}

	public static void userSimulation(Member m1, Scanner scan){
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.printf("MENU\n%s\n%s\n%s\n","1. Check Fines", "2. Pay Fines","3. Search Book", "4. Display Checked Out Books","10. Logout", "11. Delete Account");
			int choice = scan.nextInt();
			switch(choice){
				case 1:

					break;
				case 2:
					System.out.println("Payment: ");
					double amount = scan.nextDouble();
					((Member) m1).payFines(amount);
					break;
				case 10:
					System.out.println("Goodbye");
					keepGoing = false;
					break;
				default:
					System.out.println("Not a valid choice");
					break;
			}
			System.out.println();
		}
	}

}
