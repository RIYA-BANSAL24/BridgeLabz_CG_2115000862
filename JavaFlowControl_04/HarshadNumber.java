import java.util.*;
public class HarshadNumber{
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int sum=0;
		int originalNum=number;
		while(originalNum>0){
			int digit = originalNum%10;
			sum += digit;
			originalNum/=10;
		}
		if(number%sum==0){
			System.out.println("Harshad Number");
		}
		else{
			System.out.println("Not a Harshad Number");
		}
	}
}
