import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int[] freq = new int[256];
        int maxFreq = 0;
        char mostFrequentChar = ' ';
        for (char c : str.toCharArray()) {
            freq[c]++;
            if (freq[c] > maxFreq) {
                maxFreq = freq[c];
                mostFrequentChar = c;
            }
        }
       System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }
}
