
public class Resume<T extends JobRole> {
    private String candidateName;
    private int experienceYears;
    private T jobRole;

    public Resume(String candidateName, int experienceYears, T jobRole) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Resume{candidate='" + candidateName + "', experience=" + experienceYears + " years, role=" + jobRole.getRoleName() + "}";
    }
}
