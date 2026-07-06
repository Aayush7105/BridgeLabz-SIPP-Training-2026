class Vehicle {
}

class Car extends Vehicle {
    double fuelCost(int km) {
        return km * 6;
    }
}

class Bus extends Vehicle {
    double fuelCost(int km) {
        return km * 12;
    }
}


class Bike extends Vehicle {
    double fuelCost(int km) {
        return km * 2;
    }
}

class ElectricCar extends Vehicle {
    double fuelCost(int km) {
        return km * 1;
    }
}

public class Main {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
            new Car(),
            new Bus(),
            new Bike(),
            new ElectricCar()
        };

        int km = 10;

        for (Vehicle v : vehicles) {

            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println(c.fuelCost(km));
            }

            else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println(b.fuelCost(km));
            }

            else if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println(b.fuelCost(km));
            }

            else if (v instanceof ElectricCar) {
                ElectricCar e = (ElectricCar) v;
                System.out.println(e.fuelCost(km));
            }
        }
    }
}