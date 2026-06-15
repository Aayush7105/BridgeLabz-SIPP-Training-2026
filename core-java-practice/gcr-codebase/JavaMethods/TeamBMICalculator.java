import java.util.Scanner;

public class TeamBMICalculator {
    public static double[][] calculateBMI(double[][] personData) {
        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][0];
            double heightInMeters = personData[i][1] / 100;
            personData[i][2] = weight / (heightInMeters * heightInMeters);
        }
        return personData;
    }

    public static String[] findBMIStatus(double[][] personData) {
        String[] status = new String[personData.length];

        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void displayBMIReport(double[][] personData, String[] status) {
        System.out.println("Person\tWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < personData.length; i++) {
            System.out.println((i + 1) + "\t" + personData[i][0] + "\t" + personData[i][1] + "\t"
                    + Math.round(personData[i][2] * 100.0) / 100.0 + "\t" + status[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] personData = new double[10][3];

        for (int i = 0; i < personData.length; i++) {
            System.out.println("Enter weight in kg for person " + (i + 1) + ":");
            personData[i][0] = input.nextDouble();

            System.out.println("Enter height in cm for person " + (i + 1) + ":");
            personData[i][1] = input.nextDouble();
        }

        calculateBMI(personData);
        String[] status = findBMIStatus(personData);
        displayBMIReport(personData, status);

        input.close();
    }
}
