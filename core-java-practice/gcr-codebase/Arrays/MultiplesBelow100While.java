import java.util.Scanner;

class MultiplesBelow100While {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid Number");
        } else {
            int counter = 99;

            while (counter >= 1) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }

                counter--;
            }
        }

        input.close();
    }
}
