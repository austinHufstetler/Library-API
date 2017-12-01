package tests;

import java.util.ArrayList;

import books.Book;

import books.BookSearch;
import books.BookTools;

public class BookSearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(BookTools.getCheckedOutBooks("10101"));
		
		/*
		Book b1 = new Book();
		b1.setReleaseYear("1936");
		b1.setPin("10101");
		b1.setGenre("Gone With the Wind");
		b1.setAuthorFirstName("Oscar");
		b1.setTitle("a");
		BookSearch bs = new BookSearch(b1);
		//System.out.println(bs.customSearch(1));
		//System.out.println(bs.search(bs.byAuthorFName()));
		ArrayList<Book> books = bs.customSearch(bs.byAuthorFName(), bs.byTitle());
		for(int i=0; i<books.size();i++){
			System.out.println(books.get(i).getTitle());
		} */
		
		BookTools.scanBook("9780671836726", "10101");
	}
}
