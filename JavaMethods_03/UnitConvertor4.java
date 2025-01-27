public class UnitConvertor4 {
	public static double KmToMiles(double km) {
		double kmTomiles = 0.621371;
		return km * kmTomiles;
	}
	public static double MilesToKm(double miles) {
		double milesTokm = 1.60934;
		return miles * milesTokm;
	}
	public static double MetersToFeet(double meters) {
		double metersTofeet = 3.28084;
		return meters * metersTofeet;
	}
	public static double FeetToMeters(double feet) {
		double feetTometers = 0.3048;
		return feet * feetTometers;
	}
	public static void main(String[]args) {
		double km = 100.0;
		double miles = 60.2;
		double meters = 10.0;
		double feet = 32.8;
		System.out.println(km + " km is " + KmToMiles(km) + " miles.");
		System.out.println(miles + " miles is " + MilesToKm(miles) + " km.");
		System.out.println(meters + " meters is " + MetersToFeet(meters) + " feet.");
		System.out.println(feet + " feet is " + FeetToMeters(feet) + " meters.");
	}
}
