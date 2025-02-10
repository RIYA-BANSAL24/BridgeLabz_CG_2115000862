import java.util.*;
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }
    public String getDriverName() {
        return driverName;
    }
    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver Name: " + driverName + ", Rate per Km: Rs. " + ratePerKm;
    }
}

interface GPS {
    public String getCurrentLocation();
    public void updateLocation(String location);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}
public class RideHailing {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C001", "John Doe", 15.0));
        vehicles.add(new Bike("B002", "Jane Smith", 8.0));
        vehicles.add(new Auto("A003", "Alex Johnson", 10.0));

        double distance = 12.5; // Example distance in km

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: Rs. " + vehicle.calculateFare(distance));
            if (vehicle instanceof GPS) {
                GPS gpsVehicle = (GPS) vehicle;
                gpsVehicle.updateLocation("Downtown");
                System.out.println("Current Location: " + gpsVehicle.getCurrentLocation());
            }
            System.out.println();
        }
    }
}
