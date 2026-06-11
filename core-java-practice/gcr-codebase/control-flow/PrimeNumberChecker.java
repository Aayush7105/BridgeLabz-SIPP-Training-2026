// Create PrimeNumberChecker Class to check whether a number is prime

import java.util.Scanner;

class PrimeNumberChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {

            for (int divisor = 2; divisor < number; divisor++) {

                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }

        input.close();
    }
}
