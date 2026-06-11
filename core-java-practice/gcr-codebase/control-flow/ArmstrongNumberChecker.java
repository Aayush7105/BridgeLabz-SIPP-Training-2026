// Create ArmstrongNumberChecker Class

import java.util.Scanner;

class ArmstrongNumberChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int originalNumber = number;
        int sumOfCubes = 0;

        while (originalNumber != 0) {

            int digit = originalNumber % 10;

            sumOfCubes += digit * digit * digit;

            originalNumber = originalNumber / 10;
        }

        if (sumOfCubes == number) {
            System.out.println(number + " is an Armstrong Number");
        } else {
            System.out.println(number + " is not an Armstrong Number");
        }

        input.close();
    }
}
