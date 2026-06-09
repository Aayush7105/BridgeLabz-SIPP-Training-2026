public class EarthVolume {
    public static void main(String[] args) {
        double earthRadiusInKilometers = 6378;
        double kilometersPerMile = 1.6;
        double sphereVolumeFactor = 4.0 / 3.0;
        double earthVolumeInCubicKilometers = sphereVolumeFactor * Math.PI
                * Math.pow(earthRadiusInKilometers, 3);
        double earthVolumeInCubicMiles = earthVolumeInCubicKilometers / Math.pow(kilometersPerMile, 3);

        System.out.println("The volume of earth in cubic kilometers is "
                + earthVolumeInCubicKilometers + " and cubic miles is " + earthVolumeInCubicMiles);
    }
}
