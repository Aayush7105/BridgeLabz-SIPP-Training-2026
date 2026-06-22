public class CartItem {

    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int quantityToAdd) {
        if (quantityToAdd > 0) {
            quantity += quantityToAdd;
            System.out.println(quantityToAdd + " item(s) added.");
        } else {
            System.out.println("Invalid quantity.");
        }
    }

    void removeItem(int quantityToRemove) {
        if (quantityToRemove <= 0) {
            System.out.println("Invalid quantity.");
        } else if (quantityToRemove <= quantity) {
            quantity -= quantityToRemove;
            System.out.println(quantityToRemove + " item(s) removed.");
        } else {
            System.out.println("Not enough items in the cart.");
        }
    }

    double calculateTotalCost() {
        return price * quantity;
    }

    void displayTotalCost() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: Rs. " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: Rs. " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CartItem cartItem = new CartItem("Pen", 10, 5);
        cartItem.addItem(3);
        cartItem.removeItem(2);
        cartItem.displayTotalCost();
    }
}
