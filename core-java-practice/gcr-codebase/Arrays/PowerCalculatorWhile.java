import java.util.Scanner;

class PowerCalculatorWhile {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int power = input.nextInt();

        if (number <= 0 || power < 0) {
            System.out.println("Invalid Input");
        } else {
            int result = 1;
            int counter = 0;

            while (counter < power) {
                result *= number;
                counter++;
            }

            System.out.println(result);
        }

        input.close();
    }
}
