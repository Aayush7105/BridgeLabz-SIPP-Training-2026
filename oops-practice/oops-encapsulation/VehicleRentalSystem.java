abstract class Vehicle {

    private String vehicleNumber;
    private String vehicleType;

    Vehicle(String vehicleNumber, String vehicleType) {
        setVehicleNumber(vehicleNumber);
        setVehicleType(vehicleType);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + getVehicleNumber());
        System.out.println("Vehicle Type: " + getVehicleType());
    }
}

class Car extends Vehicle {

    private double dailyRate;

    Car(String vehicleNumber, double dailyRate) {
        super(vehicleNumber, "Car");
        setDailyRate(dailyRate);
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getDailyRate();
    }
}

class Bike extends Vehicle {

    private double dailyRate;

    Bike(String vehicleNumber, double dailyRate) {
        super(vehicleNumber, "Bike");
        setDailyRate(dailyRate);
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getDailyRate();
    }
}

class Truck extends Vehicle {

    private double dailyRate;
    private double loadingCharge;

    Truck(String vehicleNumber, double dailyRate, double loadingCharge) {
        super(vehicleNumber, "Truck");
        setDailyRate(dailyRate);
        setLoadingCharge(loadingCharge);
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getLoadingCharge() {
        return loadingCharge;
    }

    public void setLoadingCharge(double loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (days * getDailyRate()) + getLoadingCharge();
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {
        int days = 5;

        Vehicle[] vehicles = {
            new Car("CAR-101", 1500),
            new Bike("BIKE-201", 600),
            new Truck("TRUCK-301", 3500, 2000)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails();
            System.out.println("Rental Days: " + days);
            System.out.printf("Rental Cost: %.2f%n%n", vehicle.calculateRentalCost(days));
        }
    }
}
