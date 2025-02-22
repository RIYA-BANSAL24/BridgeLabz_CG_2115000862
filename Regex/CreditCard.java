import java.util.regex.*;
import java.util.*;
public class CreditCard {
   public static boolean isValidCreditCard(String cardNumber) {
       String visaPattern = "^4\\d{15}$";
       String masterCardPattern = "^5\\d{15}$";
       return cardNumber.matches(visaPattern) || cardNumber.matches(masterCardPattern);
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a credit card number: ");
       String cardNumber = sc.nextLine();
       System.out.println(isValidCreditCard(cardNumber) ? "Valid" : "Invalid");
   }
}

