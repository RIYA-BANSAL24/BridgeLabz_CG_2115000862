import java.util.*;
public class RemoveSpecificChar {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the string: ");
        String str = sc.next();
	System.out.println("Enter character you want to remove");
        char charToRemove = sc.next().charAt(0);

        String newStr = removeChar(str, charToRemove);
        System.out.println("New String: " + newStr );
    }

    public static String removeChar(String str, char charToRemove) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
