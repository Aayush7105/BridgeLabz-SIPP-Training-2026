import java.util.Scanner;

public class NaturalNumberSum {
    public static int calculateNaturalNumberSum(int number) {
        int sum = 0;

        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        int number = input.nextInt();

        if (number > 0) {
            int sum = calculateNaturalNumberSum(number);
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }

        input.close();
    }
}
