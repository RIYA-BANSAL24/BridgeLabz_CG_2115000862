import java.util.*;
public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter the index of the element: ");
            int index = sc.nextInt();

            try {
                int element = numbers[index];
                System.out.print("Enter the divisor: ");
                int divisor = sc.nextInt();
                int result = element / divisor;
                System.out.println("Result: " + result);
            } 
            catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
        finally {
            System.out.println("Operation completed.");
        }
    }
}
