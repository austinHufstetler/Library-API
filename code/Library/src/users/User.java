package users;
import common.*;

public abstract class User extends LibraryObject{

	String firstName;
	String lastName;
	String role;
	String username;
	String password;
	
	public User(String firstName, String lastName, String role, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
