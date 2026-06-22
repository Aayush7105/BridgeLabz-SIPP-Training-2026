class Employee {

    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: Rs. " + salary);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Rahul Sharma", 101, 45000);
        employee.displayDetails();
    }
}
