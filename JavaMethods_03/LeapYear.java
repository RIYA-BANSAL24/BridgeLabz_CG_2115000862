import java.util.*;
public class LeapYear{
	public static boolean isLeap(int year){
		if(year>=1582){
			return (year%4 == 0 && year%100!= 0) || (year%400 == 0);
		}
		return false;
	}
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Year: ");
		int year=sc.nextInt();
		if (year<1582){
			System.out.println("The LeapYear program only works for year >= 1582.");
		}
		else if (isLeap(year)) {
			System.out.println("The year " +year+ " is a Leap Year.");
		}
		else{
			System.out.println("The year " +year+ " is not a Leap Year.");
		}
	}
}
