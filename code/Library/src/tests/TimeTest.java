package tests;

import java.util.Date;

import time.TimeManagement;
import time.TimeTools;

public class TimeTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		//1. Get number of days between two dates
		//Date d1 = new Date();
		
		//Date d2 = new Date();
		/*String inputString = "11-11-2016";
		Date d2 = TimeTools.convertDate(inputString);
		System.out.println(TimeTools.getDayDifference(d1, d2)); */
		
		//2. Update book times everyday, false if failed, true if success
		//System.out.println(TimeManagement.updateBookTimes());
		
		//3. Update fees everyday, false if failed, true if success
		//System.out.println(TimeManagement.updateFines());
		
		//4. get days checkedout, useful for checking return etc
		/*
		System.out.println(TimeTools.getDaysCheckedOut(8));
		System.out.println(TimeTools.getCurrentDate());
		System.out.println(TimeTools.convertDate(TimeTools.getCurrentDate()));
		*/
		TimeManagement.newDay();
	}

}
