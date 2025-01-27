import java.util.*;
public class NaturalNumbers{
	public static int SumRecursion(int n){
		if(n==1){
			return 1;
		}
		return n+SumRecursion(n-1);
	}
	public static int Sumformula(int n){
		return n*(n+1)/2;
	}
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number :");
		int n=sc.nextInt();
		if(n<=0){
			System.out.println("It is not a natural Number");
			return;
		}
		int sum1=SumRecursion(n);
		int sum2=Sumformula(n);
		System.out.println("Sum using Recursion: "+sum1);
		System.out.println("Sum using formula: "+sum2);
		if(sum1==sum2){
			System.out.println("Results are same ");
		}
		else{
			System.out.println("Results are not same ");
		}
	}
}
