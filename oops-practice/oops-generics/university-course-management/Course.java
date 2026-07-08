
public class Course<T extends CourseType> {
    private String courseCode;
    private String courseName;
    private T evaluationType;

    public Course(String courseCode, String courseName, T evaluationType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.evaluationType = evaluationType;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getEvaluationType() {
        return evaluationType;
    }

    @Override
    public String toString() {
        return "Course{code='" + courseCode + "', name='" + courseName + "', type='" + evaluationType.getTypeName() + "'}";
    }
}
