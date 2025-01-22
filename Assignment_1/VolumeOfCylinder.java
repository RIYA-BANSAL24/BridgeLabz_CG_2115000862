import java.util.*;
public class VolumeOfCylinder{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius of the cylinder");
		double rad = sc.nextDouble();
		System.out.print("Enter height of the cylinder");
		double height = sc.nextDouble();
		double volume = Math.PI * Math.pow(rad, 2) * height;
		System.out.print("The volume of the cyclinder is : " + volume);
	}
}