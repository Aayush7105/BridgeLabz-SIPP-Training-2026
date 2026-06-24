interface Trackable {

    void logActivity(String activity, int minutes);

    default void resetData() {
        System.out.println("Tracking data has been reset.");
    }
}

interface Reportable {

    void generateReport();
}

interface Notifiable {

    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    private String lastActivity;
    private int activeMinutes;

    @Override
    public void logActivity(String activity, int minutes) {
        lastActivity = activity;
        activeMinutes = minutes;
        System.out.println("Logged Activity: " + lastActivity + " for " + activeMinutes + " minutes");
    }

    @Override
    public void generateReport() {
        System.out.println("Fitness Report");
        System.out.println("Last Activity: " + lastActivity);
        System.out.println("Active Minutes: " + activeMinutes);
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("Alert: " + message);
    }
}

public class FitnessTrackerDemo {

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();

        device.logActivity("Running", 35);
        device.generateReport();
        device.sendAlert("Daily activity goal completed.");
        device.resetData();

        System.out.println("FitnessDevice implements Trackable: " + (device instanceof Trackable));
        System.out.println("FitnessDevice implements Reportable: " + (device instanceof Reportable));
        System.out.println("FitnessDevice implements Notifiable: " + (device instanceof Notifiable));
        System.out.println("Java classes can implement multiple interfaces, but can extend only one class.");
    }
}
