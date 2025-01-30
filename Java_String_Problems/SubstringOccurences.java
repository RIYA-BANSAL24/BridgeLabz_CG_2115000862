import java.util.*;
public class SubstringOccurences {
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int subLen = sub.length();
        for (int i = 0; i <= str.length() - subLen; i++) {
            boolean found = true;
            for (int j = 0; j < subLen; j++) {
                if (str.charAt(i + j) != sub.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) count++;
        }
        return count;
    }
    public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	System.out.println("Enter the string:");
        String str = sc.nextLine();
	System.out.println("Enter the substring to find:");
        String subStr = sc.nextLine();
        int count = countOccurrences(str, subStr);
	System.out.println("Occurrences of " + subStr + " : " + count);
    }
}

