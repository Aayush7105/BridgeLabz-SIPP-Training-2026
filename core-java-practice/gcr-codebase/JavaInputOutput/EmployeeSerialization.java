
import java.io.*;
import java.util.*;

class Employee implements Serializable {

    int employeeId;
    String name;
    String department;
    double salary;

    Employee(int id, String n, String d, double s) {
        employeeId = id;
        name = n;
        department = d;
        salary = s;
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, dept, salary);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"));
            oos.writeObject(emp);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"));
            Employee e = (Employee) ois.readObject();

            System.out.println("\nRecovered Employee Details");
            System.out.println("ID : " + e.employeeId);
            System.out.println("Name : " + e.name);
            System.out.println("Department : " + e.department);
            System.out.println("Salary : " + e.salary);

            ois.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
