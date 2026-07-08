
import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E1", "Laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("E2", "Phone", "Apple"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G1", "Milk", "2026-07-10"));

        System.out.println("All items:");
        displayAllItems(electronicsStorage.getItems());
        displayAllItems(groceriesStorage.getItems());
    }
}
