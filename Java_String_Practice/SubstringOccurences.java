import java.util.Scanner;
public class SubstringOccurences{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string:");
        String str = sc.nextLine();
        System.out.println("Enter the substring to find:");
        String subStr = sc.nextLine();
        int count = countOccurrences(str, subStr);
        System.out.println("Occurrences of " + subStr + " : " + count);
    }

    public static int countOccurrences(String str, String subStr) {
        if (subStr.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index++;
        }
        return count;
    }
}

