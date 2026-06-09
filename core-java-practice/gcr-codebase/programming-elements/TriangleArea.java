import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter base of triangle in cm:");
        double base = input.nextDouble();

        System.out.println("Enter height of triangle in cm:");
        double height = input.nextDouble();

        double half = 0.5;
        double centimetersPerInch = 2.54;
        double areaInSquareCentimeters = half * base * height;
        double areaInSquareInches = areaInSquareCentimeters / (centimetersPerInch * centimetersPerInch);

        System.out.println("The Area of the triangle in sq in is " + areaInSquareInches
                + " and sq cm is " + areaInSquareCentimeters);

        input.close();
    }
}
