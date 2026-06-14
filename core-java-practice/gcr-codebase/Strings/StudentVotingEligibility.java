import java.util.Scanner;

public class StudentVotingEligibility {

    public static int[] generateRandomAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        for (int i = 0; i < ages.length; i++) {
            ages[i] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = String.valueOf(ages[i] >= 18);
        }
        return result;
    }

    public static void displayTable(String[][] votingEligibility) {
        System.out.printf("%-10s %-15s%n", "Age", "Can Vote");
        for (String[] row : votingEligibility) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[] ages = generateRandomAges(numberOfStudents);
        displayTable(checkVotingEligibility(ages));
    }
}
