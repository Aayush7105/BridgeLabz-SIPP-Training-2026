import java.util.Arrays;
import java.util.Scanner;

public class Quadratic {
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[] { root1, root2 };
        }
        if (delta == 0) {
            return new double[] { -b / (2 * a) };
        }
        return new double[0];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a:");
        double a = input.nextDouble();

        System.out.println("Enter b:");
        double b = input.nextDouble();

        System.out.println("Enter c:");
        double c = input.nextDouble();

        if (a == 0) {
            System.out.println("The value of a cannot be zero");
        } else {
            double[] roots = findRoots(a, b, c);
            if (roots.length == 0) {
                System.out.println("The equation has no real roots");
            } else {
                System.out.println("Roots are " + Arrays.toString(roots));
            }
        }

        input.close();
    }
}
