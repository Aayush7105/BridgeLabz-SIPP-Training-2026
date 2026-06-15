public class ZaraBonusCalculator {
    public static double[][] generateSalaryAndService() {
        double[][] employeeData = new double[10][2];

        for (int i = 0; i < employeeData.length; i++) {
            employeeData[i][0] = (int) (Math.random() * 90000) + 10000;
            employeeData[i][1] = (int) (Math.random() * 10) + 1;
        }

        return employeeData;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] salaryData = new double[employeeData.length][2];

        for (int i = 0; i < employeeData.length; i++) {
            double salary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusRate = yearsOfService > 5 ? 0.05 : 0.02;
            double bonus = salary * bonusRate;

            salaryData[i][0] = salary + bonus;
            salaryData[i][1] = bonus;
        }

        return salaryData;
    }

    public static double[] calculateTotals(double[][] employeeData, double[][] salaryData) {
        double oldSalaryTotal = 0;
        double newSalaryTotal = 0;
        double bonusTotal = 0;

        for (int i = 0; i < employeeData.length; i++) {
            oldSalaryTotal += employeeData[i][0];
            newSalaryTotal += salaryData[i][0];
            bonusTotal += salaryData[i][1];
        }

        return new double[] { oldSalaryTotal, newSalaryTotal, bonusTotal };
    }

    public static void displaySalaryReport(double[][] employeeData, double[][] salaryData) {
        System.out.println("Employee\tOld Salary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < employeeData.length; i++) {
            System.out.println((i + 1) + "\t\t" + employeeData[i][0] + "\t\t" + employeeData[i][1] + "\t"
                    + salaryData[i][1] + "\t" + salaryData[i][0]);
        }

        double[] totals = calculateTotals(employeeData, salaryData);
        System.out.println("Total old salary is " + totals[0]);
        System.out.println("Total new salary is " + totals[1]);
        System.out.println("Total bonus amount is " + totals[2]);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateSalaryAndService();
        double[][] salaryData = calculateNewSalaryAndBonus(employeeData);

        displaySalaryReport(employeeData, salaryData);
    }
}
