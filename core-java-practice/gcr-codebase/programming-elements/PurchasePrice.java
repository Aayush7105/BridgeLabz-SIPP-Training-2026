import java.util.Scanner;

public class PurchasePrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter unit price:");
        double unitPrice = input.nextDouble();

        System.out.println("Enter quantity:");
        int quantity = input.nextInt();

        double totalPurchasePrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPurchasePrice
                + " if the quantity " + quantity + " and unit price is INR " + unitPrice);

        input.close();
    }
}
