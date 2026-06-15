import java.util.Scanner;

public class WindChillCalculator {
    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter temperature:");
        double temperature = input.nextDouble();

        System.out.println("Enter wind speed:");
        double windSpeed = input.nextDouble();

        WindChillCalculator calculator = new WindChillCalculator();
        double windChill = calculator.calculateWindChill(temperature, windSpeed);

        System.out.println("The wind chill temperature is " + windChill);

        input.close();
    }
}
