package tests;

import java.util.ArrayList;

import books.Book;
import books.BookManagement;
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
		// TODO Auto-generated method stub

		//1. Scan Books
		
		//2. Request Member
		
		//3. Renew Books
		/*
		Book b1 = BookManagement.getBook(3);
		b1.requestRenewal("10101");
		b1.renewBook("10101");
		*/
		
		//4. Hold Books
		
		/*
		Book b = BookManagement.getBook(1);
		b.holdBook("10101");
		*/
		
		//5. Display Checked Out Books
		ArrayList<Book> checkedOut = BookTools.getCheckedOutBooks("1111");
		for(int i=0; i<checkedOut.size(); i++){
			System.out.println(checkedOut.get(i).getTitle());
		}
		System.out.println();
		
		//6. Access Fines
		Manager mgr = (Manager)Authorization.login("bstein","honeypot_98");
		double charges = mgr.assessOverdueCharges("jjackn");
		System.out.println(charges);
		
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
		
		//8. Track Fines

		
		//9. Notify of Held Book
		
		
		//10. Report Lost Book
		
		
		//12. Search Books
	}

}
