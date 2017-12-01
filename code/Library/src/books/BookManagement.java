package books;

import java.sql.*;
import java.util.ArrayList;

import books.Book;
import common.LibraryConstants;
import libraryutils.Connect;
import users.Associate;
import users.Member;

public class BookManagement implements LibraryConstants {

	/////////////////////////
	//SEARCH NEEDS TO BE REMOVED FROM THIS CLASS
	////////////////////////
	
	Book book = new Book();

	public BookManagement(Book book){
		this.book = book;
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
			Connection conn = getConnection();
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
			Connection conn = getConnection();
			String sql = "SELECT * FROM Books " + param;
			PreparedStatement st = conn.prepareStatement(sql);
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
	
	//searches by common fields that normal users would search by
	public static ArrayList<Book> standardSearch(String search) {
		ArrayList<Book> list = new ArrayList<Book>();
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM Books WHERE UPPER(ISBN) LIKE UPPER(?) OR UPPER(Author_FName) LIKE UPPER(?) OR UPPER(Author_LName) LIKE UPPER(?) OR UPPER(Title) LIKE UPPER(?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search + "%" );
			st.setString(2, "%" +search + "%" );
			st.setString(3, "%" +search + "%" );
			st.setString(4, "%" +search + "%" );
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
	
	
	public String byId(){
		return "WHERE ID = " + book.getId();
	}
	
	public String byTitle(){
		return "WHERE Title = " + book.getTitle();
	}

	public String byISBN(){
		return "WHERE ISBN = " + book.getIsbn();
	}

	public String byAuthorFName(){
		return "WHERE Author_FName = " + book.getAuthorFirstName();
	}

	public String byAuthorLName(){
		return "WHERE Author_LName = " + book.getAuthorLastName();
	}

	public String byReleaseYear(){
		return "WHERE ReleaseYear = " + book.getReleaseYear();
	}

	public String byHold(){
		return "WHERE Hold = " + book.getHold();
	}

	public String byNotHold(){
		return "WHERE NOT Hold = " + book.getHold();
	}

	public String byPin(){
		return "WHERE PIN_Code = " + book.getPin();
	}



	public Connection getConnection(){
		try{
			Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Austin/Desktop/gitclipse/group1/Library_DB.accdb");
			return conn;
		}catch(Exception e){
			System.out.print(e);
			return null;
		}
	}

	public void update(Book b) {
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Books SET ISBN = ?, Author_FName = ?, Author_LName = ?, Title = ?, Genre = ?, ReleaseYear = ?, Hold = ?, PIN_Code = ? WHERE ID = "+ b.getId();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,b.getIsbn());
			st.setString(2, b.getAuthorFirstName());
			st.setString(3, b.getAuthorLastName());
			st.setString(4, b.getTitle());
			st.setString(5, b.getGenre());
			st.setString(6, b.getReleaseYear());
			st.setString(7, b.getHold());
			st.setString(8, b.getPin());
			st.executeUpdate();
			
		} catch(Exception e){
			System.out.print(e);
		} 	
	}

	public void delete(String param) {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = getConnection();
			String sql = "DELETE FROM Books " + param;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, book.getTitle());
			st.execute();
		} catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
	
	public static Book getBook(int book_id){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Books WHERE ID = ?");    
			st.setString(1, book_id+"");    
			ResultSet rs = st.executeQuery();
			rs.next();
			Book b = new Book();
			b.setId(book_id);
			b.setReleaseYear(rs.getString("ReleaseYear"));
			b.setAuthorFirstName(rs.getString("Author_FName"));
			b.setAuthorLastName(rs.getString("Author_LName"));
			b.setTitle(rs.getString("Title"));
			b.setGenre(rs.getString("Genre"));
			b.setIsbn(rs.getString("ISBN"));
			b.setHold(rs.getString("Hold"));
			b.setPin(rs.getString("PIN_Code"));
			return b;
		    } catch(Exception e){
		    	e.printStackTrace(System.out);
		    	return null;
		    }		
	}
	


}