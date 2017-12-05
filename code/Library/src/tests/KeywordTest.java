package tests;

import java.util.ArrayList;
import books.Book;
import keywords.KeywordManagement;
import keywords.KeywordMapManagement;

public class KeywordTest {
	public static void main(String[] args){
		KeywordManagement.add("whale");
		KeywordManagement.add("boat");
		KeywordMapManagement.add(17, KeywordManagement.searchByKeyword("whale").getId());
		KeywordMapManagement.add(17, KeywordManagement.searchByKeyword("boat").getId());
		KeywordMapManagement.add(6, KeywordManagement.searchByKeyword("boat").getId());
		ArrayList<Book> list = KeywordMapManagement.getBooksByKeyword("boat");
		System.out.println(list.size() == 2);
		KeywordMapManagement.delete(KeywordManagement.searchByKeyword("whale").getId());
		KeywordMapManagement.delete(KeywordManagement.searchByKeyword("boat").getId());
		KeywordManagement.delete("whale");
		KeywordManagement.delete("boat");
	}
}
