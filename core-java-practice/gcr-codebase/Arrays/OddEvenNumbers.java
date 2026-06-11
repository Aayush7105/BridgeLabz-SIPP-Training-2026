import java.util.Scanner;

class OddEvenNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Not a Natural Number");
        } else {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even Number");
                } else {
                    System.out.println(i + " is an Odd Number");
                }
            }
        }

        input.close();
    }
}
