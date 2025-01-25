import java.util.*;
public class LargestSecondLargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        int index = 0;
        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;

            // If the array is full, break out of the loop
            if (index == maxDigit) {
                break;
            }
        }

        int largest = -1;
        int secondLargest = -1;

        // Loop through the array to find the largest and second largest number
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        System.out.println("Largest number: " + largest);
        System.out.println("Second largest number: " + secondLargest);
    }
}
