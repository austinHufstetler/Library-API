package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import users.*;

public class UserTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//Test 1. Create Employee Accounts
		
		/*Associate a1 = new Associate("Peter","Wang","pwang","cherrytree!");
		Manager ma1 = new Manager("Bern","Stein","bstein","honeypot_98");
		UserManagement.createAssociate(a1);
		UserManagement.createManager(ma1); */
		
		//Test 2. Edit Employee Accounts
		
		//Associate a2 = new Associate("Hugo","Reyes","hreyes","lotto77");
		//UserManagement.updateAssociate(a2, 1); 
		
		
		//Test 3. Remove Employee Accounts
		
		//UserManagement.deleteAssociate("jjones");
		
		//Test 4. Read Employee Accounts
		
		//System.out.println(UserManagement.readAssociate("jblack"));
		//System.out.println(UserManagement.readManager("kausten")); 
		
		//Test 5. Create Members
		
		//Member m1 = new Member("Janet","Jac","jjackson","gemini98", "808 My House", "2299090222");
		//UserManagement.createMember(m1); 
		
		//Test 6. Edit Members
		
		/*Member m2 = new Member("Jennifer","Lawrence","jlaw","mother!","10091");
		UserManagement.updateMember(m2,4);	*/
		
		//Test 7. Remove Members
		
		//UserManagement.deleteMember("ldoe");
		
		//Test 7. Read Members
		
		/*System.out.println(UserManagement.readMember("dpickle"));
		System.out.println(UserManagement.readMember("johnhop")); */
		
		//Test 8. Generate Pin for Members
		
		//System.out.println(Member.generatePINCode());
		
		//Test 9. Authorize Users (Login/Logout)
		
		//System.out.println(UserManagement.authorizeUser("kausten", "password456"));
		//System.out.println(UserManagement.authorizeUser("kausten", "password4567")); 
		
		//Test 10. Checkout book
		/*System.out.println(UserManagement.readManager("hreyes"));
		Manager m1 = UserManagement.getManager("hreyes");
		if (m1 != null){
			m1.checkoutBook("9784003234242","10109");
		}*/
		
		//Test 11.Get a Member
		//Member m1 = UserManagement.getMember("dpickle");
		//System.out.println(m1.getFirstName());
		
		//Test 12. Suspend Member
		
		//Test 13. Login
		/*User u1 = Authorization.login("bstein","honeypot_98");
		System.out.println(u1.getFirstName());
		System.out.println(u1.getRole());
		if(u1 instanceof Manager){
			System.out.println("Correct!");
		} */
		
		//Test 14. Suspend Member
		//UserManagement.suspendMember("dpickle");
		
		//Test 15. unsuspend Member
		//UserManagement.unsuspendMember("dpickle");
		
		//Test 16. Read
		//System.out.println(UserManagement.readMember("dpickle"));
		
		//Test 17. New update
		Member m2 = UserManagement.getMember("ldoe");
		m2.setLastName("Lemon");
		UserManagement.updateMember(m2, m2.getId());
		

		
	}

}
