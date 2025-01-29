import java.util.*;
public class RemoveDuplicates{
   public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String res=removeDup(str);
        System.out.println("String after removing duplicates: " + res);
    }

    public static String removeDup(String str){
        LinkedHashSet<Character> set=new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char ch:str.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

