import java.util.Scanner;

class MultiplesBelow100 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid Number");
        } else {
            for (int i = 99; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        }

        input.close();
    }
}
