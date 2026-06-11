// Create DigitCounter Class

import java.util.Scanner;

class DigitCounter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        int tempNumber = number;
        int digitCount = 0;

        if (tempNumber == 0) {
            digitCount = 1;
        }

        while (tempNumber != 0) {

            tempNumber = tempNumber / 10;
            digitCount++;
        }

        System.out.println("Number of digits = " + digitCount);

        input.close();
    }
}
