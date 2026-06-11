import java.util.Scanner;

class FirstSmallestChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();

        System.out.println("Is the first number the smallest? " + (number1 < number2 && number1 < number3));

        input.close();
    }
}
