
import java.util.Scanner;

class LeapYearCheckerSingleCondition {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int year = input.nextInt();

        if (year < 1582) {

            System.out.println("Leap Year calculation works only for years 1582 and above.");

        } else {

            boolean isLeapYear
                    = (year % 400 == 0)
                    || ((year % 4 == 0) && (year % 100 != 0));

            // Display result
            if (isLeapYear) {
                System.out.println(year + " is a Leap Year");
            } else {
                System.out.println(year + " is not a Leap Year");
            }
        }
        input.close();
    }
}
