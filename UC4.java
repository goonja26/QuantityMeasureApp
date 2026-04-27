import java.util.Scanner;

// Enum with conversion to base unit (INCHES)
enum Unit {
    FEET(12.0),          // 1 foot = 12 inches
    INCHES(1.0),         // base unit
    YARDS(36.0),         // 1 yard = 36 inches
    CM(0.393701);        // 1 cm = 0.393701 inches

    private final double toInches;

    Unit(double toInches) {
        this.toInches = toInches;
    }

    public double toBase(double value) {
        return value * toInches;
    }
}

// Generic Quantity class
class Quantity {
    private double value;
    private Unit unit;

    public Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (INCHES)
    private double toInches() {
        return unit.toBase(value);
    }

    // Equality check with precision handling
    public boolean equals(Quantity other) {
        return Math.abs(this.toInches() - other.toInches()) < 0.0001;
    }
}

// Main class
public class UC4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // First input
            System.out.print("Enter first value: ");
            double v1 = sc.nextDouble();
            System.out.print("Enter unit (FEET/INCHES/YARDS/CM): ");
            Unit u1 = Unit.valueOf(sc.next().toUpperCase());

            // Second input
            System.out.print("Enter second value: ");
            double v2 = sc.nextDouble();
            System.out.print("Enter unit (FEET/INCHES/YARDS/CM): ");
            Unit u2 = Unit.valueOf(sc.next().toUpperCase());

            Quantity q1 = new Quantity(v1, u1);
            Quantity q2 = new Quantity(v2, u2);

            boolean result = q1.equals(q2);

            System.out.println("Are both quantities equal? " + result);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter correct numeric values and units.");
        } finally {
            sc.close();
        }
    }
}
