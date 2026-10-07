public class Ex1 {
    private double width;
    private double height;

    public Ex1() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Ex1(double width, double height) {
        this.width = (width > 0) ? width : 1.0;
        this.height = (height > 0) ? height : 1.0;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public void displayInfo() {
        System.out.println("Rectangle Information:");
        System.out.println("  Width: " + width);
        System.out.println("  Height: " + height);
        System.out.println("  Area: " + area());
        System.out.println("  Perimeter: " + perimeter());
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Ex1 rect1 = new Ex1();
        Ex1 rect2 = new Ex1(5.0, 3.0);
        Ex1 rect3 = new Ex1(-4.5, 0.0);
        rect1.displayInfo();
        rect2.displayInfo();
        rect3.displayInfo();
    }
}