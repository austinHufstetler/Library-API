package time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {

	public static int getDayDifference(Date d1, Date d2){
		int days = (int) ((d1.getTime() - d2.getTime())/ (1000*60*60*24) );
		return days;
	}

	public static Date convertDate(String input){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date d = null;
		try{
			d = dateFormat.parse(input);
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
		return d;
	}
	
}