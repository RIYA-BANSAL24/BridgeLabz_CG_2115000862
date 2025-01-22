import java.util.*;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal amount: ");
        double prin = sc.nextDouble();
        System.out.print("Enter Rate of interest: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Time ");
        double time = sc.nextDouble();
        double simpleInterest = (prin * rate * time) / 100;
        System.out.println("Simple Interest: " + simpleInterest);
    }
}
