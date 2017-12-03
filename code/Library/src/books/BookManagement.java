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
			Connection conn = Connect.getConnection();
			String sql = "INSERT INTO Books ([ISBN],[Author_FName],[Author_LName],[Title],[Genre],[ReleaseYear],[Hold],[Cost]) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,book.getIsbn());
			st.setString(2, book.getAuthorFirstName());
			st.setString(3, book.getAuthorLastName());
			st.setString(4, book.getTitle());
			st.setString(5, book.getGenre());
			st.setString(6, book.getReleaseYear());
			st.setString(7, book.getHold());
			st.setString(8, book.getCost()+"");
			st.execute();
		} catch(Exception e){
			System.out.print(e);
		}
	}

	/*
	public void update(Book b) {
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Books SET ISBN = ?, Author_FName = ?, Author_LName = ?, Title = ?, Genre = ?, ReleaseYear = ?, Hold = ?, PIN_Code = ?, Cost = ? WHERE ID = "+ b.getId();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,b.getIsbn());
			st.setString(2, b.getAuthorFirstName());
			st.setString(3, b.getAuthorLastName());
			st.setString(4, b.getTitle());
			st.setString(5, b.getGenre());
			st.setString(6, b.getReleaseYear());
			st.setString(7, b.getHold());
			st.setString(8, b.getPin());
			st.setString(9, b.getCost()+"");
			st.executeUpdate();
			
		} catch(Exception e){
			System.out.print(e);
		} 	
	} */
	
	public void update() {
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Books SET ISBN = ?,Author_FName = ?,Author_LName = ?,Title = ?,Genre = ?,ReleaseYear = ?,Hold = ?,Cost = ?,PIN_Code = ? WHERE ID = " + book.getId();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,book.getIsbn());
			st.setString(2, book.getAuthorFirstName());
			st.setString(3, book.getAuthorLastName());
			st.setString(4, book.getTitle());
			st.setString(5, book.getGenre());
			st.setString(6, book.getReleaseYear());
			st.setString(7, book.getHold());
			st.setString(8, book.getCost()+"");
			st.setString(9, book.getPin());
			st.execute();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void delete() {
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Books WHERE ID = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, book.getId() + "");
			st.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} 	
	}
	
	/*
	public void delete(String param) {
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Books " + param;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, book.getTitle());
			st.execute();
		} catch(Exception e){
			e.printStackTrace(System.out);
		}
	} */
	
	public static void deleteBook(int id){
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Books WHERE ID = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id + "");
			st.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
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
			b.setCost(rs.getDouble("Cost"));
			return b;
		    } catch(Exception e){
		    	e.printStackTrace(System.out);
		    	return null;
		    }		
	}
	


}