import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generateRandomScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = 10 + (int) (Math.random() * 90);
            }
        }
        return scores;
    }

    public static double[][] calculateTotalsAndPercentages(int[][] scores) {
        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;

            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    public static String[] calculateGrades(double[][] totalsAndPercentages) {
        String[] grades = new String[totalsAndPercentages.length];

        for (int i = 0; i < totalsAndPercentages.length; i++) {
            double percentage = totalsAndPercentages[i][2];
            if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else if (percentage >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "F";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] totalsAndPercentages, String[] grades) {
        System.out.printf("%-8s %-10s %-10s %-10s %-10s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-8d %-10d %-10d %-10d %-10.2f %-10.2f %-12.2f %-8s%n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    totalsAndPercentages[i][0], totalsAndPercentages[i][1],
                    totalsAndPercentages[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[][] scores = generateRandomScores(numberOfStudents);
        double[][] totalsAndPercentages = calculateTotalsAndPercentages(scores);
        String[] grades = calculateGrades(totalsAndPercentages);
        displayScorecard(scores, totalsAndPercentages, grades);
    }
}
