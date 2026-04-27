import java.util.Scanner;

// Enum with conversion factors (base unit = INCHES)
enum Unit {
    FEET(12.0),        // 1 foot = 12 inches
    INCHES(1.0),       // base unit
    YARDS(36.0),       // 1 yard = 36 inches
    CM(0.393701);      // 1 cm = 0.393701 inches

    private final double toInches;

    Unit(double toInches) {
        this.toInches = toInches;
    }

    public double toBase(double value) {
        return value * toInches;
    }

    public double fromBase(double baseValue) {
        return baseValue / toInches;
    }
}

// Quantity class with conversion API
class Quantity {

    // Static conversion method
    public static double convert(double value, Unit source, Unit target) {

        // Validation
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }
        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        // Step 1: Convert to base unit (INCHES)
        double baseValue = source.toBase(value);

        // Step 2: Convert to target unit
        double result = target.fromBase(baseValue);

        // Optional rounding (4 decimal places)
        return Math.round(result * 10000.0) / 10000.0;
    }
}

// Main class
public class UC5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter value: ");
            double value = sc.nextDouble();

            System.out.print("Enter source unit (FEET/INCHES/YARDS/CM): ");
            Unit source = Unit.valueOf(sc.next().toUpperCase());

            System.out.print("Enter target unit (FEET/INCHES/YARDS/CM): ");
            Unit target = Unit.valueOf(sc.next().toUpperCase());

            // Conversion
            double result = Quantity.convert(value, source, target);

            // Output
            System.out.println("Converted Value: " + result + " " + target);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid numbers and units.");
        } finally {
            sc.close();
        }
    }
}
