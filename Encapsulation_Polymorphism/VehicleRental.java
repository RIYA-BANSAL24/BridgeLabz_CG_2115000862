import java.util.*;
abstract class Vehicle{
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public String getType(){
        return type;
    }
    public double getRentalRate(){
        return rentalRate;
    }

    public void setRentalRate(double rentalRate){
        this.rentalRate = rentalRate;
    }
    abstract double calculateRentalCost(int days); 
}

interface Insurable{
    public double calculateInsurance();
    public String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable{
    private String insurancePolicyNum;
    public Car(String vehicleNumber, String type, double rentalRate, String insurancePolicyNum){
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNum = insurancePolicyNum;
    }
    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }
    public double calculateInsurance(){
        return 800;
    }
    public String getInsuranceDetails(){
        return "Car Insurance Number: " + insurancePolicyNum;
    }
}

class Bike extends Vehicle implements Insurable{
    private String insurancePolicyNum;
    public Bike(String vehicleNumber, String type, double rentalRate, String insurancePolicyNum){
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNum = insurancePolicyNum;
    }
    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }
    public double calculateInsurance(){
        return 500;
    }
    public String getInsuranceDetails(){
        return "Bike Insurance  Number: " + insurancePolicyNum;
    }
}
class Truck extends Vehicle implements Insurable{
    private String insurancePolicyNum;
    public Truck(String vehicleNumber, String type, double rentalRate, String insurancePolicyNum){
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNum = insurancePolicyNum;
    }
    public double calculateRentalCost(int days){
        return getRentalRate() * days;
    }
    public double calculateInsurance(){
        return 1000;
    }
    public String getInsuranceDetails(){
        return "Truck Insurance  Number: " + insurancePolicyNum;
    }
}
public class VehicleRental {
    public static void displayDetails(List<Vehicle> veh, int rentalDays) {
        for (Vehicle vehicle : veh) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = (vehicle instanceof Insurable) ? ((Insurable) vehicle).calculateInsurance() : 0;

            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Type: " + vehicle.getType());
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
        }
    }

    public static void main(String[] args) {
        // Create a list of vehicles
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car("R031999", "Car", 50, "CAR12345"));
        vehicleList.add(new Bike("R121503", "Bike", 30, "BIKE6789"));
        vehicleList.add(new Truck("T303", "Truck", 100, "TRUCK9876"));

        displayDetails(vehicleList, 5);
    }
}
