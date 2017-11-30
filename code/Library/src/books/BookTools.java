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
			BM.update(book);
			if(book.getHold().trim() != "0"){
				//alertHeldBook();
			}
		}
	}
	
	
	/*
	public ArrayList<Book> returnBooksOnHoldReadyForCheckout(){
		ArrayList<Book> list = new ArrayList<Book>();
		Book book = new Book();
		BookSearch BS = new BookSearch(book);
		list = BS.search(BS.byPin() + " AND " + BS.byNotHold());
		return list;
	}
	*/
}
