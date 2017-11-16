package tests;

import users.FineManagement;
import users.SuspensionManagement;
import users.UserInformation;
import users.UserManagement;

public class SuspensionTest {

	public static void main(String[] args){
		
		//Test 1. isSuspended
		/*System.out.println(UserInformation.isSuspended("dpickle"));
		SuspensionManagement.suspendMember("dpickle",1);
		System.out.println(UserInformation.isSuspended("dpickle"));
		System.out.println(UserInformation.getReasonSuspended("dpickle"));
		SuspensionManagement.unsuspendMember("dpickle");
		System.out.println(UserInformation.isSuspended("dpickle"));
		System.out.println(UserInformation.getReasonSuspended("dpickle")); */
		
		//Test 2. Fine suspension
		FineManagement.issueFines("dpickle", 30.00);
		System.out.println(FineManagement.getFines("dpickle"));
		FineManagement.issueFines("dpickle", 30.00);
		System.out.println(FineManagement.getFines("dpickle"));
		System.out.println(UserInformation.isSuspended("dpickle"));	
		System.out.println(UserInformation.getReasonSuspended("dpickle"));
		FineManagement.payFines("dpickle",FineManagement.getFines("dpickle"));
		System.out.println(UserInformation.isSuspended("dpickle"));	
		System.out.println(UserInformation.getReasonSuspended("dpickle"));
		System.out.println(FineManagement.getFines("dpickle"));
	}
}
