
public class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String id, String name, String brand) {
        super(id, name);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Electronics{" + super.toString() + ", brand='" + brand + "'}";
    }
}
