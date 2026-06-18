import java.util.Scanner;

public class EmployeeSkillAssignment {

    static void findTeams(int[] skills, int index, int target, int[] team, int teamSize) {
        if (target == 0) {
            System.out.print("[");
            for (int i = 0; i < teamSize; i++) {
                System.out.print(team[i]);
                if (i < teamSize - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
            return;
        }
        if (index == skills.length || target < 0) {
            return;
        }
        team[teamSize] = skills[index];
        findTeams(skills, index + 1, target - skills[index], team, teamSize + 1);
        findTeams(skills, index + 1, target, team, teamSize);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] skills = new int[n];
        for (int i = 0; i < n; i++) {
            skills[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] team = new int[n];
        findTeams(skills, 0, target, team, 0);
        sc.close();
    }
}
