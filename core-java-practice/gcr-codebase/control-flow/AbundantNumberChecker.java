import java.util.Scanner;

class AbundantNumberChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int sumOfDivisors = 0;

        for (int divisor = 1; divisor < number; divisor++) {

            if (number % divisor == 0) {
                sumOfDivisors += divisor;
            }
        }

        if (sumOfDivisors > number) {
            System.out.println("Abundant Number");
        } else {
            System.out.println("Not an Abundant Number");
        }

        input.close();
    }
}
