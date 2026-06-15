import java.util.Scanner;

public class UnitConvertor {
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static double convertFarhenheitToCelsius(double farhenheit) {
        return (farhenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter kilometers:");
        double km = input.nextDouble();
        System.out.println(km + " km = " + convertKmToMiles(km) + " miles");

        System.out.println("Enter miles:");
        double miles = input.nextDouble();
        System.out.println(miles + " miles = " + convertMilesToKm(miles) + " km");

        System.out.println("Enter meters:");
        double meters = input.nextDouble();
        System.out.println(meters + " meters = " + convertMetersToFeet(meters) + " feet");
        System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");

        System.out.println("Enter feet:");
        double feet = input.nextDouble();
        System.out.println(feet + " feet = " + convertFeetToMeters(feet) + " meters");
        System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");

        System.out.println("Enter yards:");
        double yards = input.nextDouble();
        System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");

        System.out.println("Enter inches:");
        double inches = input.nextDouble();
        System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");
        System.out.println(inches + " inches = " + convertInchesToCentimeters(inches) + " centimeters");

        System.out.println("Enter Farhenheit:");
        double farhenheit = input.nextDouble();
        System.out.println(farhenheit + " Farhenheit = " + convertFarhenheitToCelsius(farhenheit) + " Celsius");

        System.out.println("Enter Celsius:");
        double celsius = input.nextDouble();
        System.out.println(celsius + " Celsius = " + convertCelsiusToFarhenheit(celsius) + " Farhenheit");

        System.out.println("Enter pounds:");
        double pounds = input.nextDouble();
        System.out.println(pounds + " pounds = " + convertPoundsToKilograms(pounds) + " kilograms");

        System.out.println("Enter kilograms:");
        double kilograms = input.nextDouble();
        System.out.println(kilograms + " kilograms = " + convertKilogramsToPounds(kilograms) + " pounds");

        System.out.println("Enter gallons:");
        double gallons = input.nextDouble();
        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");

        System.out.println("Enter liters:");
        double liters = input.nextDouble();
        System.out.println(liters + " liters = " + convertLitersToGallons(liters) + " gallons");

        input.close();
    }
}
