public class UITStudent {
    private String studentId;
    private String fullName;
    private String major;
    private double gpa;

    public UITStudent() {
        this("UIT00000", "Unknown Student", "Computer Science", 0.0);
    }

    public UITStudent(String studentId, String fullName) {
        this(studentId, fullName, "Software Engineering", 0.0);
    }

    public UITStudent(String studentId, String fullName, String major, double gpa) {
        this.studentId = (studentId != null && !studentId.trim().isEmpty()) ? studentId : "UIT00000";
        this.fullName = (fullName != null && !fullName.trim().isEmpty()) ? fullName : "Unknown Student";
        this.major = (major != null && !major.trim().isEmpty()) ? major : "Undeclared";
        
        if (gpa >= 0.0 && gpa <= 10.0) {
            this.gpa = gpa;
        } else {
            this.gpa = 0.0;
        }
    }

    public boolean isPassed() {
        return this.gpa >= 5.0;
    }

    public String academicClassification() {
        if (gpa >= 9.0) {
            return "Excellent (Xuất sắc)";
        } else if (gpa >= 8.0) {
            return "Very Good (Giỏi)";
        } else if (gpa >= 6.5) {
            return "Good (Khá)";
        } else if (gpa >= 5.0) {
            return "Average (Trung bình)";
        } else {
            return "Weak / Failing (Yếu / Kém)";
        }
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Full Name:  " + fullName);
        System.out.println("Major:      " + major);
        System.out.printf("GPA:        %.2f\n", gpa);
        System.out.println("Status:     " + (isPassed() ? "Passed" : "Not Passed"));
        System.out.println("Rank:       " + academicClassification());
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Testing UITStudent Constructor Overloading & Chaining ===\n");

        UITStudent student1 = new UITStudent();

        UITStudent student2 = new UITStudent("21520123", "Nguyen Van An");

        UITStudent student4 = new UITStudent("22520456", "Tran Thi Bich", "Information Systems", 8.6);

        UITStudent student5 = new UITStudent("23520789", "Le Hoang Nam", "Artificial Intelligence", 9.3);

        UITStudent student3 = new UITStudent("21520999", "Hoang Minh Tu", "Cyber Security", 4.8);

        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        student4.displayInfo();
        student5.displayInfo();
    }
}