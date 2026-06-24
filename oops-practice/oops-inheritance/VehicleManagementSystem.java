class Vehicle {

    private final int maxSpeed;
    private final String model;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void displayVehicleDetails() {
        System.out.println("Model: " + getModel());
        System.out.println("Max Speed: " + getMaxSpeed() + " km/h");
    }
}

interface Refuelable {

    void refuel();
}

class ElectricVehicle extends Vehicle {

    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(getModel() + " is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {

    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is refueling with petrol.");
    }
}

public class VehicleManagementSystem {

    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle("Tata Nexon EV", 150);
        PetrolVehicle petrolVehicle = new PetrolVehicle("Honda City", 180);

        electricVehicle.displayVehicleDetails();
        electricVehicle.charge();

        System.out.println();

        petrolVehicle.displayVehicleDetails();
        petrolVehicle.refuel();
        System.out.println("PetrolVehicle IS-A Vehicle: " + (petrolVehicle instanceof Vehicle));
        System.out.println("PetrolVehicle IS-A Refuelable: " + (petrolVehicle instanceof Refuelable));
    }
}
