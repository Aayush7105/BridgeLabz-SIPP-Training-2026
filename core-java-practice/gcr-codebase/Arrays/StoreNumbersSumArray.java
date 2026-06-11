import java.util.Scanner;

class StoreNumbersSumArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            if (index == numbers.length) {
                break;
            }

            double value = input.nextDouble();

            if (value <= 0) {
                break;
            }

            numbers[index] = value;
            index++;
        }

        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Total = " + total);

        input.close();
    }
}
