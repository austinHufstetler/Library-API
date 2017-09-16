package tests;

import Books.Book;

public class BookTest {

	public static void main(String[] args){
		Book book = new Book("test","test","test");
		System.out.print(book.getAuthor() == "test");
	}

}
