import java.util.*;
public class FrequencyOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int[] frequency = new int[10];
        int temp = number;
        int index = 0;

        while (temp != 0) {
            digits[index] = temp % 10;
            temp = temp / 10;
            index++;
        }
        for (int i = 0; i < index; i++) {
            frequency[digits[i]]++;
        }
        System.out.println("Frequency of each digit:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " : " + frequency[i]);
            }
        }
    }
}
