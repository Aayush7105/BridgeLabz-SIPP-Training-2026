public class FixedKilometerToMiles {
    public static void main(String[] args) {
        double distanceInKilometers = 10.8;
        double kilometersPerMile = 1.6;
        double distanceInMiles = distanceInKilometers / kilometersPerMile;

        System.out.println("The distance " + distanceInKilometers + " km in miles is " + distanceInMiles);
    }
}
