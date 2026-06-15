import java.util.Arrays;
import java.util.Scanner;

public class EuclideanDistanceLine {
    public static double findDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[] { slope, yIntercept };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter x1:");
        double x1 = input.nextDouble();

        System.out.println("Enter y1:");
        double y1 = input.nextDouble();

        System.out.println("Enter x2:");
        double x2 = input.nextDouble();

        System.out.println("Enter y2:");
        double y2 = input.nextDouble();

        double distance = findDistance(x1, y1, x2, y2);

        System.out.println("Euclidean distance is " + distance);
        if (x1 == x2) {
            System.out.println("The line is vertical and has no slope-intercept form");
        } else {
            System.out.println("Slope and y-intercept are " + Arrays.toString(findLineEquation(x1, y1, x2, y2)));
        }

        input.close();
    }
}
