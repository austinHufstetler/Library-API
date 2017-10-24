package books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.*;
import libraryutils.Connect;

public class Book extends LibraryObject{
	String isbn;
	String authorFirstName;
	String authorLastName;
	String title;
	String genre;
	String releaseYear;
	String hold;

	public Book(String isbn,String authorFirstName,String authorLastName, String title, String genre, String releaseYear, String hold) {
		super();
		this.isbn = isbn;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.hold = hold;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}
	
	/*old way, may be useful in future
	public static void holdBook(char searchBy, String search, String pin){
		String field = "";
		switch(searchBy){
			case 'i': 
				field = "ISBN";
				break;
			default:
				field = "Title";
				break;
		}
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Books SET Hold = ? WHERE " + field + " = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, pin);
			st.setString(2, search);
			st.executeUpdate();
			System.out.println("You have successfully checkout out a book!");
		} catch(Exception e){
			System.out.print("Hold book error " + e);
		} 		
	}
	*/
	public void holdBook(String pin){
		if(this.isAvailableHold()) {
			try{
				Connection conn = Connect.getConnection();
				String sql = "UPDATE Books SET Hold = ? WHERE ID= " + this.getId();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, pin);
				st.executeUpdate();
			} catch(Exception e){
				System.out.print(e);
			} 	
		}
		else{
			System.out.println("Not available for holding");
		}
	}
	
	public boolean isAvailableHold(){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT Hold FROM Books WHERE ID = "+this.getId());     
			ResultSet rs = st.executeQuery();
			rs.next();
			String hold = rs.getString("Hold");
			if(hold.equals("0")){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	System.out.println(e);
		    	return false;
		    }			
	}
	
	public void checkoutBook(String pin){
		if(this.isAvailableCheckout()) {
			try{
				Connection conn = Connect.getConnection();
				String sql = "UPDATE Books SET PIN_Code= ? WHERE ID= " + this.getId();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, pin);
				st.executeUpdate();
			} catch(Exception e){
				System.out.print(e);
			} 	
		}
		else{
			System.out.println("This book is not available for checkout");
		}
	}
	
	public boolean isAvailableCheckout(){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT PIN_Code FROM Books WHERE ID = "+this.getId());     
			ResultSet rs = st.executeQuery();
			rs.next();
			String pin = rs.getString("PIN_Code");
			if(pin.equals("0")){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	System.out.println(e);
		    	return false;
		    }	
	}
	

}
