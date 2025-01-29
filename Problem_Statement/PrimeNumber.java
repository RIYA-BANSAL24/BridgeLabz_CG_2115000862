import java.util.*;
public class PrimeNumber {
    public static void main(String[] args) {
        int num = takeInput("Enter a number : ");

        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        }
	else {
            System.out.println(num + " is not a prime number.");
        }
    }

    private static int takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Please enter an integer: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
