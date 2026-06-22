// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class student {

    String name;
    int rollNumber;
    double marks;

    public student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    void displayDetails() {
        System.out.println("Name: " + name + " Roll Number: " + rollNumber + " Marks: " + marks);
    }

    static void displayAll(student[] s) {
        for (student i : s) {
            System.out.println("Name: " + i.name + " Roll Number: " + i.rollNumber + " Marks: " + i.marks);
        }
    }
}

class Main {

    public static void main(String[] args) {
        student s1 = new student("Advay Sharma", 21, 80.8);
        student s2 = new student("Adsdvay Sharma", 21, 80.8);
        student s3 = new student("sdf Sharma", 21, 80.8);
        student s4 = new student("sdfdsf Sharma", 21, 80.8);
        student s5 = new student("fdaf Sharma", 21, 80.8);
        student[] s = {s1, s2, s3, s4, s5};
        student.displayAll(s);
        // s1.displayDetails();
    }
}
