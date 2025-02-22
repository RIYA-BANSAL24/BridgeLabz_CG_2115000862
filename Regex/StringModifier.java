import java.util.*;
public class StringModifier {
   public static String replaceMultipleSpaces(String text) {
       return text.replaceAll("\\s+", " ").trim();
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a sentence: ");
       String text = sc.nextLine();
       System.out.println(replaceMultipleSpaces(text));
   }
}