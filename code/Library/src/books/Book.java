package books;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.LibraryConstants;
import libraryexceptions.NonrenewableBookException;
import common.*;
import libraryutils.Connect;
import time.TimeTools;
import users.FineManagement;
import users.Member;
import users.SuspensionManagement;
import users.UserInformation;
import users.UserManagement;
import books.BookManagement;

public class Book extends LibraryObject{
	String isbn = "";
	String authorFirstName = "";
	String authorLastName = "";
	String title = "";
	String genre = "";
	String releaseYear = "";
	String hold = "";
	String pin = "";
	double cost = 0;

	//Basic Book constructor
	public Book(){
		
	}

	//Book Constructor that sets all fields in parameter
	public Book(String isbn,String authorFirstName,String authorLastName, String title, String genre, String releaseYear, String hold, double cost) {
		super();
		this.isbn = isbn;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.hold = hold;
		this.cost = cost;
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
	
	public double getCost(){
		return cost;
	}
	
	public void setCost(double cost){
		this.cost = cost;
	}

	/*
	public void holdBook(String pin){
		if(this.isAvailableHold()) {
			try{
				Connection conn = Connect.getConnection();
				String sql = "UPDATE Books SET Hold = ? WHERE ID= " + this.getId();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, pin);
				st.executeUpdate();
			} catch(Exception e){
				e.printStackTrace();
			} 	
		}
		else{
			System.out.println("Not available for holding");
		}
	} */
	
	public void holdBook(String pin){
		Member m = UserManagement.getMemberByPin(pin);
		if(!UserInformation.isSuspended(m.getUsername())) {
			try{
				Connection conn = Connect.getConnection();
				String sql = "INSERT INTO HoldMap (Book_Id, Hold_Order, PIN_Code) VALUES (?,?,?)";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, this.getId()+"");
				st.setString(2, (this.getOrder() + 1) + "");
				st.setString(3, pin);
				st.executeUpdate();
			} catch(Exception e){
				e.printStackTrace();
			} 	
		}
		else{
			System.out.println("User is suspended");
		}
	} 
	
	private int getOrder(){
		int max = 0;
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM HoldMap where Book_Id = " + this.getId();
			PreparedStatement st = conn.prepareStatement(sql);
			//st.setString(1, "Order");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				int current = rs.getInt("Hold_Order");
				if(current> max)
					max = current;
			}
			return max;
		} catch(Exception e){
			e.printStackTrace();
			return max;
		} 			
	}
	
	private int getLowestOrder(){
		int min = Integer.MAX_VALUE;
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT * FROM HoldMap where Book_Id = " + this.getId();
			PreparedStatement st = conn.prepareStatement(sql);
			//st.setString(1, "Order");
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				int current = rs.getInt("Hold_Order");
				if(current< min)
					min = current;
			}
			return min;
		} catch(Exception e){
			e.printStackTrace();
			return min;
		} 			
	}
	
	private String getNextInLine(){
		try{
			Connection conn = Connect.getConnection();
			String sql = "SELECT PIN_Code FROM HoldMap where Book_Id = ? AND Hold_Order = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, this.getId());
			st.setInt(2, this.getLowestOrder());
			//st.setString(1, "Order");
			ResultSet rs = st.executeQuery();
			rs.next();
			String nextInLine = rs.getString("PIN_Code");
			return nextInLine;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} 			
	}
	
	private void deletePreviousHold(){
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM HoldMap where Book_Id = ? AND Hold_Order = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, this.getId()+"");
			st.setString(2, this.getLowestOrder() + "");
			//st.setString(1, "Order");
			st.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} 		
	}
	
	public void returnBook(){
		this.pin="0";
		BookManagement bm = new BookManagement(this);
		bm.update();
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Books SET DateStartCheckedOut = ?, DateEndCheckedOut = ? WHERE ID= " + this.getId();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, null);
			st.setDate(2, java.sql.Date.valueOf(TimeTools.getCurrentDate()));
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
		
	}
	
	/*
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
		    	e.printStackTrace();
		    	return false;
		    }			
	} */
	
	public boolean isHeld(){
		if(getOrder() == 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	
	public void checkoutBook(String pin){
		if(this.isAvailableCheckout()) {
			try{
				if(this.isHeld()){
					if(!this.getNextInLine().equals(pin)) {
						throw new Exception("You cannot check this book out");
					}
					else{
						this.deletePreviousHold();
					}
				}
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
		    	e.printStackTrace();
		    	return false;
		    }			
	}
	
	public void requestRenewal(String pin){
		Member m1 = UserManagement.getMemberByPin(pin);
		ArrayList<Book> checkedOut = m1.getCheckedOutBooks();
		Book b1 = BookManagement.getBook(this.getId());
		if(!this.isNew() && this.getOrder() == 0 && checkedOut.contains(b1)) {
			try{
				Connection conn = Connect.getConnection();
				String sql = "INSERT INTO HoldMap (Book_Id, Hold_Order, PIN_Code) VALUES (?,?,?)";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, this.getId()+"");
				st.setString(2, (this.getOrder() + 1) + "");
				st.setString(3, pin);
				st.executeUpdate();
			} catch(Exception e){
				e.printStackTrace(System.out);
			} 	
		}
		else{
			try {
				throw new NonrenewableBookException("This user cannot renew this book");
			} catch (NonrenewableBookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	
	public void renewBook(String pin){
		if(!this.isNew() && this.getNextInLine().equals(pin)) {
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
			try {
				throw new NonrenewableBookException("This user cannot renew this book");
			} catch (NonrenewableBookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	} 
	
	public void reportLost(String pin){
		Member m1 = UserManagement.getMemberByPin(pin);
		FineManagement.issueFines(m1.getUsername(), this.getCost());
		UserManagement.updateMember(m1, m1.getId());
		if(m1.getFines() > LibraryConstants.ALLOWABLE_FINES){
			SuspensionManagement.suspendMember(m1.getUsername(), LibraryConstants.SUSPENDED_FINES);
		}
		BookManagement.deleteBook(this.getId());
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
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + getId();
	    return result;
	}

}
