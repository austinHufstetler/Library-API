package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import books.Book;
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
		Book b1 = new Book("123456","John","Adams", "Declaration of Indepedence", "romance", "1776", "0");
		b1.setId(6);
		b1.holdBook("90909");
		//2. hold book
		Book b2 = new Book("123456","John","Adams", "Declaration of Indepedence", "romance", "1776", "0");
		b1.setId(3);
		b1.checkoutBook("80808");
	}
}
