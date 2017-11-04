package tests;

import java.util.Scanner;

import users.Member;

public class Simulation {

	public static void userSimulation(Member m1, Scanner scan){
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.printf("MENU\n%s\n%s\n%s\n","1. Check Fines", "2. Display Books Checked out","3. Logout");
			int choice = scan.nextInt();
			switch(choice){
				case 1: 
					((Member) m1).displayFines();
					break;
				case 3:
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
