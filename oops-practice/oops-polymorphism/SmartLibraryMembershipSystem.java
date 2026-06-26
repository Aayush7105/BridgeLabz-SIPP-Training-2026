abstract class LibraryMember {

    private final String memberName;
    private final String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void printMemberDetails() {
        System.out.println("Name: " + memberName);
        System.out.println("ID: " + memberId);
        System.out.println("Membership: " + getMembershipType());
    }

    public abstract double calculateFine(int overdueDays);

    protected abstract String getMembershipType();
}

class StudentMember extends LibraryMember {

    StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return Math.max(overdueDays, 0) * 1.0;
    }

    @Override
    protected String getMembershipType() {
        return "Student";
    }
}

class FacultyMember extends LibraryMember {

    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return Math.max(overdueDays, 0) * 0.5;
    }

    @Override
    protected String getMembershipType() {
        return "Faculty";
    }
}

class GuestMember extends LibraryMember {

    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return Math.max(overdueDays, 0) * 2.0;
    }

    @Override
    protected String getMembershipType() {
        return "Guest";
    }
}

public class SmartLibraryMembershipSystem {

    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Aarav", "SM-101"),
            new FacultyMember("Dr. Iyer", "FM-202"),
            new GuestMember("Neha", "GM-303")
        };

        int overdueDays = 6;
        displayMembersAndFines(members, overdueDays);

        String memberIdToFind = "FM-202";
        LibraryMember foundMember = findMemberById(members, memberIdToFind);

        System.out.println("\nSearch result for ID " + memberIdToFind + ":");
        if (foundMember != null) {
            foundMember.printMemberDetails();
        } else {
            System.out.println("No member found.");
        }
    }

    public static void displayMembersAndFines(LibraryMember[] members, int overdueDays) {
        System.out.println("Library members and fines for " + overdueDays + " overdue days:");

        for (LibraryMember member : members) {
            member.printMemberDetails();
            System.out.printf("Fine: Rs. %.2f%n%n", member.calculateFine(overdueDays));
        }
    }

    public static LibraryMember findMemberById(LibraryMember[] members, String memberId) {
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }

        return null;
    }
}
