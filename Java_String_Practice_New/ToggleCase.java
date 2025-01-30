import java.util.*;
public class ToggleCase{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.nextLine();
        String toggledStr=toggleCase(str);
        System.out.println("Toggled string: " + toggledStr);
    }

    public static String toggleCase(String str){
        StringBuilder res=new StringBuilder();
        for(int i=0;i< str.length();i++){
            char ch=str.charAt(i);
            if(Character.isUpperCase(ch)){
                res.append(Character.toLowerCase(ch));
            }
            else if (Character.isLowerCase(ch)){
                res.append(Character.toUpperCase(ch));
            }
	    else{
               res.append(ch);
            }
        }
        return res.toString();
    }
}


