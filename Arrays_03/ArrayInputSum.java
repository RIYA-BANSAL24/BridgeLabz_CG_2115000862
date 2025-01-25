import java.util.*;
public class ArrayInputSum{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		double[] numbers = new double[10];
		double total = 0.0;
		int index = 0;
		System.out.println("Enter numbers ");
		while(true){
			double number = sc.nextDouble();
			if(number <= 0 || index >= 10){
				break;
			}
			numbers[index] = number;
			index++;
		}
		for(int i=0;i<index;i++){
			total += numbers[i];
		}
		System.out.print("Entered numbers :");
		for(int i=0;i<index;i++){
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		System.out.println("Sum of numbers: " + total);
	}
}
