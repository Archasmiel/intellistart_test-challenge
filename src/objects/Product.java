package objects;

/**
 * User object<br>
 * • name String - product name<br>
 * • price float - product price
 */
public class Product {

    private final String name;
    private final float price;

    public Product(String name, float price) {
        if (name == null || name.equals("")) throw new IllegalStateException("Illegal name for product!");
        if (price <= 0) throw new IllegalStateException("Illegal price!");

        this.name = name;
        this.price = price;
    }


    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
