import java.util.*;
public class Copy2DArray{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print( "Enter the number of rows: " );
		int rows = sc.nextInt();
		System.out.print( "Enter the number of columns: " );
		int columns = sc.nextInt();
		int[][] matrix = new int[rows][columns];
		System.out.println( "Enter elements for the 2D array:" );
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) { 
				System.out.print( "Enter element at (" + i + ", " + j + "): " ); 
				matrix[i][j] = sc.nextInt();
			}
		}
		int[] oneDArray = new int[rows * columns];
		int index = 0;
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				oneDArray[index++] = matrix[i][j];
			}
		}
		System.out.print( "1D Array: " );
		for (int i = 0; i < oneDArray.length; i++) {
			System.out.print(oneDArray[i] + " " );
		}
		System.out.println();
	}
}
