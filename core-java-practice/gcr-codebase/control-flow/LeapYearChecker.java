
import java.util.Scanner;

class LeapYearChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int year = input.nextInt();

        if (year < 1582) {

            System.out.println("Leap Year calculation works only for years 1582 and above.");

        } else {

            if (year % 400 == 0) {

                System.out.println(year + " is a Leap Year");

            } else if (year % 100 == 0) {

                System.out.println(year + " is not a Leap Year");

            } else if (year % 4 == 0) {

                System.out.println(year + " is a Leap Year");

            } else {

                System.out.println(year + " is not a Leap Year");
            }
        }

        // Close Scanner Stream
        input.close();
    }
}
