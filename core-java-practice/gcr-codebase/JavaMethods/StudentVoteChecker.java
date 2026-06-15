import java.util.Scanner;

public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.println("Enter age of student " + (i + 1) + ":");
            ages[i] = input.nextInt();
        }

        for (int i = 0; i < ages.length; i++) {
            if (checker.canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " can vote");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote");
            }
        }

        input.close();
    }
}
