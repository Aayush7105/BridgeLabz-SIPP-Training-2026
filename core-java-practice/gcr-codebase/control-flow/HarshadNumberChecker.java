// Create HarshadNumberChecker Class

import java.util.Scanner;

class HarshadNumberChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int tempNumber = number;
        int sumOfDigits = 0;

        while (tempNumber != 0) {

            int digit = tempNumber % 10;

            sumOfDigits += digit;

            tempNumber = tempNumber / 10;
        }

        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }

        input.close();
    }
}
