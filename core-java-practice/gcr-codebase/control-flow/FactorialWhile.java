import java.util.Scanner;

class FactorialWhile {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Not a Positive Integer");
        } else {
            int factorial = 1;
            int counter = 1;

            while (counter <= number) {
                factorial *= counter;
                counter++;
            }

            System.out.println("Factorial = " + factorial);
        }

        input.close();
    }
}
