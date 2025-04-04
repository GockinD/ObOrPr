package skyshop.product;

public class SimpleProduct extends Product{
    double price;

    public SimpleProduct(String nameProduct, double price) throws IllegalArgumentException {
        super(nameProduct);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
