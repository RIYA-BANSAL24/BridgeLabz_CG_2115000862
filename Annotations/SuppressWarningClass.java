import java.util.*;
public class SuppressWarningClass {
   public static void main(String[]args){
       @SuppressWarnings("unchecked")
       ArrayList list=new ArrayList();
       list.add("Rashi");
       list.add("Shantanu");
       list.add("Riya");
       for(Object l:list){
           System.out.println((String)l);
       }

   }
}
