// Package.java

class Package {

    private final String trackingId;
    private double weight;

    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;

        if (weight > 0.0) {
            this.weight = weight;
        } else {
            System.out.println("Error: Weight must be greater than 0.");
            this.weight = 0.0;
        }
    }

    public String getTrackingId() {
        return trackingId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0.0) {
            this.weight = weight;
        } else {
            System.out.println("Error: Weight must be greater than 0.");
        }
    }
}// ExpressPackage.java

class ExpressPackage extends Package {
    // Additional attribute

    private String priorityLevel;

    // Constructor
    public ExpressPackage(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }

    // Getter
    public String getPriorityLevel() {
        return priorityLevel;
    }

    // Display package details
    public void printShippingLabel() {
        System.out.println("Priority      : " + priorityLevel);
        System.out.println("--------------------------");
    }
}
// Main.java

public class Ecommerce {

    public static void main(String[] args) {

        ExpressPackage ep = new ExpressPackage("EXP101", 2.5, "Critical");

        System.out.println("Valid Package:");
        ep.printShippingLabel();

        System.out.println("\nTrying to set weight to -1.5");
        ep.setWeight(-1.5);

        System.out.println("\nTrying to set weight to 0.0");
        ep.setWeight(0.0);

        System.out.println("\nWeight after invalid attempts: " + ep.getWeight() + " kg");
    }
}
