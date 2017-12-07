package tests;

import java.util.ArrayList;
import java.util.Scanner;

import books.Book;
import books.BookManagement;
import books.BookSearch;
import books.BookTools;
import common.LibraryConstants;
import libraryexceptions.InvalidUserException;
import users.Authorization;
import users.Manager;
import users.Member;
import users.UserInformation;
import users.UserManagement;

public class Sprint2Tests {

	public static void main(String[] args) throws InvalidUserException {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		Book b1 = new Book("123456789000","Austin","Huffler", "Guide to Software Engineering", "educational", "2010", "0", 1000);
		BookManagement manage = new BookManagement(b1);
		manage.add();
		BookSearch s = new BookSearch();
		s.setBook(b1);
		ArrayList<Book> searchList = s.search(s.byTitle());
		if(searchList.size() == 1){
			b1 = searchList.get(0);
		}
		Member m1 = new Member("John","Bedene", "bedenejohn", "password", "39248", "123 address street","123-4567");
		Member m2 = new Member("Jane","Bedene", "bedenejane", "password", "39249", "123 address street","123-4568");
		UserManagement.createMember(m1);
		UserManagement.createMember(m2);

		//1. Scan Books
		System.out.println("Is " + b1.getTitle() + " available for checkout? " + b1.isAvailableCheckout());
		scan.nextLine();
		ArrayList<Book> list = BookTools.scanBook(b1.getIsbn(), m1.getPin());
		for(Book b : list){
			System.out.println(m1.getFirstName() + " is checking out " + b.getTitle());
			b.checkoutBook(m1.getPin());
		}

		//3. Renew Books
		b1.requestRenewal(m1.getPin());
		System.out.println("Book: " + b1.getTitle() + " has been renewed by " + m1.getFirstName());
		scan.nextLine();
		//4. Hold Books

		b1.holdBook(m2.getPin());
		System.out.println("Book " + b1.getTitle() + "has been put on hold by " + m2.getFirstName());
		/*
		Book b = BookManagement.getBook(1);
		b.holdBook("10101");
		*/
		scan.nextLine();
		//5. Display Checked Out Books
		list = BookTools.getCheckedOutBooks(m1.getPin());
		System.out.println("Displaying " + m1.getFirstName() +"s checked out books");
		for(Book b : list){
			System.out.println(b.getTitle() + " has been checked out by " + m1.getFirstName() + " " + m1.getLastName());
		}
		scan.nextLine();
		//6. Access Fines
		Manager mgr = (Manager)Authorization.login("bstein","honeypot_98");
		double charges = mgr.assessOverdueCharges("jjackn");
		System.out.println(charges);
		scan.nextLine();
		//7. Suspend Members
		System.out.println("Dil Pickle Suspended? " + UserInformation.isSuspended("dpickle"));
		mgr.suspendAccount("dpickle", LibraryConstants.SUSPENDED_OTHER);
		System.out.println("Dil Pickle Suspended? " + UserInformation.isSuspended("dpickle"));
		mgr.unsuspendAccount("dpickle");
		System.out.println("Dil Pickle Suspended? " + UserInformation.isSuspended("dpickle"));

		//11. View Member Information
		Member m = (Member)Authorization.login("dpickle","12345");
		System.out.println(m.getFirstName() + " " + m.getLastName());
		System.out.println(m.getUsername());
		System.out.println(m.getFines());
		System.out.println(m.getAddress());
		System.out.println(m.getPhoneNumber());
		System.out.println(m.getPin());
		scan.nextLine();

		//8. Track Fines


		//9. Notify of Held Book


		//10. Report Lost Book
		System.out.println(m1.getFirstName() + " has lost his book " + b1.getTitle());
		System.out.println("Deleting book " + b1.getTitle() + " from database");
		BookManagement.deleteBook(b1.getId());
		UserManagement.deleteMember(m1.getUsername());
		UserManagement.deleteMember(m2.getUsername());
		//12. Search Books
		KeywordTest.main(null);
	}

}
