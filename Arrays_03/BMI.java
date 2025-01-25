import java.util.*;
public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = sc.nextInt();
        double[] weight = new double[numPersons];
        double[] height = new double[numPersons];
        double[] bmi = new double[numPersons];
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");

            System.out.print("Enter weight (in kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (in meters): ");
            height[i] = sc.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.4) {
                weightStatus[i] = "Underweight";
            }
	    else if (bmi[i] >= 18.4 && bmi[i] < 24.9) {
                weightStatus[i] = "Normal weight";
            }
	    else if (bmi[i] >= 25 && bmi[i] < 39.9) {
                weightStatus[i] = "Overweight";
            }
	    else {
                weightStatus[i] = "Obesity";
            }
        }
        for (int i = 0; i < numPersons; i++) {
            System.out.print((i + 1) + height[i] + weight[i] + bmi[i] + weightStatus[i]);
        }

    }
}
