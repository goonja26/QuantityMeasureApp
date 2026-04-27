import java.util.Scanner;

// Enum for supported units
enum Unit {
    FEET, INCHES
}

// Generic Quantity class
class Quantity {
    private double value;
    private Unit unit;

    // Conversion factors (to base unit: FEET)
    private static final double INCH_TO_FEET = 1.0 / 12.0;

    public Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert everything to FEET (base unit)
    private double toFeet() {
        switch (unit) {
            case FEET:
                return value;
            case INCHES:
                return value * INCH_TO_FEET;
            default:
                throw new IllegalArgumentException("Unsupported unit");
        }
    }

    // Equality check after conversion
    public boolean equals(Quantity other) {
        return Double.compare(this.toFeet(), other.toFeet()) == 0;
    }
}

// Main class
public class UC3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input first value
            System.out.print("Enter first value: ");
            double v1 = sc.nextDouble();
            System.out.print("Enter unit (FEET/INCHES): ");
            Unit u1 = Unit.valueOf(sc.next().toUpperCase());

            // Input second value
            System.out.print("Enter second value: ");
            double v2 = sc.nextDouble();
            System.out.print("Enter unit (FEET/INCHES): ");
            Unit u2 = Unit.valueOf(sc.next().toUpperCase());

            Quantity q1 = new Quantity(v1, u1);
            Quantity q2 = new Quantity(v2, u2);

            boolean result = q1.equals(q2);

            System.out.println("Are both quantities equal? " + result);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter correct values and units.");
        } finally {
            sc.close();
        }
    }
}