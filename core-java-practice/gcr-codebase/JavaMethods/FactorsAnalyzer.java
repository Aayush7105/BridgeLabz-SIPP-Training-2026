import java.util.Arrays;
import java.util.Scanner;

public class FactorsAnalyzer {
    public static int[] findFactors(int number) {
        number = Math.abs(number);

        if (number == 0) {
            return new int[0];
        }

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    public static int findSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long findProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double findSumOfSquares(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = input.nextInt();

        int[] factors = findFactors(number);

        if (factors.length == 0) {
            System.out.println("Zero has infinitely many factors");
        } else {
            System.out.println("Factors are " + Arrays.toString(factors));
            System.out.println("Sum of factors is " + findSum(factors));
            System.out.println("Product of factors is " + findProduct(factors));
            System.out.println("Sum of squares of factors is " + findSumOfSquares(factors));
        }

        input.close();
    }
}
