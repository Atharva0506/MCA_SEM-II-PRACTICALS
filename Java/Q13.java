class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

// MyDate Class
class MyDate {
    private int day;
    private int month;
    private int year;

    // Constructor to initialize date
    public MyDate(int day, int month, int year) throws InvalidDateException {
        if (!isValidDate(day, month, year)) {
            throw new InvalidDateException("Invalid Date: " + day + "-" + month + "-" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Method to check if the date is valid
    private boolean isValidDate(int day, int month, int year) {
        // Check month range
        if (month < 1 || month > 12) return false;

        // Days in each month
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check for leap year
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        // Check day range
        return day >= 1 && day <= daysInMonth[month];
    }

    // Method to check leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to display the date
    public void displayDate() {
        System.out.println("Date: " + day + "-" + month + "-" + year);
    }
}

// Main Class
public class Q13 {
    public static void main(String[] args) {
        try {
            MyDate date1 = new MyDate(29, 2, 2021); // Invalid date (2021 is not a leap year)
            date1.displayDate();
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }

        try {
            MyDate date2 = new MyDate(31, 6, 2000); // Invalid date (June has 30 days)
            date2.displayDate();
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }

        try {
            MyDate date3 = new MyDate(15, 3, 2019); // Valid date
            date3.displayDate();
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
    }
}
