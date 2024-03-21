package composite.products;

public class SimpleProduct extends AbstractProduct {

    protected String brand;

    public SimpleProduct(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

}
