public class Circle {
    private double centerX;
    private double centerY;
    private double radius;

    public Circle() {
        this.centerX = 0.0;
        this.centerY = 0.0;
        this.radius = 1.0;
    }

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = (radius > 0) ? radius : 1.0;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        double deltaX = x - centerX;
        double deltaY = y - centerY;
        double distanceSquared = (deltaX * deltaX) + (deltaY * deltaY);
        
        return distanceSquared <= (radius * radius);
    }

    public void displayInfo() {
        System.out.printf("Circle at (%.1f, %.1f) with radius %.1f:\n", centerX, centerY, radius);
        System.out.printf("  Area: %.4f\n", area());
        System.out.printf("  Perimeter: %.4f\n", perimeter());
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Circle Class ---");

        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(2.0, 3.0, 4.0);

        defaultCircle.displayInfo();
        customCircle.displayInfo();

        System.out.println("Testing points against defaultCircle (Center: 0,0 | Radius: 1.0):");
        testPoint(defaultCircle, 0.5, 0.5);
        testPoint(defaultCircle, 1.0, 0.0);
        testPoint(defaultCircle, 2.0, 2.0);

        System.out.println();

        System.out.println("Testing points against customCircle (Center: 2,3 | Radius: 4.0):");
        testPoint(customCircle, 2.0, 3.0);
        testPoint(customCircle, 6.0, 3.0);
        testPoint(customCircle, 7.0, 7.0);
    }

    private static void testPoint(Circle c, double x, double y) {
        boolean result = c.contains(x, y);
        System.out.printf("  Point (%.1f, %.1f) is %s the circle.\n", x, y, result ? "INSIDE / ON" : "OUTSIDE");
    }
}