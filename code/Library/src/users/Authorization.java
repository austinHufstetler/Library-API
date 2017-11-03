package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import libraryexceptions.InvalidUserException;
import libraryutils.Connect;

public class Authorization {
	
	public static User login(String username, String password) throws InvalidUserException{
		User u = null;
		if(authorizeUser(username, password)){
			System.out.println("You exist!");
			if(authorizeMember(username,password)){
				System.out.println("You're a member!");
				u = UserManagement.getMember(username);
			}
			else if(authorizeManager(username, password)){
				System.out.println("You're a manager!");
				u = UserManagement.getManager(username);
			}
			else if(authorizeAssociate(username, password)){
				System.out.println("You're an associate!");
				u = UserManagement.getAssociate(username);
			}
		}
		else{
			throw new InvalidUserException("That user doesn't exist!");
		}
		return u;
	}
	
	public static boolean authorizeUser(String username, String password){
		return authorizeEmployee(username,password) || authorizeMember(username, password);
	}
	
	public static boolean authorizeEmployee(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ? AND Password = ?");    
			st.setString(1, username);   
			st.setString(2, password);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			
			if(uname.equals(username) && pswd.equals(password)){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	//System.out.println(e);
		    	return false;
		    }	
	}
	
	public static boolean authorizeAssociate(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ? AND Password = ? AND Role = ?");    
			st.setString(1, username);   
			st.setString(2, password);
			st.setString(3, "associate");
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			String role =  rs.getString("Role"); 
			if(uname.equals(username) && pswd.equals(password) && role.equals("associate")){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	//System.out.println(e);
		    	return false;
		    }	
	}
	public static boolean authorizeManager(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Employees WHERE Username = ? AND Password = ? AND Role = ?");    
			st.setString(1, username);   
			st.setString(2, password);   
			st.setString(2, password);  
			st.setString(3, "manager");
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			String role =  rs.getString("Role"); 
			if(uname.equals(username) && pswd.equals(password) && role.equals("manager")){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	//System.out.println(e);
		    	return false;
		    }	
	}
	
	public static boolean authorizeMember(String username, String password){
		try{
			Connection conn = Connect.getConnection();
			
			PreparedStatement st = conn.prepareStatement("SELECT * FROM Members WHERE Username = ? AND Password = ?");    
			st.setString(1, username);   
			st.setString(2, password);   
			ResultSet rs = st.executeQuery();
			rs.next();
			String uname = rs.getString("Username");
			String pswd =  rs.getString("Password"); 
			
			if(uname.equals(username) && pswd.equals(password)){
				return true;
			}
			else{
				return false;
			}
		    } catch(Exception e){
		    	//System.out.println(e);
		    	return false;
		    }	
	}
}
