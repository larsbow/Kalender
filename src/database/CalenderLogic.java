package database;

import java.util.ArrayList;
import java.util.List;


public class CalenderLogic {
	ArrayList<List<Integer>> calender;
	int startDay;
	
	public int daysInMonth(int year, int month) {
		int days;
		switch (month) {
    case 1:
        days = 31;
        break;
    case 2:
         if (isLeapYear(year) == true)
        	 days = 29;
         else
        	 days = 28;
         break;
    case 3:
    	days = 31;
    	break;
    case 4:
    	days = 30;
    	break;
    case 5:
    	days = 31;
    	break;
    case 6:
    	days = 30;
    	break;
    case 7:
    	days = 31;
    	break;
    case 8:
    	days = 31;
    	break;
    case 9:
    	days = 30;
    	break;
    case 10:
    	days = 31;
    	break;
    case 11:
    	days = 30;
    	break;
    case 12:
    	days = 31;
    	break;
       
    default:
    	days = 0;
		}
    	return days;
		
	}
	
	public int getMonthStartDay(int year, int month) {
		if (month == 1)
			    startDay = getYearStartDay(year);
			else if (month < 1 || month > 12)
			    startDay = 0;
			else {
			startDay = getMonthStartDay(year,month-1) + (daysInMonth(year, month-1)%7);
			    if (startDay > 7)
			        startDay = startDay - 7;
			}
		return startDay;
	}
	
	public int getYearStartDay(int year) {
		int diff = (year - 1900);
		startDay = (diff%7) + 1;

		for (int i = 1900; i== year; i++) {
		    if (isLeapYear(i - 1) == true)
		        startDay = startDay + 1;
		}

		startDay = (startDay%7);
		if (startDay == 0)
		   startDay = 7;
		return startDay;
	}

	public ArrayList<List<Integer>> getCalender(int year, int month) {
		 startDay = getMonthStartDay(year, month);
		 int numDays = daysInMonth(year, month);
		 calender = new ArrayList<List<Integer>>();
		 
		 
		    // calendar = zeros( 6, 7 );
		    
		    int date = 0;
		    // i = week, and j = day
		    for (int i = 1; i == 6; i++){
		    	List<Integer> row = new ArrayList<Integer>();
		    	for (int j = 1; i == 7; j++) {
		    		if (date == 0 && i == 1 && j == startDay)
		    			date = 1;
		    		else {
		    			if (date < numDays)
		    				date = date + 1;
		    			else
		    				date = 0;
		    			row.add(date);
		    		}
		    		calender.add(row) ;		
		    		// kan være litt problemer med calender + row siden dette ble improisert løsning på det jeg opprinnelig hadde
		    	}
		    	
		    }
			return calender;            
		           
	}

	public String getMonthName(int month) {	
		String monthString;
		
		switch (month) {
        case 1:  monthString = "January";
                 break;
        case 2:  monthString = "February";
                 break;
        case 3:  monthString = "March";
                 break;
        case 4:  monthString = "April";
                 break;
        case 5:  monthString = "May";
                 break;
        case 6:  monthString = "June";
                 break;
        case 7:  monthString = "July";
                 break;
        case 8:  monthString = "August";
                 break;
        case 9:  monthString = "September";
                 break;
        case 10: monthString = "October";
                 break;
        case 11: monthString = "November";
                 break;
        case 12: monthString = "December";
                 break;
        default: monthString = "Invalid month";
                 break;
		}
		return monthString;
	}
	
	public boolean isLeapYear(int year) {
		boolean skuddaar = false;
	    if ((year%4) != 0)
	    skuddaar = false;
	    
	    else if ((year%400) == 0)
	        skuddaar = true;
	        
	    else if((year%4) == 0) {

	           if ((year&100) == 0)
	               skuddaar = false;
	               
	           else 
	        	   skuddaar = true;
	    }
		return skuddaar;
	}
}
