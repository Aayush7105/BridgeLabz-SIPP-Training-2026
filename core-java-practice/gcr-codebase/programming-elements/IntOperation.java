import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter value of a:");
        int a = input.nextInt();

        System.out.println("Enter value of b:");
        int b = input.nextInt();

        System.out.println("Enter value of c:");
        int c = input.nextInt();

        int operation1 = a + b * c;
        int operation2 = a * b + c;
        int operation3 = c + a / b;
        int operation4 = a % b + c;

        System.out.println("The results of Int Operations are " + operation1 + ", " + operation2
                + ", " + operation3 + ", and " + operation4);

        input.close();
    }
}
