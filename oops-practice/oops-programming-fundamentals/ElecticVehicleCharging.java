
class ChargingStation {

    static int totalStations = 0;
    static double electricityRate = 8.5;

    int stationId;
    double unitsConsumed;

    ChargingStation(int stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    void displayStationDetails() {
        System.out.println("Station ID: " + stationId);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Electricity Rate: " + electricityRate);
        System.out.println("Bill Amount: " + calculateBill());
        System.out.println();
    }
}

public class ElecticVehicleCharging {

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation(101, 120);
        ChargingStation s2 = new ChargingStation(102, 150);
        ChargingStation s3 = new ChargingStation(103, 200);
        ChargingStation s4 = new ChargingStation(104, 175);
        ChargingStation s5 = new ChargingStation(105, 250);

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total Stations: " + ChargingStation.totalStations);

        ChargingStation.electricityRate = 10.0;

        System.out.println("\nAfter changing electricity rate:\n");

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();
    }
}
