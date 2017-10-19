package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import books.Book;
import books.*;

public class BookTest {

	public static void main(String[] args){
		Book book = new Book("test","test","test","test","test","test","test");
		BookManagement manager =  new BookManagement();
		manager.add(book);
		Book testBook = manager.search(book);
		System.out.print(testBook.getIsbn() == "test");
		manager.delete(book);
		
	}
}
