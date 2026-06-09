import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter distance in feet:");
        double distanceInFeet = input.nextDouble();

        int feetPerYard = 3;
        int yardsPerMile = 1760;
        int feetPerMile = feetPerYard * yardsPerMile;
        double distanceInYards = distanceInFeet / feetPerYard;
        double distanceInMiles = distanceInFeet / feetPerMile;

        System.out.println("The distance in yards is " + distanceInYards
                + " while the distance in miles is " + distanceInMiles);

        input.close();
    }
}
