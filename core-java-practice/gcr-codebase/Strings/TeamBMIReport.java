import java.util.Scanner;

public class TeamBMIReport {

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25) {
            return "Normal";
        }
        if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    public static String[] calculateBMIAndStatus(double weight, double heightCm) {
        double heightMeters = heightCm / 100.0;
        double bmi = weight / (heightMeters * heightMeters);

        return new String[]{
                String.format("%.2f", bmi),
                getBMIStatus(bmi)
        };
    }

    public static String[][] createBMIReport(double[][] heightAndWeight) {
        String[][] report = new String[heightAndWeight.length][4];

        for (int i = 0; i < heightAndWeight.length; i++) {
            double weight = heightAndWeight[i][0];
            double height = heightAndWeight[i][1];
            String[] bmiDetails = calculateBMIAndStatus(weight, height);

            report[i][0] = String.format("%.2f", height);
            report[i][1] = String.format("%.2f", weight);
            report[i][2] = bmiDetails[0];
            report[i][3] = bmiDetails[1];
        }
        return report;
    }

    public static void displayBMIReport(String[][] report) {
        System.out.printf("%-8s %-12s %-12s %-10s %-15s%n", "Person", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < report.length; i++) {
            System.out.printf("%-8d %-12s %-12s %-10s %-15s%n",
                    i + 1, report[i][0], report[i][1], report[i][2], report[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] heightAndWeight = new double[10][2];

        for (int i = 0; i < heightAndWeight.length; i++) {
            System.out.println("Enter details for person " + (i + 1));
            System.out.print("Weight in kg: ");
            heightAndWeight[i][0] = scanner.nextDouble();
            System.out.print("Height in cm: ");
            heightAndWeight[i][1] = scanner.nextDouble();
        }

        displayBMIReport(createBMIReport(heightAndWeight));
    }
}
