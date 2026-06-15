import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int remainder = number % divisor;
        int quotient = number / divisor;
        return new int[] { remainder, quotient };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of chocolates:");
        int numberOfChocolates = input.nextInt();

        System.out.println("Enter number of children:");
        int numberOfChildren = input.nextInt();

        if (numberOfChildren == 0) {
            System.out.println("Number of children cannot be zero");
        } else {
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
            System.out.println("Each child gets " + result[1] + " chocolates and the remaining chocolates are "
                    + result[0]);
        }

        input.close();
    }
}
