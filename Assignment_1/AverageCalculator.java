import java.util.*;
public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first num: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter the second num: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter the third num: ");
        double num3 = sc.nextDouble();
        double average = (num1 + num2 + num3) / 3;
        System.out.println("The average is: " + average);
    }
}
