package tests;

import books.Book;

import books.BookSearch;
import books.BookTools;

public class BookSearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(BookTools.getCheckedOutBooks("10101"));
		
		Book b1 = new Book();
		b1.setReleaseYear("1936");
		b1.setPin("10101");
		b1.setGenre("Gone With the Wind");
		b1.setAuthorFirstName("Yukio");
		BookSearch bs = new BookSearch(b1);
		System.out.println(bs.customSearch(1));
	}
}
