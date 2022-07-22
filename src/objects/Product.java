package objects;

public record Product(String name, float price) {

    public Product {
        if (name == null || name.equals("")) throw new IllegalStateException("Illegal name for product!");
        if (price <= 0) throw new IllegalStateException("Illegal price!");
    }


    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
