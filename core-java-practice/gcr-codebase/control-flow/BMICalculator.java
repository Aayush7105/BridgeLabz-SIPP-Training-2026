
import java.util.Scanner;

class BMICalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double weightInKg = input.nextDouble();
        double heightInCm = input.nextDouble();

        double heightInMeter = heightInCm / 100;

        double bodyMassIndex
                = weightInKg / (heightInMeter * heightInMeter);

        String weightStatus;

        if (bodyMassIndex < 18.5) {
            weightStatus = "Underweight";
        } else if (bodyMassIndex < 25) {
            weightStatus = "Normal Weight";
        } else if (bodyMassIndex < 30) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obese";
        }

        // Display result
        System.out.println("BMI = " + bodyMassIndex);
        System.out.println("Weight Status = " + weightStatus);

        input.close();
    }
}
