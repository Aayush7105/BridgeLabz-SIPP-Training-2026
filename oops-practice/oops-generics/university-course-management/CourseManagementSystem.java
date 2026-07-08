
import java.util.ArrayList;
import java.util.List;

public class CourseManagementSystem {
    private List<Course<? extends CourseType>> courses;

    public CourseManagementSystem() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayAllCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        CourseManagementSystem system = new CourseManagementSystem();

        Course<ExamCourse> mathCourse = new Course<>("MATH101", "Calculus I", new ExamCourse());
        Course<AssignmentCourse> engCourse = new Course<>("ENG202", "Creative Writing", new AssignmentCourse());
        Course<ResearchCourse> compCourse = new Course<>("CS400", "Machine Learning Research", new ResearchCourse());

        system.addCourse(mathCourse);
        system.addCourse(engCourse);
        system.addCourse(compCourse);

        system.displayAllCourses();
    }
}
