class Person {

    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Age: " + getAge();
    }
}

class Student extends Person {

    private final String studentId;
    private final double gpa;

    Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + getStudentId() + ", GPA: " + getGpa();
    }
}

class GradStudent extends Student {

    private final String thesis;

    GradStudent(String name, int age, String studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: " + getThesis();
    }
}

public class UniversitySystem {

    public static void main(String[] args) {
        GradStudent gradStudent = new GradStudent(
            "Aarav Sharma",
            24,
            "GS-102",
            9.2,
            "Machine Learning in Healthcare"
        );

        System.out.println(gradStudent);
        System.out.println("GradStudent IS-A Student: " + (gradStudent instanceof Student));
        System.out.println("Student IS-A Person: " + (gradStudent instanceof Person));
    }
}
