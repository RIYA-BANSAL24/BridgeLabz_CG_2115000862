
import java.util.regex.*;
import java.util.*;
public class ValidateUsername {
   public static boolean isValidUsername(String username) {
       return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a username: ");
       String username = sc.nextLine();
       System.out.println(isValidUsername(username) ? "Valid" : "Invalid");
   }
}

