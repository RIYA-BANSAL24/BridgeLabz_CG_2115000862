public class UnitConvertor5 {
	public static double YardstoFeet(double yards) {
		double yardsTofeet = 3;
		return yards*yardsTofeet;
	}
	public static double FeettoYards(double feet) {
		double feetToyards=0.333333;
		return feet*feetToyards;
	}
	public static double MeterstoInches(double meters) {
		double metersToinches = 39.3701;
		return meters * metersToinches;
	}
	public static double InchestoMeters(double inches) {
		double inchesTometers = 0.0254;
		return inches*inchesTometers;
	}
	public static double InchestoCm(double inches) {
		double inchesTocm = 2.54;
		return inches*inchesTocm;
	}
	public static void main(String[]args) {
	double yards=12.0;
	double feet = 10.0;
	double meters = 6.2;
	double inches = 100.0;
	double inchescm = 328.08;
	System.out.println(yards+ " yards is "+ YardstoFeet(yards)+ " feet.");
	System.out.println(feet + " feet is " + FeettoYards(feet) + " yards.");
	System.out.println(meters + " meters is " + MeterstoInches(meters) + " inches.");
	System.out.println(inches + " inches is " +InchestoMeters(inches) + " meters.");
	System.out.println(inchescm + " inches is " + InchestoCm(inches) + " cm.");
	}
}
