import java.util.*;
public class ReverseString{
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = sc.next();
        char [] charArr = str.toCharArray();
        int i = 0;
	int j = str.length()-1;
        while(i<j){
           char temp = charArr[i];
           charArr[i]=charArr[j];
           charArr[j]=temp;
           i++;
           j--;
        }
        String rev=new String(charArr);
        System.out.println("The reverse string is: "+rev);
     }
 }

