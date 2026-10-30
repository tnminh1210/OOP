import java.util.ArrayList;
import java.util.List;

class Person {
    private String fullName;
    private int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() { return fullName; }
    public int getAge() { return age; }
}

class Guest extends Person {
    private String cccd;

    public Guest(String cccd, String fullName, int age) {
        super(fullName, age);
        this.cccd = cccd;
    }

    public String getCccd() { return cccd; }
}

class Staff extends Person {
    private String licenseId;
    private String employeeId;

    public Staff(String licenseId, String employeeId, String fullName, int age) {
        super(fullName, age);
        this.licenseId = licenseId;
        this.employeeId = employeeId;
    }

    public String getLicenseId() { return licenseId; }
    public String getEmployeeId() { return employeeId; }
}

class Room {
    private String roomType; // VIP1, VIP2, VIP3
    private int rentalDays;

    public Room(String roomType, int rentalDays) {
        this.roomType = roomType;
        this.rentalDays = rentalDays;
    }

    public String getRoomType() { return roomType; }
    public int getRentalDays() { return rentalDays; }

    public double calculateCost() {
        double dailyPrice = 0;
        if (roomType.equalsIgnoreCase("VIP1")) {
            dailyPrice = 900000;
        } else if (roomType.equalsIgnoreCase("VIP2")) {
            dailyPrice = 700000;
        } else if (roomType.equalsIgnoreCase("VIP3")) {
            dailyPrice = 500000;
        }
        return dailyPrice * rentalDays;
    }
}

class Exercise3Test {
    public static void main(String[] args) {
        List<Guest> guests = new ArrayList<>();
        guests.add(new Guest("079204001234", "Nguyen Van C", 25));
        
        // Thao tác thêm/xóa khách hàng
        guests.removeIf(g -> g.getCccd().equals("079204001234"));

        // Tính chi phí thuê phòng theo ví dụ (VIP2 thuê 3 ngày)
        Room room = new Room("VIP2", 3);
        System.out.println("Loai phong: " + room.getRoomType() + ", So ngay: " + room.getRentalDays());
        System.out.println("Chi phi thue phong: " + room.calculateCost() + " VND");
    }
}