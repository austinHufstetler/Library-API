package users;

public abstract class Employee extends User {

	public Employee(String firstName, String lastName, String role, String username, String password) {
		super(firstName, lastName, role, username, password);
		// TODO Auto-generated constructor stub
	}
	
	//action methods
	private static void addMember(String firstName, String lastName, String username, String password){
		//temporary until we make generatePin() method
		String pin = "0000";
		Member m = new Member(firstName, lastName, username, password, pin);
		UserManagement.createMember(m);;
	}

	private static void displayBooks(Member m){
		
	}
	
	private static void displayFines(Member m){
		
	}
	
	
}
