import java.util.*;
public class RemoveDuplicate {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String result = removeDuplicates(str);
        System.out.println("After removing duplicates: " + result);
    }
    public static String removeDuplicates(String str){
        String result="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!isCharPresent(result,ch)){
                result+=ch;
            }
        }
        return result;
    }
    public static boolean isCharPresent(String str,char ch){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==ch){
                return true;
            }
        }
        return false;
    }
}
