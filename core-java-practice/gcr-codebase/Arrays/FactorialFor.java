import java.util.Scanner;

class FactorialFor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Not a Positive Integer");
        } else {
            int factorial = 1;

            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("Factorial = " + factorial);
        }

        input.close();
    }
}
