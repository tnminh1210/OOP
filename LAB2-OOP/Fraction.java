public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Error: Denominator cannot be 0. Defaulting denominator to 1.");
            this.denominator = 1;
            this.numerator = numerator;
        } else if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        simplify();
    }

    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public void simplify() {
        if (numerator == 0) {
            denominator = 1;
            return;
        }
        int common = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= common;
        denominator /= common;
    }

    public Fraction add(Fraction other) {
        int newNum = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction subtract(Fraction other) {
        int newNum = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction multiply(Fraction other) {
        int newNum = this.numerator * other.numerator;
        int newDen = this.denominator * other.denominator;
        return new Fraction(newNum, newDen);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            System.out.println("Error: Cannot divide by a zero fraction. Returning 0/1.");
            return new Fraction(0, 1);
        }
        int newNum = this.numerator * other.denominator;
        int newDen = this.denominator * other.numerator;
        return new Fraction(newNum, newDen);
    }

    public void display() {
        System.out.println(numerator + "/" + denominator);
    }

    public static void main(String[] args) {
        // Create initial Fraction objects
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4); 

        System.out.print("Fraction 1: ");
        f1.display();
        System.out.print("Fraction 2: ");
        f2.display();

        Fraction sum = f1.add(f2);
        System.out.print("Sum (1/2 + 3/4): ");
        sum.display();

        Fraction diff = f2.subtract(f1);
        System.out.print("Difference (3/4 - 1/2): ");
        diff.display();

        Fraction product = f1.multiply(f2);
        System.out.print("Product (1/2 * 3/4): ");
        product.display();

        Fraction quotient = f1.divide(f2);
        System.out.print("Quotient ((1/2) / (3/4)): ");
        quotient.display();

        Fraction f3 = new Fraction(f1);
        System.out.print("Fraction 3 (Copy of Fraction 1): ");
        f3.display();

        System.out.println("Are f1 and f3 the same reference? " + (f1 == f3));
    }
}