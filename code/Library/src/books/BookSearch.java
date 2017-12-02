package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import common.LibraryConstants;
import libraryutils.Connect;

public class BookSearch {
	
	//all search methods need to go here
	Book book = new Book();

	public BookSearch(Book book){
		this.book = book;
	}
	
	public BookSearch(){

	}
	
	public Book getBook(){
		return this.book;
	}

	public void setBook(Book book){
		this.book = book;
	}

	public void add() {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = Connect.getConnection();
			String sql = "INSERT INTO Books ([ISBN],[Author_FName],[Author_LName],[Title],[Genre],[ReleaseYear],[Hold]) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,book.getIsbn());
			st.setString(2, book.getAuthorFirstName());
			st.setString(3, book.getAuthorLastName());
			st.setString(4, book.getTitle());
			st.setString(5, book.getGenre());
			st.setString(6, book.getReleaseYear());
			st.setString(7, book.getHold());
			st.execute();
		} catch(Exception e){
			System.out.print(e);
		}
	}
	

	
	public ArrayList<Book> search(String param) {
		ArrayList<Book> list = new ArrayList<Book>();
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM Books WHERE " + param;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, getSearchString(param));
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Book result = new Book();
				result.setId(rs.getInt("ID"));
				result.setIsbn(rs.getString("ISBN"));
				result.setAuthorFirstName(rs.getString("Author_FName"));
				result.setAuthorLastName(rs.getString("Author_LName"));
				result.setTitle(rs.getString("Title"));
				result.setGenre(rs.getString("Genre"));
				result.setReleaseYear(rs.getString("ReleaseYear"));
				result.setHold(rs.getString("Hold"));
				result.setPin(rs.getString("PIN_Code"));
				list.add(result);
			}

			return list;

		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	}
	
	public ArrayList<Book> customSearch(String ... param) {
		ArrayList<Book> list = new ArrayList<Book>();
		try{
			for(String p: param) {
				ArrayList<Book> books = search(p);
				for(int i=0; i<books.size(); i++){
					list.add(books.get(i));
				}
			}
			Set<Book> set = new HashSet<Book>(list);
			list = new ArrayList<Book>(set);
			return list;
		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	} 
	
	
	//searches by common fields that normal users would search by
	public ArrayList<Book> standardSearch(String search) {
		ArrayList<Book> list = new ArrayList<Book>();
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM Books WHERE "
					+ "UPPER(ISBN) LIKE UPPER(?) "
					+ "OR UPPER(Author_FName) LIKE UPPER(?) "
					+ "OR UPPER(Author_LName) LIKE UPPER(?) "
					+ "OR UPPER(Title) LIKE UPPER(?) "
					+ "OR UPPER(Genre) LIKE UPPER(?) "
					+ "OR UPPER(ReleaseYear) LIKE UPPER(?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search + "%" );
			st.setString(2, "%" +search + "%" );
			st.setString(3, "%" +search + "%" );
			st.setString(4, "%" +search + "%" );
			st.setString(5, "%" +search + "%" );
			st.setString(6, "%" +search + "%" );
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Book result = new Book();
				result.setId(rs.getInt("ID"));
				result.setIsbn(rs.getString("ISBN"));
				result.setAuthorFirstName(rs.getString("Author_FName"));
				result.setAuthorLastName(rs.getString("Author_LName"));
				result.setTitle(rs.getString("Title"));
				result.setGenre(rs.getString("Genre"));
				result.setReleaseYear(rs.getString("ReleaseYear"));
				result.setHold(rs.getString("Hold"));
				result.setPin(rs.getString("PIN_Code"));
				list.add(result);
			}

			return list;

		} catch(Exception e){
			e.printStackTrace(System.out);
			return null;
		}
	}
	
	
	public ArrayList<Book> compoundSearch(String ... param) {
		ArrayList<Book> list = new ArrayList<Book>();
		try{
			for(String p: param) {
				ArrayList<Book> books = search(p);
				for(int i=0; i<books.size(); i++){
					list.add(books.get(i));
				}
			}
			ArrayList<Book> satisfiesAll = new ArrayList<Book>();
			for(Book b : list) {
			   if(Collections.frequency(list, b) == param.length) {
			       satisfiesAll.add(b);
			   }
			}
			Set<Book> set = new HashSet<Book>(satisfiesAll);
			satisfiesAll = new ArrayList<Book>(set);
			return satisfiesAll;
		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	} 
	
	public String byId(){
		return "WHERE ID = ?";
	}
	
	public String byTitle(){
		return "UPPER(Title) LIKE UPPER(?)";
	}

	public String byISBN(){
		return "ISBN = ?";
	}

	public String byAuthorFName(){
		return "UPPER(Author_FName) LIKE UPPER(?)";
	}

	public String byAuthorLName(){
		return "UPPER(Author_LName) LIKE UPPER(?)";
	}

	public String byReleaseYear(){
		return "ReleaseYear = ?";
	}

	public String byHold(){
		return "Hold = ?";
	}

	public String byNotHold(){
		return "NOT Hold = ?";
	}

	public String byPin(){
		return "PIN_Code = ?";
	} 
	

	private String getSearchString(String param){
		if(param.equals(byPin())){
			return book.pin + "";
		}
		else if(param.equals(byAuthorFName())){
			return "%" + book.authorFirstName + "%";
		}
		else if(param.equals(byAuthorLName())){
			return "%" + book.authorLastName + "%";
		}
		else if(param.equals(byISBN())){
			return book.isbn;
		}
		else if(param.equals(byId())){
			return book.getId() + "";
		}
		else if(param.equals(byReleaseYear())){
			return book.releaseYear;
		}
		else if(param.equals(byHold()) || param.equals(byNotHold())){
			return book.hold;
		}
		else{
			return "%" + book.title + "%";
		}
	}
	
	

}
