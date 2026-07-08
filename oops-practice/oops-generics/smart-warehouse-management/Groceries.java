
public class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Groceries{" + super.toString() + ", expiryDate='" + expiryDate + "'}";
    }
}
