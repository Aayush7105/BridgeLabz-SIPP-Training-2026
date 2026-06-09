import java.util.Scanner;

public class KilometerToMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter distance in kilometers:");
        double kilometers = input.nextDouble();

        double kilometersPerMile = 1.6;
        double miles = kilometers / kilometersPerMile;

        System.out.println("The total miles is " + miles + " mile for the given " + kilometers + " km");

        input.close();
    }
}
