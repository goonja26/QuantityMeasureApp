// Feet class
class Feet {
    private double value;

    public Feet(double value) {
        this.value = value;
    }

    public boolean equals(Feet other) {
        return this.value == other.value;
    }
}

// Inches class
class Inches {
    private double value;

    public Inches(double value) {
        this.value = value;
    }

    public boolean equals(Inches other) {
        return this.value == other.value;
    }
}

// Main class UC2
public class UC2 {

    // Static method to compare feet values
    public static boolean compareFeet(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    // Static method to compare inches values
    public static boolean compareInches(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }

    public static void main(String[] args) {

        // Hardcoded values (as per requirement)
        double feet1 = 5.0;
        double feet2 = 5.0;

        double inch1 = 12.0;
        double inch2 = 10.0;

        // Compare Feet
        boolean feetResult = compareFeet(feet1, feet2);
        System.out.println("Feet comparison result: " + feetResult);

        // Compare Inches
        boolean inchResult = compareInches(inch1, inch2);
        System.out.println("Inches comparison result: " + inchResult);
    }
}
