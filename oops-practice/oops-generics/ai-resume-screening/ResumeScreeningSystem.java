
import java.util.ArrayList;
import java.util.List;

public class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumes;

    public ResumeScreeningSystem() {
        resumes = new ArrayList<>();
    }

    public void addResume(Resume<? extends JobRole> resume) {
        resumes.add(resume);
    }

    public void screenAllResumes() {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println("Screening: " + resume);
        }
    }

    public static void main(String[] args) {
        ResumeScreeningSystem system = new ResumeScreeningSystem();

        Resume<SoftwareEngineer> seResume = new Resume<>("John Doe", 5, new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Jane Smith", 3, new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Bob Johnson", 8, new ProductManager());

        system.addResume(seResume);
        system.addResume(dsResume);
        system.addResume(pmResume);

        system.screenAllResumes();
    }
}
