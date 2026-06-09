public class PCMAverageMarks {
    public static void main(String[] args) {
        String name = "Sam";
        int mathsMark = 94;
        int physicsMark = 95;
        int chemistryMark = 96;
        int numberOfSubjects = 3;
        double averageMark = (mathsMark + physicsMark + chemistryMark) / (double) numberOfSubjects;

        System.out.println(name + "'s average mark in PCM is " + averageMark);
    }
}
