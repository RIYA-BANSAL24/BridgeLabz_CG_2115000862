import java.util.regex.*;
import java.util.*;
public class ProgrammingLanguageExtractor {
   public static void extractLanguages(String text) {
       Pattern pattern = Pattern.compile("\\b(JavaScript|Java|Python|C\\+\\+|C#|Go|Ruby|Swift|PHP|Kotlin|Rust)\\b");
       Matcher matcher = pattern.matcher(text);
       while (matcher.find()) {
           System.out.print(matcher.group() + " ");
       }
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a sentence: ");
       String text = sc.nextLine();
       extractLanguages(text);
   }
}