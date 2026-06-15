import java.util.Scanner;

public class QuotientAndRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int remainder = number % divisor;
        int quotient = number / divisor;
        return new int[] { remainder, quotient };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number:");
        int number = input.nextInt();

        System.out.println("Enter divisor:");
        int divisor = input.nextInt();

        if (divisor == 0) {
            System.out.println("Divisor cannot be zero");
        } else {
            int[] result = findRemainderAndQuotient(number, divisor);
            System.out.println("The quotient is " + result[1] + " and the remainder is " + result[0]);
        }

        input.close();
    }
}
