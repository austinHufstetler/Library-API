package time;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import books.Book;
import books.BookManagement;
import common.LibraryConstants;
import libraryutils.Connect;
import users.FineManagement;
import users.Member;
import users.SuspensionManagement;
import users.UserManagement;

public class TimeManagement implements LibraryConstants{
	
	public static void newDay(){
		//updateBookTimes();
		updateRenewals();
		
		//should be last
		updateFines();
		
	}
	
	
	//NOT TESTED YET, NEEDS TO BE TESTED
	private static void updateFines(){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT ID,PIN_Code FROM Books WHERE PIN_Code != ?");    
			gt.setString(1, "0");
			ResultSet rs = gt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String pin = rs.getString("PIN_Code");
				if(TimeTools.getDaysCheckedOut(id) > LibraryConstants.CHECKOUT_PERIOD) {
					//member whose fines are over the checkout period
					Member violatingMember = UserManagement.getMemberByPin(pin);
					System.out.println(violatingMember.getLastName());
					//issues fines to that member
					FineManagement.issueFines(violatingMember.getUsername(), LibraryConstants.LATE_FEE);
					if(FineManagement.getFines(violatingMember.getUsername()) > LibraryConstants.ALLOWABLE_FINES){
						SuspensionManagement.suspendMember(violatingMember.getUsername(), LibraryConstants.SUSPENDED_FINES);
					}
				} 
			}
		} 
		catch(Exception e){
		    	System.out.print(e);
		}			
	}
	
	
	private static void updateRenewals(){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT * FROM Books WHERE PIN_Code != ? AND Hold != ?");    
			gt.setString(1, "0");
			gt.setString(2, "0");
			ResultSet rs = gt.executeQuery();
			while(rs.next()) {
				System.out.println("I'm here!");
				int id = rs.getInt("ID");
				String pin = rs.getString("PIN_Code");
				String hold = rs.getString("Hold");
				if(pin.equals(hold) && TimeTools.getDaysCheckedOut(id) >= LibraryConstants.CHECKOUT_PERIOD){
					System.out.println("im here!");
					Book b = BookManagement.getBook(id);
					b.renewBook(pin);
				}

			}
		} 
		catch(Exception e){
		    	System.out.print(e);
		}		
	} 
	
	private void updateHoldPickup(){

	}

	/* wont work with new way
	public static boolean updateBookTimes(){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT DaysCheckedOut,PIN_Code FROM Books WHERE PIN_Code != ?");    
			gt.setString(1, "0");
			ResultSet rs = gt.executeQuery();
			while(rs.next()) {
				String pin = rs.getString("PIN_Code");
				int days = rs.getInt("DaysCheckedOut");
				PreparedStatement st = conn.prepareStatement("UPDATE Books SET DaysCheckedOut= ? WHERE PIN_Code = ?");
				st.setString(1, Integer.toString(days + 1));
				st.setString(2, pin);
				st.executeUpdate();
			}
		    } catch(Exception e){
		    	System.out.print(e);
		    	return false;
		    }			
		return true;
	}
	*/
	
	/* doesn't work with new way of doing it
	public static boolean updateFines(){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement gt = conn.prepareStatement("SELECT DaysCheckedOut,PIN_Code FROM Books WHERE PIN_Code != ?");    
			gt.setString(1, "0");
			ResultSet rs = gt.executeQuery();
			while(rs.next()) {
				String pin = rs.getString("PIN_Code");
				int days = rs.getInt("DaysCheckedOut");
				if(days > 10) {
					PreparedStatement ht = conn.prepareStatement("SELECT fees FROM Members WHERE PIN_Code = ?");
					ht.setString(1, pin);
					ResultSet hs = ht.executeQuery();
					hs.next();
					double currentFees = hs.getDouble("Fees");
					PreparedStatement st = conn.prepareStatement("UPDATE Members SET Fees= ? WHERE PIN_Code = ?");
					//right number?
					st.setString(1, Double.toString(currentFees + LATE_FEE));
					st.setString(2, pin);
					st.executeUpdate();
				}
			}
		    } catch(Exception e){
		    	System.out.print(e);
		    	return false;
		    }			
		return true;
	}
	*/
	
	/*
	public static Date getTime(){
		
	} */
	
}
