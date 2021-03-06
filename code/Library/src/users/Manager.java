package users;

import java.util.ArrayList;

import books.Book;
import time.TimeManagement;
import books.BookManagement;

public class Manager extends Employee {
	
	public Manager(String firstName, String lastName, String username, String password, String address, String phoneNumber) {
		super(firstName, lastName, "manager", username, password, address, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String firstName, String lastName, String username, String password, String address, String phoneNumber, String pin) {
		super(firstName, lastName, "manager", username, password, address, phoneNumber, pin);
		// TODO Auto-generated constructor stub
	}
	
	//action methods
	public void suspendAccount(String username, int reason){
		//add "suspended" into member database
		SuspensionManagement.suspendMember(username, reason);
	}
	
	public void unsuspendAccount(String username){
		//add "suspended" into member database
		SuspensionManagement.unsuspendMember(username);
	}
	
	public double assessOverdueCharges(String username){
		return FineManagement.getFines(username);
	}
	
	public void newDay(){
		TimeManagement.newDay();
	}
	
	//BOOKS
	private static void addBook(Book b){
		
	}
	
	//add multiple books
	private static void addBooks(Book... book){
		
	}
	
	private static void editBook(){
		
	}
	
	private static void removeBook(int id){
		//remove book
	}
	
	
	private static void removeBooks(int...id){
		if(id.length == 0){
			
		}
		else{
			for(int i : id){
				//remove books
			}
		}
	}
	
	
	//MANAGERS
	public void addManager(Manager m){
		UserManagement.createManager(m);
	}
	
	public void removeManager(Manager m){
		UserManagement.deleteManager(m.username);
	}
	
	private void editManager(Manager m, int id){
		UserManagement.updateManager(m, id);
	}
	
	//ASSOCIATES
	public void addAssociate(Associate a){
		UserManagement.createAssociate(a);
	}
	
	public void removeAssociate(String username){
		UserManagement.deleteAssociate(username);
	}
	
	public void editAssociate(Associate a, int id){
		UserManagement.updateAssociate(a, id);
	}
	

	
	
	
	

	
}
