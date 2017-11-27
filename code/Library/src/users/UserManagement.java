package users;

import java.sql.*;
import java.util.Random;

import common.LibraryConstants;
import libraryutils.Connect;

public class UserManagement {

	///////////////////
	//Member management
	///////////////////
	public static void createMember(Member m){
		try{
			Connection conn = Connect.getConnection();
			String sql = "INSERT INTO Members " + getMemberInsertString() + " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password);
			st.setString(5, m.pin);
			st.setString(6, m.address);
			st.setString(7, m.phoneNumber);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 
	}
	
	public static Member getMember(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt(LibraryConstants.ID);
			String fname = rs.getString(LibraryConstants.FIRST_NAME);
			String lname= rs.getString(LibraryConstants.LAST_NAME);
			String uname = rs.getString(LibraryConstants.USERNAME);
			String password =  rs.getString(LibraryConstants.PASSWORD);
			String pincode =  rs.getString(LibraryConstants.PIN_CODE);
			String address = rs.getString(LibraryConstants.ADDRESS);
			String phoneNumber = rs.getString(LibraryConstants.PHONE_NUMBER);
			Member m = new Member(fname,lname,uname,password,pincode, address, phoneNumber);
			m.setId(id);
			return m;
		    } catch(Exception e){
		    	System.out.println(e);
		    	return null;
		    }		
	}
	
	public static Member getMemberByPin(String pin){
		try{
			Connection conn = Connect.getConnection();
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE PIN_Code = ?");    
			st.setString(1, pin);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt(LibraryConstants.ID);
			String fname = rs.getString(LibraryConstants.FIRST_NAME);
			String lname= rs.getString(LibraryConstants.LAST_NAME);
			String uname = rs.getString(LibraryConstants.USERNAME);
			String password =  rs.getString(LibraryConstants.PASSWORD);
			String pincode =  rs.getString(LibraryConstants.PIN_CODE);
			String address = rs.getString(LibraryConstants.ADDRESS);
			String phoneNumber = rs.getString(LibraryConstants.PHONE_NUMBER);
			Member m = new Member(fname,lname,uname,password,pincode, address, phoneNumber);
			m.setId(id);
			return m;
		    } catch(Exception e){
		    	System.out.println(e);
		    	return null;
		    }		
	}
	
	public static void updateMember(Member m, int id){
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Members SET "+ getMemberUpdateString() + " WHERE " + LibraryConstants.ID + " = "+ id;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password); 
			st.setString(5, m.address);
			st.setString(6, m.phoneNumber);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
	}
	
	public static void deleteMember(String username){
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Members WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
	}
	
	private static String getMemberInsertString(){
		String updateString = "([" + LibraryConstants.FIRST_NAME + "], [" + LibraryConstants.LAST_NAME + "], [" + 
				LibraryConstants.USERNAME + "], [" + LibraryConstants.PASSWORD+ "], [" + LibraryConstants.PIN_CODE +"], [" + 
				LibraryConstants.ADDRESS + "], [" + LibraryConstants.PHONE_NUMBER +"])";
		return updateString;
	}
	
	private static String getMemberUpdateString(){
		return LibraryConstants.FIRST_NAME + " = ?, "+ LibraryConstants.LAST_NAME + " = ?, "+ LibraryConstants.USERNAME  + " = ?, "+
				LibraryConstants.PASSWORD + " = ?, "+ LibraryConstants.ADDRESS + " = ?, "+ LibraryConstants.PHONE_NUMBER + " = ?";
	}
	
	
	////////////////////
	//Manager management
	////////////////////
	public static void createManager(Manager m){
		try{
			Connection conn = Connect.getConnection();
			String sql = "INSERT INTO Employees " + getEmployeeInsertString() + " VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password);
			st.setString(5, m.role);
			st.setString(6, m.address);
			st.setString(7, m.phoneNumber);
			st.setString(8, m.pin);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 	
	}
	
	public static Manager getManager(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			String address = rs.getString(LibraryConstants.ADDRESS);
			String phoneNumber = rs.getString(LibraryConstants.PHONE_NUMBER);
			String pin = rs.getString(LibraryConstants.PIN_CODE);
			return new Manager(fname,lname,uname,password, address, phoneNumber,pin);
		    } catch(Exception e){
		    	return null;
		    }		
	}
	
	public static void updateManager(Manager m, int id){
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Employees SET " + getEmployeeUpdateString() + " WHERE " + LibraryConstants.ID + " = "+ id;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password); 
			st.setString(5, m.address);
			st.setString(6, m.phoneNumber);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	public static void deleteManager(String username){
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Employees WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	//////////////////////
	//Associate management
	/////////////////////
	public static void createAssociate(Associate a){
		try{
			Connection conn = Connect.getConnection();
			String sql = "INSERT INTO Employees "+ getEmployeeInsertString() + " VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, a.firstName);
			st.setString(2, a.lastName);
			st.setString(3, a.username);
			st.setString(4, a.password);
			st.setString(5, a.role);
			st.setString(6, a.address);
			st.setString(7, a.phoneNumber);
			st.setString(8, a.pin);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	public static Associate getAssociate(String username){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ?");    
			st.setString(1, username);    
			ResultSet rs = st.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("FName");
			String lname= rs.getString("LName");
			String uname = rs.getString("Username");
			String password =  rs.getString("Password");
			String address = rs.getString(LibraryConstants.ADDRESS);
			String phoneNumber = rs.getString(LibraryConstants.PHONE_NUMBER);
			String pin = rs.getString(LibraryConstants.PIN_CODE);
			return new Associate(fname,lname,uname,password, address, phoneNumber,pin);
		    } catch(Exception e){
		    	return null;
		    }		
	}
	
	public static void updateAssociate(Associate m, int id){
		try{
			Connection conn = Connect.getConnection();
			String sql = "UPDATE Employees SET " + getEmployeeUpdateString() + " WHERE " + LibraryConstants.ID + " = "+ id;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, m.firstName);
			st.setString(2, m.lastName);
			st.setString(3, m.username);
			st.setString(4, m.password); 
			st.setString(5, m.address);
			st.setString(6, m.phoneNumber);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	public static void deleteAssociate(String username){
		try{
			Connection conn = Connect.getConnection();
			String sql = "DELETE FROM Employees WHERE Username = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.executeUpdate();
		} catch(Exception e){
			System.out.print(e);
		} 			
	}
	
	private static String getEmployeeInsertString(){
		String updateString = "([" + LibraryConstants.FIRST_NAME + "], [" + LibraryConstants.LAST_NAME + "], [" + 
				LibraryConstants.USERNAME + "], [" + LibraryConstants.PASSWORD+ "], [" + LibraryConstants.ROLE +"], [" + 
				LibraryConstants.ADDRESS + "], [" + LibraryConstants.PHONE_NUMBER +"], [" + LibraryConstants.PIN_CODE + "])";
		return updateString;
	}
	
	private static String getEmployeeUpdateString(){
		return LibraryConstants.FIRST_NAME + " = ?, "+ LibraryConstants.LAST_NAME + " = ?, "+ LibraryConstants.USERNAME  + " = ?, "+
				LibraryConstants.PASSWORD + " = ?, "+ LibraryConstants.ADDRESS + " = ?, "+ LibraryConstants.PHONE_NUMBER + " = ?";
	}
	
	public static String generatePINCode() {
		Random rand = new Random();
		int pin = rand.nextInt(8999)+1000;
		return "" + pin;
	}
	
	
}
