package tests;

import java.util.Scanner;

import users.Associate;
import users.Authorization;
import users.Manager;
import users.Member;
import users.User;

public class IntegrationTesting {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.print("\n Username: ");
		String username = scan.next();
		System.out.print("\n Password: ");
		String password = scan.next();
		System.out.println();
		if(Authorization.authorizeMember(username, password)) {
			try {
				User m1 = Authorization.login(username, password);
				System.out.println("Welcome " + m1.getFirstName() + "!\n");
				//System.out.println("Search for a book, type in a book title");
				//String bookTitle = scan.next();
				//System.out.println("Search for a book, type in a book title");
				if(m1 instanceof Member){
					Simulation.memberSimulation((Member)m1, scan);
				}
				if(m1 instanceof Manager){
					Simulation.userSimulation((Member)m1, scan);
				}
				if(m1 instanceof Associate){
					Simulation.userSimulation((Member)m1, scan);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println(e);
				e.printStackTrace();
			}
		}
		scan.close();
		
		
		
	}
	
}
