import java.util.regex.*;
import java.util.*;
public class CurrencyExtractor{
   public static void extractCurrencyValues(String text) {
       Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
       Matcher matcher = pattern.matcher(text);
       while (matcher.find()) {
           System.out.print(matcher.group() + " ");
       }
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a sentence: ");
       String text = sc.nextLine();
       extractCurrencyValues(text);
   }
}