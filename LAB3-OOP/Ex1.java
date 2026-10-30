import java.util.ArrayList;
import java.util.List;

class Student {
    private String id;
    private String fullName;
    private String address;
    private int totalCredits;
    private double gpa;

    public Student(String id, String fullName, String address, int totalCredits, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.totalCredits = totalCredits;
        this.gpa = gpa;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; } // Thêm getter cho address
    public int getTotalCredits() { return totalCredits; }
    public double getGpa() { return gpa; }

    public boolean checkGraduation() {
        return false;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + fullName + ", Address: " + address + ", Credits: " + totalCredits + ", GPA: " + gpa);
    }
}

class CollegeStudent extends Student {
    private double graduationExamScore;

    public CollegeStudent(String id, String fullName, String address, int totalCredits, double gpa, double graduationExamScore) {
        super(id, fullName, address, totalCredits, gpa);
        this.graduationExamScore = graduationExamScore;
    }

    @Override
    public boolean checkGraduation() {
        return getTotalCredits() >= 120 && getGpa() >= 5.0 && graduationExamScore >= 5.0;
    }
}

class UniversityStudent extends Student {
    private String thesisTitle;
    private double thesisScore;

    public UniversityStudent(String id, String fullName, String address, int totalCredits, double gpa, String thesisTitle, double thesisScore) {
        super(id, fullName, address, totalCredits, gpa);
        this.thesisTitle = thesisTitle;
        this.thesisScore = thesisScore;
    }

    public String getThesisTitle() { return thesisTitle; } // Thêm getter cho thesisTitle

    @Override
    public boolean checkGraduation() {
        return getTotalCredits() >= 170 && getGpa() >= 5.0 && thesisScore >= 5.0;
    }
}

class Exercise1Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new CollegeStudent("C01", "Nguyen Van A", "HCMC", 125, 6.5, 7.0));
        students.add(new UniversityStudent("U01", "Tran Thi B", "HCMC", 165, 8.0, "AI Research", 9.0));

        long eligibleCount = students.stream().filter(Student::checkGraduation).count();
        System.out.println("So sinh vien du dieu kien tot nghiep: " + eligibleCount);

        UniversityStudent topUni = null;
        for (Student s : students) {
            if (s instanceof UniversityStudent) {
                UniversityStudent us = (UniversityStudent) s;
                if (topUni == null || us.getGpa() > topUni.getGpa()) {
                    topUni = us;
                }
            }
        }
        if (topUni != null) {
            System.out.println("Sinh vien Dai hoc co GPA cao nhat: " + topUni.getFullName() + " - Thesis: " + topUni.getThesisTitle() + " (GPA: " + topUni.getGpa() + ")");
        } else {
            System.out.println("Khong co sinh vien Dai hoc nao trong danh sach.");
        }
    }
}