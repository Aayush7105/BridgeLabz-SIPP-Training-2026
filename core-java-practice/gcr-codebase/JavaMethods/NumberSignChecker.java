import java.util.Scanner;

public class NumberSignChecker {
    public static int checkNumberSign(int number) {
        if (number > 0) {
            return 1;
        }
        if (number < 0) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();

        int result = checkNumberSign(number);

        if (result == 1) {
            System.out.println("The number is positive");
        } else if (result == -1) {
            System.out.println("The number is negative");
        } else {
            System.out.println("The number is zero");
        }

        input.close();
    }
}
