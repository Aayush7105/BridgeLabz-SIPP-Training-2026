
import java.util.*;

public class task1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name:");
        String name = sc.nextLine();
        System.out.println("Enter Your Age:");
        int age = sc.nextInt();
        System.out.println("Enter Your Rank:");
        int rank = sc.nextInt();
        System.out.println("Enter Your Salary:");
        double salary = sc.nextDouble();
        System.out.println("Enter Your Membership Fee:");
        float membershipFee = sc.nextFloat();
        System.err.println();
        double bonus = (0.12) * salary;
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Rank:" + rank);
        System.out.printf("Salary:" + salary);
        System.out.println("Membership Fee" + membershipFee);
        System.out.println("Bonus" + bonus);

    }
}
