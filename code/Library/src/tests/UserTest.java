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
		
		//Member m1 = new Member("Janet","Jackson","jjackson","gemini98");
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
		Member m1 = UserManagement.getMember("dpickle");
		System.out.println(m1.getFirstName());
		

		
	}

}
