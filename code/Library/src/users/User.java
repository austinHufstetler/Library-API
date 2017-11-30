package users;
import books.Book;
import common.*;
import libraryutils.DuplicateChecker;

public abstract class User extends LibraryObject{

	String firstName;
	String lastName;
	String role;
	String username;
	String password;
	String pin;
	String address;
	String phoneNumber;
	
	//person who has not entered any information
	public User(){
		this.firstName = "unknown";
		this.lastName = "unknown";
		this.role = "visitor";
		this.username = "unknown";
		this.password = "unknown";
	}
	
	//users who plan to become members
	public User(String firstName, String lastName, String role, String username, String password, String address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		String tempPin = UserManagement.generatePINCode();
		while(DuplicateChecker.duplicatePinCheck(tempPin) == true) {
			tempPin = UserManagement.generatePINCode(); 
		}
		this.pin = tempPin;
	}
	
	//for already created users, used for getting objects
	public User(String firstName, String lastName, String role, String username, String password, String address, String phoneNumber, String pin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.pin = pin;
	}
	
	
	//getters and setters
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
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//action methods
	public static void requestMembership(){
		
	}
	
	public void checkoutBook(Book b, String pin){
		b.checkoutBook(pin);
	}
	
}
