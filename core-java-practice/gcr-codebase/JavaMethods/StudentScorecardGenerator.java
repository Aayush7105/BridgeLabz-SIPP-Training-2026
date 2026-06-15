import java.util.Scanner;

public class StudentScorecardGenerator {
    public static int[][] generateScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = (int) (Math.random() * 90) + 10;
            }
        }

        return scores;
    }

    public static double roundToTwoDigits(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static double[][] calculateScoreDetails(int[][] scores) {
        double[][] scoreDetails = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total / 300.0 * 100;

            scoreDetails[i][0] = total;
            scoreDetails[i][1] = roundToTwoDigits(average);
            scoreDetails[i][2] = roundToTwoDigits(percentage);
        }

        return scoreDetails;
    }

    public static void displayScorecard(int[][] scores, double[][] scoreDetails) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2]
                    + "\t" + scoreDetails[i][0] + "\t" + scoreDetails[i][1] + "\t" + scoreDetails[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int numberOfStudents = input.nextInt();

        int[][] scores = generateScores(numberOfStudents);
        double[][] scoreDetails = calculateScoreDetails(scores);

        displayScorecard(scores, scoreDetails);

        input.close();
    }
}
