import java.util.regex.*;
import java.util.*;
public class ExtractingEmailAddress{
   public static void extractEmails(String text) {
       Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}");
       Matcher matcher = pattern.matcher(text);
       while (matcher.find()) {
           System.out.println(matcher.group());
       }
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter text: ");
       String text = sc.nextLine();
       extractEmails(text);
   }
}

