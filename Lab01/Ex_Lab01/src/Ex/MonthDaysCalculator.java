package Ex;
import java.util.Scanner;

public class MonthDaysCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the month input from the user (full name, abbreviation, 3 letters, or number).
        String[] months = {
            "January", "Jan.", "Jan", "1", "February", "Feb.", "Feb", "2",
            "March", "Mar.", "Mar", "3", "April", "Apr.", "Apr", "4",
            "May", "5", "June", "Jun", "6", "July", "Jul", "7",
            "August", "Aug.", "Aug", "8", "September", "Sep.", "Sep", "9",
            "October", "Oct.", "Oct", "10", "November", "Nov.", "Nov", "11",
            "December", "Dec.", "Dec", "12"
        };

        String monthInput;
        int monthNumber = 0;

        while (true) {
            System.out.print("Enter the month: ");
            monthInput = scanner.nextLine();

            boolean isValidMonth = false;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equalsIgnoreCase(monthInput)) {
                    monthNumber = Integer.parseInt(months[i + 1]);
                    isValidMonth = true;
                    break;
                }
            }

            if (isValidMonth && monthNumber >= 1 && monthNumber <= 12) {
                break;
            } else {
                System.out.println("Invalid month input. Please enter a valid month.");
            }
        }

        // Get the year input from the user (non-negative number with all digits).
        int year;
        while (true) {
            System.out.print("Enter the year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) {
                    break;
                }
            }
            scanner.nextLine(); // Clear the input buffer
            System.out.println("Invalid year input. Please enter a non-negative year.");
        }

        scanner.close();

        // Check if it's a leap year
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Define the number of days in each month
        int[] daysInMonth = {
            31, (isLeapYear ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        // Display the number of days in the entered month
        int days = daysInMonth[monthNumber - 1];
        String monthName = months[(monthNumber - 1) * 4];
        System.out.println("There are " + days + " days in " + monthName + " " + year + ".");
    }
}
