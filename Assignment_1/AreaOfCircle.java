import java.util.*;
public class AreaOfCircle{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius");
		double radius = sc.nextDouble();
		double areaCircle = Math.PI*Math.pow(radius,2);
		System.out.print("Area of circle is : " + areaCircle);
	}
}


