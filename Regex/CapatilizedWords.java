import java.util.regex.*;
import java.util.*;
public class CapatilizedWords{
   public static void extractCapitalizedWords(String text) {
       Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
       Matcher matcher = pattern.matcher(text);
       while (matcher.find()) {
           System.out.print(matcher.group() + " ");
       }
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a sentence: ");
       String text = sc.nextLine();
       extractCapitalizedWords(text);
   }
}

