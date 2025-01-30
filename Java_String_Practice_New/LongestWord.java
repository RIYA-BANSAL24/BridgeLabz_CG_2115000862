import java.util.*;
public class LongestWord{
   public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the sentence:");
       String str=sc.nextLine();
       String[] words=str.split("\\s+");
       String longWord="";
       for(String word:words){
          if(word.length()>longWord.length()){
             longWord=word;
          }
       }
       System.out.println("Longest word is: "+longWord);
   }
}
