
import java.util.regex.*;
import java.util.*;
public class LinkExtractor{
   public static void extractLinks(String text) {
       Pattern pattern = Pattern.compile("https?://[a-zA-Z0-9./-]+\\b");
       Matcher matcher = pattern.matcher(text);
       while (matcher.find()) {
           System.out.print(matcher.group() + " ");
       }
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a sentence: ");
       String text = sc.nextLine();
       extractLinks(text);
   }
}

