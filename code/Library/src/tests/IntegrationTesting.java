package tests;

import java.util.Scanner;

import users.Authorization;
import users.User;

public class IntegrationTesting {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		try {
			User m1 = Authorization.login(scan.next(), scan.next());
			System.out.println(m1.getFirstName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			e.printStackTrace();
		}
		scan.close();
		
		
		
	}
	
}
