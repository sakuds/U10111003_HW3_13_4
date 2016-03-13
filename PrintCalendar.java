import java.util.Scanner;
import java.util.Calendar;  
import java.util.GregorianCalendar;  

public class PrintCalendar {
	// Main method
	public static void main(String[] args) {
		// Create a Scanner object
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter year and month
		System.out.print("Enter full year (e.g., 2001) and month in number between 1 and 12: ");
		int year = input.nextInt();
		int month = input.nextInt();

		// Print calendar for the month of the year
		printMonth(year, month);
	}

	// Print the calendar for a month in a year
	public static void printMonth(int year, int month) {

		// Print the headings of the calendar
		printMonthTitle(year, month);

		// Print the body of the calendar
		printMonthBody(year, month);
	}

	// Print the month title
	public static void printMonthTitle(int year, int month) {
		System.out.println("         " + getMonthName(month)+ " " + year);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	// Get the English name for the month
	public static String getMonthName(int month) {
		String monthName = "";
		switch (month) {
			case 1: monthName = "January"; break;
			case 2: monthName = "February"; break;
			case 3: monthName = "March"; break;
			case 4: monthName = "April"; break;
			case 5: monthName = "May"; break;
			case 6: monthName = "June"; break;
			case 7: monthName = "July"; break;
			case 8: monthName = "August"; break;
			case 9: monthName = "September"; break;
			case 10: monthName = "October"; break;
			case 11: monthName = "November"; break;
			case 12: monthName = "December";
		}

		return monthName;
	}

	// Print month body
	public static void printMonthBody(int year, int month) {
		// Create GregorianCalendar object named calendar
		Calendar calendar = new GregorianCalendar(year,month-1,1);

		// Get start day of the week for the first date in the month
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);

		// Get number of days in the month
		int numberOfDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		// Pad space before the first day of the month
		int i = 0;
		for (i = 1; i < startDay; i++)
			System.out.print("    ");

		for (i = 1; i <= numberOfDaysInMonth; i++) {
			System.out.printf("%4d", i);

			if ((i + startDay-1 ) % 7 == 0)
				System.out.println();
		}

		System.out.println();
	}
}
