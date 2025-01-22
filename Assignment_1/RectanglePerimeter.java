import java.util.*;
public class RectanglePerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle: ");
        double len = sc.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double width = sc.nextDouble();
        double perimeter = 2 * (len + width);
        System.out.println("The perimeter of the rectangle is: " + perimeter);
    }
}
