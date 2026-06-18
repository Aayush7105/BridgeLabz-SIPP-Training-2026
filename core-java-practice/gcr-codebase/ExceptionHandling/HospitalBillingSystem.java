
import java.util.Scanner;

class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    public static double calculateAverageBill(double totalBill, int items) {
        if (items == 0) {
            throw new ArithmeticException("Cannot calculate average: Bill has zero items.");
        }
        return totalBill / items;
    }

    public static void makePayment(double billAmount, double paidAmount)
            throws InsufficientFundsException {

        if (paidAmount < billAmount) {
            throw new InsufficientFundsException(
                    "Payment failed: Insufficient funds. Need ₹" + (billAmount - paidAmount) + " more."
            );
        }

        System.out.println("Payment successful!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] patients = {"Rahul", "Anita", "Amit"};

        try {
            System.out.print("Enter total bill amount: ");
            double totalBill = Double.parseDouble(sc.nextLine());

            System.out.print("Enter number of bill items: ");
            int items = Integer.parseInt(sc.nextLine());

            double average = calculateAverageBill(totalBill, items);
            System.out.println("Average cost per item: ₹" + average);

            System.out.print("Enter patient index (0-2): ");
            int index = Integer.parseInt(sc.nextLine());
            System.out.println("Patient: " + patients[index]);

            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(sc.nextLine());

            makePayment(totalBill, payment);

        } catch (ArithmeticException e) {
            System.out.println("Billing Error: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Patient Error: Invalid patient index.");

        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter valid numeric values.");

        } catch (InsufficientFundsException e) {
            System.out.println("Payment Error: " + e.getMessage());

        } finally {
            System.out.println("Billing process completed.");
            sc.close();
        }
    }
}
