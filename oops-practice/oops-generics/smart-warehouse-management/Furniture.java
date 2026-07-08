
public class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String id, String name, String material) {
        super(id, name);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Furniture{" + super.toString() + ", material='" + material + "'}";
    }
}
