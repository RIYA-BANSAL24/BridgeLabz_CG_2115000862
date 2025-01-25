import java.util.*;
public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Arrays to store ages and heights of the friends
        int[] age = new int[3];
        double[] height = new double[3];

        String[] names = {"Amar", "Akbar", "Anthony"};
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + " (in cm): ");
            height[i] = sc.nextDouble();
        }

        // Youngest friend
        int youngestAge = age[0];
        String youngestFriend = names[0];

        // Tallest friend
        double tallestHeight = height[0];
        String tallestFriend = names[0];

        // Loop through arrays to find the youngest and tallest
        for (int i = 1; i < 3; i++) {
            if (age[i] < youngestAge) {
                youngestAge = age[i];
                youngestFriend = names[i];
            }
            if (height[i] > tallestHeight) {
                tallestHeight = height[i];
                tallestFriend = names[i];
            }
        }
        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge);
        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight + " cm");
    }
}
