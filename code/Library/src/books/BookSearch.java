package books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import libraryutils.Connect;

public class BookSearch {
	
	//all search methods need to go here
	Book book = new Book();

	public BookSearch(Book book){
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
}