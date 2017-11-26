package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import books.Book;
import time.TimeTools;
import books.*;

public class BookTest {

	public static void main(String[] args){
		/*Book book = new Book("test","test","test","test","test","test","test");
		BookManagement manager =  new BookManagement();
		manager.add(book);
		Book testBook = manager.search(book);
		System.out.print(testBook.getIsbn() == "test");
		manager.delete(book); */
		
		//1. checkout book
		//Book b1 = new Book("123456","John","Adams", "Declaration of Indepedence", "romance", "1776", "0");
		//b1.setId(8);
		//b1.checkoutBook("90909");
		//b1.holdBook("90909");
		//System.out.println(TimeTools.getCurrentDate().toString());
		//2. hold book
		/*
		Book b2 = new Book("123456","John","Adams", "Declaration of Indepedence", "romance", "1776", "0");
		b1.setId(3);
		b1.checkoutBook("80808");
		*/
		
		/*
		//Test 3. Display CheckedoutBooks
		String[][] checkedout = BookManagement.returnCheckedOutBooks("10101");
		for(int i=0; i<checkedout.length; i++){
			for(int j=0; j<checkedout[0].length;j++){
				if(checkedout[i][j] == null){
					break;
				}
				System.out.print(checkedout[i][j] + " ");;
			}
			System.out.println();
		}
		*/
		
		//Test 3. Display CheckedoutBooks
		/*
		BookManagement b1 = new BookManagement(new Book());
		ArrayList<Book> checkedout = b1.returnCheckedOutBooks("10101");
		for(int i=0; i<checkedout.size(); i++){
				System.out.println(checkedout.get(i).getTitle());
			}
			System.out.println();
	} */
		
	//Test 4. Check if book is new
	Book b1 = BookManagement.getBook(8);
	System.out.println(b1.isNew());
	
	}
}
