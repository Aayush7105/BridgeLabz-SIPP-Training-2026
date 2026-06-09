import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter perimeter of square:");
        double perimeter = input.nextDouble();

        int numberOfSides = 4;
        double side = perimeter / numberOfSides;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        input.close();
    }
}
