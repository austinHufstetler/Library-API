package books;

import java.sql.*;
import java.util.ArrayList;

import books.Book;
import common.LibraryConstants;
import libraryutils.Connect;
import users.Associate;

public class BookManagement implements LibraryConstants {


	public void add(Book book) {
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
	
	public ArrayList<Book> search(Book book) {
		ArrayList<Book> list = new ArrayList<Book>();
		try{
			ResultSet rs = byTitle(book).executeQuery();
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
				result.setDaysCheckedOut(rs.getString("DaysCheckedOut"));
				list.add(result);
			}

			return list;

		} catch(Exception e){
			System.out.print(e);
			return null;
		}
	}
	
	public PreparedStatement byId(Book book){
		try{
			String sql = "SELECT * FROM Books WHERE ID = ?";
			PreparedStatement st = getConnection().prepareStatement(sql);
			st.setInt(1, book.getId());
			return st;
		}catch(Exception e){
			System.out.print(e);
			return null;
		}
	}
	
	public PreparedStatement byTitle(Book book){
		try{
			String sql = "SELECT * FROM Books WHERE Title = ?";
			PreparedStatement st = getConnection().prepareStatement(sql);
			st.setString(1, book.getTitle());
			return st;
		}catch(Exception e){
			System.out.print(e);
			return null;
		}
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

	public void update(Book book) {

	}

	public void delete(Book book) {
		try{
			//Class.forName("sun.jbc.odbc.JdbcOdbcDriver");
			//Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/WFH/Desktop/austin/EclipseProjects/software/group1/Library_DB.accdb");
			Connection conn = getConnection();
			String sql = "DELETE FROM Books WHERE Title = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, book.getTitle());
			st.execute();
		} catch(Exception e){
			System.out.print(e);
		}
	}
	
	//is this the right place for it?
	public static String[][] returnCheckedOutBooks(String pin){
		String[][] books= new String[MAX_BOOKS_CHECKOUT][NUM_FIELDS_BOOKS];
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Books WHERE PIN_Code = ?");    
			st.setString(1, pin);    
			ResultSet rs = st.executeQuery();
			int i = 0;
			while(rs.next()) {
				books[i][0] = "" + rs.getInt("ID");
				books[i][1] = rs.getString("ISBN");
				books[i][2] = rs.getString("Author_FName");
				books[i][3] = rs.getString("Author_LName");
				books[i][4] =  rs.getString("Title");
				books[i][5] = rs.getString("Genre");
				books[i][6] = rs.getString("ReleaseYear");
				books[i][7] = rs.getString("Hold");
				books[i][8] =  rs.getString("PIN_Code");
				books[i][9] = "" + rs.getString("DaysCheckedOut");
				i++;
			}
			return books;
		} catch(Exception e){
			System.out.print(e);
			return books;
		}		
	}
	
	



}
