package tests;

import java.util.ArrayList;
import books.Book;
import books.BookManagement;
import books.BookSearch;
import keywords.KeywordManagement;
import keywords.KeywordMapManagement;

public class KeywordTest {
	public static void main(String[] args){
		Book b1 = new Book("123456789","John","Bedene", "Guide to Passing with C's", "educational", "2017", "0", 1);
		Book b2 = new Book("987654321","Austin","Huffler", "Guide to Software Engineering", "educational", "2017", "0", 1000);
		BookManagement manage = new BookManagement(b1);
		manage.add();
		manage.setBook(b2);
		manage.add();
		BookSearch s = new BookSearch(b1);
		b1 = s.search(s.byTitle()).get(0);
		s.setBook(b2);
		b2 = s.search(s.byTitle()).get(0);
		KeywordManagement.add("school");
		KeywordManagement.add("computer science");
		KeywordMapManagement.add(b1.getId(), KeywordManagement.searchByKeyword("school").getId());
		System.out.println("Adding Keyword school to Book:" + BookManagement.getBook(b1.getId()).getTitle());
		KeywordMapManagement.add(b2.getId(), KeywordManagement.searchByKeyword("school").getId());
		System.out.println("Adding Keyword school to Book:" + BookManagement.getBook(b2.getId()).getTitle());
		KeywordMapManagement.add(b2.getId(), KeywordManagement.searchByKeyword("computer science").getId());
		System.out.println("Adding Keyword computer science to Book:" + BookManagement.getBook(b2.getId()).getTitle());
		ArrayList<Book> list = KeywordMapManagement.getBooksByKeyword("school");
		System.out.println("When searching for books by the keyword school I found:");
		for(Book b : list){
			System.out.println(b.getTitle());
		}
		KeywordMapManagement.delete(KeywordManagement.searchByKeyword("school").getId());
		KeywordMapManagement.delete(KeywordManagement.searchByKeyword("computer science").getId());
		KeywordManagement.delete("school");
		KeywordManagement.delete("computer science");
		BookManagement.deleteBook(b1.getId());
		BookManagement.deleteBook(b2.getId());
	}
}
