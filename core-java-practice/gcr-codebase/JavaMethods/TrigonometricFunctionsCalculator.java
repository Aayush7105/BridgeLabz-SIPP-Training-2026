import java.util.Scanner;

public class TrigonometricFunctionsCalculator {
    public double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[] { sine, cosine, tangent };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter angle in degrees:");
        double angle = input.nextDouble();

        TrigonometricFunctionsCalculator calculator = new TrigonometricFunctionsCalculator();
        double[] result = calculator.calculateTrigonometricFunctions(angle);

        System.out.println("Sine is " + result[0]);
        System.out.println("Cosine is " + result[1]);
        System.out.println("Tangent is " + result[2]);

        input.close();
    }
}
