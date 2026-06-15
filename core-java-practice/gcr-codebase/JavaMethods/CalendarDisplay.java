import java.util.Scanner;

public class CalendarDisplay {
    public static String getMonthName(int month) {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    public static int getNumberOfDays(int month, int year) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + (31 * m) / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int firstDay = getFirstDayOfMonth(month, year);
        int numberOfDays = getNumberOfDays(month, year);

        System.out.println(getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter month:");
        int month = input.nextInt();

        System.out.println("Enter year:");
        int year = input.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
        } else {
            displayCalendar(month, year);
        }

        input.close();
    }
}
