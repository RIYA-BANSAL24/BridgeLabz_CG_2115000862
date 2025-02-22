import java.util.*;
public class CensorWords{
   public static String censorBadWords(String text) {
       String[] badWords = {"OMG", "stupid"};
       for (String word : badWords) {
           text = text.replaceAll("\\b" + word + "\\b", "****");
       }
       return text;
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a sentence: ");
       String text = sc.nextLine();
       System.out.println(censorBadWords(text));
   }
}

