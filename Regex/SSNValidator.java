
import java.util.regex.*;
public class SSNValidator {
   public static void main(String[] args) {
       String[] inputs = {
               "My SSN is 123-45-6789.",
               "My SSN is 123456789."
       };
       for (String input : inputs) {
           validate(input);
       }
   }
   public static void validate(String text) {
       Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
       Matcher matcher = pattern.matcher(text);
       if (matcher.find()) {
           System.out.println(matcher.group() + " is valid");
       }
       else {
           System.out.println("SSN is invalid");
       }
   }
}

