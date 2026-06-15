import java.util.Scanner;

public class RecursiveNaturalNumberSum {
    public static long findSumUsingRecursion(int number) {
        if (number == 1) {
            return 1;
        }
        return number + findSumUsingRecursion(number - 1);
    }

    public static long findSumUsingFormula(int number) {
        return (long) number * (number + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a natural number:");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("The number " + number + " is not a natural number");
        } else {
            long recursiveSum = findSumUsingRecursion(number);
            long formulaSum = findSumUsingFormula(number);

            System.out.println("Sum using recursion is " + recursiveSum);
            System.out.println("Sum using formula is " + formulaSum);
            System.out.println("Both computations are correct: " + (recursiveSum == formulaSum));
        }

        input.close();
    }
}
