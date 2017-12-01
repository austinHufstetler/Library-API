package books;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.LibraryConstants;

import common.*;
import libraryutils.Connect;
import time.TimeTools;

public class Book extends LibraryObject{
	String isbn = "";
	String authorFirstName = "";
	String authorLastName = "";
	String title = "";
	String genre = "";
	String releaseYear = "";
	String hold = "";
	String pin = "";

	//Basic Book constructor
	public Book(){
		
	}

	//Book Constructor that sets all fields in parameter
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
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
				String sql = "UPDATE Books SET PIN_Code= ?, DateStartCheckedOut = ? WHERE ID= " + this.getId();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, pin);
				st.setDate(2, java.sql.Date.valueOf(TimeTools.getCurrentDate()));
				//st.setString(2, TimeTools.getCurrentDate().toString());
				//st.setString(2, "'20100301'");
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
	
	//NEEDS TO BE TESTED
	public boolean isNew(){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT ReleaseYear FROM Books WHERE ID = "+this.getId());     
			ResultSet rs = st.executeQuery();
			rs.next();
			String release = rs.getString("ReleaseYear");
			int releaseYear = Integer.parseInt(release);
			int currentYear = TimeTools.getCurrentYear();
			if(currentYear - releaseYear <= 1){
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
	
	//THIS IS NOT FINISHED, NEEDS TO DEAL WITH UPDATING WHEN 2 WEEKS IS UP (THEY RENEW ON DAY SUPPOSE TO RETURN (or do we deal with that here)?
	public void requestRenewal(String pin){
		if(this.isAvailableHold() && !this.isNew()) {
			try{
				Connection conn = Connect.getConnection();
				String sql = "UPDATE Books SET Hold = ? WHERE ID= " + this.getId();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, pin);
				st.executeUpdate();
			} catch(Exception e){
				e.printStackTrace(System.out);
			} 	
		}
		else{
			//System.out.println("This book is not available for renewal");
			//throws some exception
		}		
	}
	
	
	public void renewBook(String pin){
		if(!this.isNew()) {
			try{
				Connection conn = Connect.getConnection();
				String sql = "UPDATE Books SET Pin_Code = ?, Hold = ?, DateStartCheckedOut = ? WHERE ID= " + this.getId();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, pin);
				st.setString(2, "0");
				st.setDate(3, java.sql.Date.valueOf(TimeTools.getCurrentDate()));
				st.executeUpdate();
			} catch(Exception e){
				e.printStackTrace(System.out);
			} 	
		}
		else{
			//System.out.println("This book is not available for renewal");
			//throws some exception
		}		
	} 
	
	@Override
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		if(!Book.class.isAssignableFrom(o.getClass())){
			return false;
		}
		Book book = (Book)o;
		if(this.getId() != book.getId()){
			return false;
		}
		return true;
	}
}
