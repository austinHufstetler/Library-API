package books;

import java.util.ArrayList;

//this class will be for dealing with multiple books and other things

public class BookTools {

	public static ArrayList<Book> getCheckedOutBooks(String pin){
		ArrayList<Book> list = new ArrayList<Book>();
		Book book = new Book();
		book.setPin(pin);
		BookSearch BS = new BookSearch(book);
		list = BS.search(BS.byPin());
		return list;
	}
	
	public void returnBooks(ArrayList<Book> list, String pin){
		Book book = new Book();
		BookManagement BM = new BookManagement(book);
		for(int i=0; i<list.size(); i++){
			book = list.get(i);
			book.setPin(" ");
			BM.setBook(book);
			BM.update();
			if(book.getHold().trim() != "0"){
				//alertHeldBook();
			}
		}
	}
	
	//return a set of books or actually checkout book? how will it actually know which of duplicate books to check out? does it matter?
	public static ArrayList<Book> scanBook(String isbn, String pin){
		Book b = new Book();
		b.setIsbn(isbn);
		b.setHold("0");
		b.setPin("0");
		BookSearch bs = new BookSearch(b);
		ArrayList<Book> possibilities = bs.compoundSearch(bs.byHold(), bs.byISBN(), bs.byPin());
		for(int i=0; i<possibilities.size();i++){
			System.out.println(possibilities.get(i).getTitle());
		}
		return possibilities;
	}
	
	
}
