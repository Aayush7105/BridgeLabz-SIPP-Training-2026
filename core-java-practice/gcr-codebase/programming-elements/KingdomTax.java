
import java.util.*;

public class KingdomTax {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double[] citizenIncome = new double[10];
        double totalTax = 0.0;
        double[] citizenTax = new double[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter income of Citizen " + (i + 1) + ":");
            double income = sc.nextDouble();
            citizenIncome[i] = income;
            citizenTax[i] = taxCal(income);
            totalTax += citizenTax[i];

        }
        System.out.printf("Total tax collected: %.2f", totalTax);
    }

    public static Double taxCal(Double income) {
        double tax = 0.0;
        if (income < 10000) {
            tax += income * 0.5;
        } else if (income > 10000 && income < 50000) {
            tax += income * 0.15;
        } else {
            tax += income * 0.30;
        }
        return tax;
    }
}
