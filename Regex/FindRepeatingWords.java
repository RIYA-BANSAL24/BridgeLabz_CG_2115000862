
import java.util.*;
public class FindRepeatingWords{
   public static void main(String[] args) {
       String sentence = "This is is a repeated repeated word test.";
       System.out.println(findRepeatingWords(sentence));
   }
   public static String findRepeatingWords(String sentence) {
       String[] words = sentence.toLowerCase().split("\\s+");
       Map<String, Integer> Cnts = new HashMap<>();
       for (String word : words) {
           Cnts.put(word, Cnts.getOrDefault(word, 0) + 1);
       }
       List<String> repeatingWords = new ArrayList<>();
       for (Map.Entry<String, Integer> entry : Cnts.entrySet()) {
           if (entry.getValue() > 1) {
               repeatingWords.add(entry.getKey());
           }
       }
       return String.join(", ", repeatingWords);
   }
}

