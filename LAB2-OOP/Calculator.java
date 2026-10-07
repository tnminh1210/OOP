public class Calculator {

    public int add(int a, int b) {
        System.out.println("-> Executing: add(int a, int b)");
        return a + b;
    }

    public double add(double a, double b) {
        System.out.println("-> Executing: add(double a, double b)");
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("-> Executing: add(int a, int b, int c)");
        return a + b + c;
    }

    public int max(int a, int b) {
        System.out.println("-> Executing: max(int a, int b)");
        return (a > b) ? a : b;
    }

    public double max(double a, double b) {
        System.out.println("-> Executing: max(double a, double b)");
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("=== Testing add() Overloads ===");
        
        int res1 = calc.add(5, 10);
        System.out.println("Result: " + res1 + "\n");

        double res2 = calc.add(4.5, 3.2);
        System.out.println("Result: " + res2 + "\n");

        int res3 = calc.add(1, 2, 3);
        System.out.println("Result: " + res3 + "\n");

        System.out.println("=== Testing max() Overloads ===");

        int res4 = calc.max(12, 25);
        System.out.println("Result: " + res4 + "\n");

        double res5 = calc.max(7.8, 4.1);
        System.out.println("Result: " + res5 + "\n");
    }
}