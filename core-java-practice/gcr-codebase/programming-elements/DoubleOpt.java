import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter value of a:");
        double a = input.nextDouble();

        System.out.println("Enter value of b:");
        double b = input.nextDouble();

        System.out.println("Enter value of c:");
        double c = input.nextDouble();

        double operation1 = a + b * c;
        double operation2 = a * b + c;
        double operation3 = c + a / b;
        double operation4 = a % b + c;

        System.out.println("The results of Double Operations are " + operation1 + ", " + operation2
                + ", " + operation3 + ", and " + operation4);

        input.close();
    }
}
