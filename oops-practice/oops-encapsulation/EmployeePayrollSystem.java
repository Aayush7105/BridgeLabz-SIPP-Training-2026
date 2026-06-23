abstract class Employee {

    private int employeeId;
    private String employeeName;

    Employee(int employeeId, String employeeName) {
        setEmployeeId(employeeId);
        setEmployeeName(employeeName);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Employee Name: " + getEmployeeName());
    }
}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    FullTimeEmployee(int employeeId, String employeeName, double monthlySalary) {
        super(employeeId, employeeName);
        setMonthlySalary(monthlySalary);
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return getMonthlySalary();
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(int employeeId, String employeeName, int hoursWorked, double hourlyRate) {
        super(employeeId, employeeName);
        setHoursWorked(hoursWorked);
        setHourlyRate(hourlyRate);
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getHoursWorked() * getHourlyRate();
    }
}

public class EmployeePayrollSystem {

    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(101, "Aarav Sharma", 50000);
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(102, "Meera Iyer", 80, 450);

        fullTimeEmployee.displayEmployeeInfo();
        System.out.printf("Calculated Salary: %.2f%n%n", fullTimeEmployee.calculateSalary());

        partTimeEmployee.displayEmployeeInfo();
        System.out.printf("Calculated Salary: %.2f%n", partTimeEmployee.calculateSalary());
    }
}
