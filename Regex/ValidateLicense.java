
import java.util.regex.*;
import java.util.*;
public class ValidateLicense{
   public static boolean isValidLicensePlate(String plate) {
       return plate.matches("^[A-Z]{2}d{4}$");
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a license plate number: ");
       String plate = sc.nextLine();
       System.out.println(isValidLicensePlate(plate) ? "Valid" : "Invalid");
   }
}

