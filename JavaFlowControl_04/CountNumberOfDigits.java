import java.util.*;
public class CountNumberOfDigits{
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int count=0;
		while(number!=0){
			number/=10;
			count++;
		}
		System.out.println("The number of digits in an integer is "+count);
	}
}
