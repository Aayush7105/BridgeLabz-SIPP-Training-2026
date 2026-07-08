
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product<?>> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(newPrice);
    }

    public void displayAllProducts() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        BookCategory bookCategory = new BookCategory("Fiction");
        Product<BookCategory> book = new Product<>("Java Book", 50.0, bookCategory);

        ClothingCategory clothingCategory = new ClothingCategory("Men's Wear");
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 30.0, clothingCategory);

        catalog.addProduct(book);
        catalog.addProduct(shirt);

        System.out.println("Before discount:");
        catalog.displayAllProducts();

        catalog.applyDiscount(book, 10);
        catalog.applyDiscount(shirt, 20);

        System.out.println("\nAfter discount:");
        catalog.displayAllProducts();
    }
}
