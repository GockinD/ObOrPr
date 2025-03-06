package skyshop.product;

public class SimpleProduct extends Product{
    int price;

    public SimpleProduct(String nameProduct, int price) throws IllegalArgumentException {
        super(nameProduct);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
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
