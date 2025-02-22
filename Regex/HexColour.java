import java.util.regex.*;
import java.util.*;
public class HexColour{
   public static boolean isValidHexColor(String color) {
       return color.matches("^#[0-9A-Fa-f]{6}$");
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a hex color code: ");
       String color = sc.nextLine();
       System.out.println(isValidHexColor(color) ? "Valid" : "Invalid");
   }
}

