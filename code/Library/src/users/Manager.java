package users;

import java.util.ArrayList;

import books.Book;
import time.TimeManagement;

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
	private static void addBook(){
		
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
	
	public void removeManager(String username){
		UserManagement.deleteManager(username);
	}
	
	private static void editManager(){
		
	}
	
	//ASSOCIATES
	public void addAssociate(Associate a){
		UserManagement.createAssociate(a);
	}
	
	public void removeAssociate(String username){
		UserManagement.deleteAssociate(username);
	}
	
	private static void editAssociate(){

	}

	//SEARCHES
	public ArrayList<Member> memberSearch(String search) {
		return UserSearch.memberSearch(search);
	}
	
	
	
	

	
}
