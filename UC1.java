import java.util.Scanner;

public class UC1 {

    // Method to compare two values in feet
    public static boolean areEqual(double value1, double value2) {
        return value1 == value2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Input values
            System.out.print("Enter first value in feet: ");
            double value1 = sc.nextDouble();

            System.out.print("Enter second value in feet: ");
            double value2 = sc.nextDouble();

            // Compare values
            boolean result = areEqual(value1, value2);

            // Output result
            System.out.println("Are both values equal? " + result);

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numeric values.");
        } finally {
            sc.close();
        }
    }
}