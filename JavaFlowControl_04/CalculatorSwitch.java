import java.util.*;
public class CalculatorSwitch {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("First number: ");
		double first = sc.nextDouble();
		System.out.print("Second number: ");
		double second = sc.nextDouble();
		System.out.print("Enter the operator: ");
		String op = sc.next();
		double result;
		switch (op) {
			case "+":
				result = first + second;
				System.out.println("Result: " + result);
				break;
			case "-":
   				result = first - second;
   				System.out.println("Result: " + result);
               			break;
           		case "*":
               			result = first * second;
               			System.out.println("Result: " + result);
               			break;
           		case "/":
                   		result = first / second;
                   		System.out.println("Result: " + result);
               			break;
           		default:
               			System.out.println("Invalid Operator");
       		}
   	}
}
