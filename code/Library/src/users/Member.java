package users;

public class Member extends User {
	
	String pin;
	
	public Member(String firstName, String lastName, String username, String password, String pin) {
		super(firstName, lastName, "member", username, password);
		// TODO Auto-generated constructor stub
		this.pin = pin;
	}


	
}
