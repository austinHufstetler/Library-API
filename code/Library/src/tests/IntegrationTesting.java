package tests;

import java.util.ArrayList;
import java.util.Scanner;

import books.Book;
import books.BookManagement;
import books.BookSearch;
import users.Associate;
import users.Authorization;
import users.Manager;
import users.Member;
import users.User;

public class IntegrationTesting {

	public static void main(String[] args){
		
		
		Scanner scan = new Scanner(System.in);

			boolean keepGoing = true;
			while(keepGoing) {
				System.out.printf("MENU\n%s\n%s\n%s\n","1. Login", "2. Search For Books","3. Become a Member","4. Exit");
				int choice = scan.nextInt();
				switch(choice){
					case 1: 
						System.out.print("\n Username: ");
						String username = scan.next();
						System.out.print("\n Password: ");
						String password = scan.next();
						System.out.println();
						if(Authorization.authorizeUser(username, password)) {
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
									Simulation.managerSimulation((Manager)m1, scan);
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
						break;
					case 2: 
						System.out.println("Please enter search criteria: ");
						scan.nextLine();
						String searchBy = scan.nextLine();
						ArrayList<Book> list = BookSearch.standardSearch(searchBy);
						for(int i=0; i<list.size(); i++){
							System.out.println( "BOOK ID = " + list.get(i).getId() + " - " + list.get(i).getAuthorFirstName() + " " + list.get(i).getAuthorLastName() + " - " + list.get(i).getTitle());
						}
						break;
					case 3: 
						break;
					case 4:
						System.out.println("Goodbye");
						keepGoing = false;
						break;
					default:
						System.out.println("Not a valid choice");
						break;
				}
				System.out.println();
			}			

			scan.close();
		
		
		
	}
	
}
