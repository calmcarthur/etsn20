// package wb;
// `import java.io.*;`
//`import java.util.*;`

public class NextDateNew {  // Main class to calculate the next date based on the input month, day, and year.
	
	public NextDateNew(int m, int d, int y) {
		// Constructor initializes a `NextDate` object with a month, day, and year
		// However, instance variables `month`, `day`, and `year` are commented out
		// and the constructor does nothing with `m`, `d`, and `y`.
	}
	
	/**
	 * Method: run
	 * Returns: String
	 * Description: Calculates and returns the next date in the format "MM/DD/YYYY".
	 *              Handles month and day boundaries, leap years, and checks input validity.
	 */
	public String run(int month, int day, int year) {
		
		// Checks if input date is within valid range: month [1-12], day [1-31], year [1801-2021].
		if (day < 1 || month < 1 || month > 12 || year < 1801 || year > 2021)
			return "Invalid Input Date";
		
		// Variables to store the next day's month, day, and year.
		int tomorrowDay = day;
		int tomorrowMonth = month;
		int tomorrowYear = year;
		
		// Check if the month has 31 days (except December, handled separately).
		if (isThirtyOneDayMonth(month)) {
			if (day < 31) 
				tomorrowDay = day + 1;  // Increment day if it’s not the last day of the month.
			else {
				// Last day of a 31-day month: set tomorrow's day to 1 and increment month.
				tomorrowDay = 1;
				tomorrowMonth = month + 1;
			}
		}
		// Check if the month has 30 days.
		else if (isThirtyDayMonth(month)) {
			if (day < 30) 
				tomorrowDay = day + 1;  // Increment day within month bounds.
			else {
				if (day == 30) {  
					// Last day of a 30-day month: reset day to 1 and increment month.
					tomorrowDay = 1;
					tomorrowMonth = month + 1;
				} else 
					return "Invalid Input Date";  // Invalid if day > 30 in a 30-day month.
			}
		}
		// Check if the month is December (31-day month with year boundary handling).
		else if (isDecember(month)) {
			if (day < 31) 
				tomorrowDay = day + 1;  // Increment day within month bounds.
			else {  
				// December 31: reset day, set month to January, and increment year.
				tomorrowDay = 1;
				tomorrowMonth = 1;
				if (year == 2021) 
					return "Invalid Next Year";  // Year boundary limit reached.
				else  
					tomorrowYear = year + 1;
			}
		}
		// Check if the month is February with leap year handling.
		else if (isFebruary(month)) {
			if (day < 28) 
				tomorrowDay = day + 1;  // Standard increment for days 1-27.
			else {
				if (day == 28) {  
					// Feb 28: if a leap year, increment to Feb 29, otherwise set to March 1.
					if (isLeapYear(year)) 
						tomorrowDay = 29;
					else {  
						tomorrowDay = 1;
						tomorrowMonth = 3;
					}
				} else if (day == 29) {  
					// Feb 29: valid only if a leap year; otherwise, invalid.
					if (isLeapYear(year)) {
						tomorrowDay = 1;
						tomorrowMonth = 3;
					} else 
						return "Invalid Input Date";
				} else  
					return "Invalid Input Date";  // Day > 29 is invalid for February.
			}
		}
		// Return formatted next date as "MM/DD/YYYY".
		return tomorrowMonth + "/" + tomorrowDay + "/" + tomorrowYear;
	}
	
	/**
	 * Method: isThirtyOneDayMonth
	 * @param month - Month to check.
	 * @returns true if month has 31 days, excluding December.
	 */
	private static boolean isThirtyOneDayMonth(int month) {
		return month == 1 || month == 3 || month == 5 || month == 8 || month == 10;
	}
	
	/**
	 * Method: isThirtyDayMonth
	 * @param month - Month to check.
	 * @returns true if month has 30 days.
	 */
	private static boolean isThirtyDayMonth(int month) {
		return month == 4 || month == 6 || month == 9 || month == 11;
	}
	
	/**
	 * Method: isDecember
	 * @param month - Month to check.
	 * @returns true if month is December.
	 */
	private static boolean isDecember(int month) {
		return month == 12;
	}
	
	/**
	 * Method: isFebruary
	 * @param month - Month to check.
	 * @returns true if month is February.
	 */
	private static boolean isFebruary(int month) {
		return month == 2;
	}
	
	/**
	 * Method: isLeapYear
	 * @param year - Year to check.
	 * @returns true if the year is a leap year:
	 *          - A non-century year divisible by 4 is a leap year.
	 *          - A century year is a leap year only if divisible by 400.
	 */
	private static boolean isLeapYear(int year) {
		if ((year % 100) == 0)
			return (year % 400) == 0;
		else
			return (year % 4) == 0;
	}
	
	/**
	 * Main method for testing: accepts month, day, and year as command-line arguments
	 * to create a NextDate object and print the next date.
	 */
	public static void main(String[] args) {
		NextDateNew q;
		int month1, day1, year1;
		
		// Parses command-line arguments for month, day, and year, creating a NextDate object.
		q = new NextDateNew(
				month1 = Integer.parseInt(args[0]),
				day1 = Integer.parseInt(args[1]),
				year1 = Integer.parseInt(args[2]));
		
		// Prints the result of the run method, which calculates the next date.
		System.out.println("Type: " + q.run(month1, day1, year1));
	}
}

