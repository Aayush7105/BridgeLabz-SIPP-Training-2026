import java.util.Scanner;

public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        return year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter year:");
        int year = input.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }

        input.close();
    }
}
