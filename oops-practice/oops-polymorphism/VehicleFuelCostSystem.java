abstract class FuelCostVehicle {

    private final String model;

    FuelCostVehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public abstract double fuelCost(double kilometers);
}

class PetrolCar extends FuelCostVehicle {

    private final double kilometersPerLiter;
    private final double petrolPricePerLiter;

    PetrolCar(String model, double kilometersPerLiter, double petrolPricePerLiter) {
        super(model);
        this.kilometersPerLiter = kilometersPerLiter;
        this.petrolPricePerLiter = petrolPricePerLiter;
    }

    public double getKilometersPerLiter() {
        return kilometersPerLiter;
    }

    @Override
    public double fuelCost(double kilometers) {
        return (kilometers / kilometersPerLiter) * petrolPricePerLiter;
    }
}

class DieselCar extends FuelCostVehicle {

    private final double kilometersPerLiter;
    private final double dieselPricePerLiter;

    DieselCar(String model, double kilometersPerLiter, double dieselPricePerLiter) {
        super(model);
        this.kilometersPerLiter = kilometersPerLiter;
        this.dieselPricePerLiter = dieselPricePerLiter;
    }

    @Override
    public double fuelCost(double kilometers) {
        return (kilometers / kilometersPerLiter) * dieselPricePerLiter;
    }
}

class ElectricCar extends FuelCostVehicle {

    private final double kilometersPerUnit;
    private final double electricityPricePerUnit;

    ElectricCar(String model, double kilometersPerUnit, double electricityPricePerUnit) {
        super(model);
        this.kilometersPerUnit = kilometersPerUnit;
        this.electricityPricePerUnit = electricityPricePerUnit;
    }

    @Override
    public double fuelCost(double kilometers) {
        return (kilometers / kilometersPerUnit) * electricityPricePerUnit;
    }
}

public class VehicleFuelCostSystem {

    public static void main(String[] args) {
        double distanceInKilometers = 120.0;

        FuelCostVehicle[] vehicles = {
            new PetrolCar("Honda City", 16.5, 105.0),
            new DieselCar("Hyundai Creta", 20.0, 92.0),
            new ElectricCar("Tata Punch EV", 6.2, 8.0)
        };

        displayFuelCosts(vehicles, distanceInKilometers);
        displayPetrolCarEfficiency(vehicles);
    }

    public static void displayFuelCosts(FuelCostVehicle[] vehicles, double kilometers) {
        System.out.println("Fuel cost for " + kilometers + " km:");

        for (FuelCostVehicle vehicle : vehicles) {
            System.out.printf("%s: Rs. %.2f%n", vehicle.getModel(), vehicle.fuelCost(kilometers));
        }
    }

    public static void displayPetrolCarEfficiency(FuelCostVehicle[] vehicles) {
        System.out.println("\nPetrol car efficiency:");

        for (FuelCostVehicle vehicle : vehicles) {
            if (vehicle instanceof PetrolCar) {
                PetrolCar petrolCar = (PetrolCar) vehicle;
                System.out.println(
                    petrolCar.getModel() + ": " + petrolCar.getKilometersPerLiter() + " km/l"
                );
            }
        }
    }
}
