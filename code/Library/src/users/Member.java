package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;

import books.Book;
import books.BookTools;
import libraryutils.Connect;

public class Member extends User {

	
	public Member(String firstName, String lastName, String username, String password, String address, String phoneNumber) {
		super(firstName, lastName, "member", username, password, address, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	
	
	//constructor for already created members, used when getting back member objects
	public Member(String firstName, String lastName, String username, String password, String pin, String address, String phoneNumber) {
		super(firstName, lastName, "member", username, password, address, phoneNumber, pin);
		// TODO Auto-generated constructor stub
	}
	

	//getters and setters
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	//actions methods
	
	public void requestRenewal(Book book){
		book.requestRenewal(this.pin);
	}
	
	public void reportLostBook(Book book){
		
	}
	
	public ArrayList<Book> getCheckedOutBooks(){
		return BookTools.getCheckedOutBooks(this.pin);
	}
	
	public String getInfo(){
		return String.format("%10s%15s\n%10s%15s\n%10s%15s\n","Name: ",this.firstName + " " + this.lastName, "Pin Code: ", this.pin, "Username: ", this.username);
	}
	
	public double getFines(){
		return FineManagement.getFines(this.username);
	}
	
	public void payFines(double amount){
		FineManagement.payFines(this.username, amount);
	}
	
	public void deleteAccount(){
		UserManagement.deleteMember(this.username);
	}
	

	
	
	
	



}
