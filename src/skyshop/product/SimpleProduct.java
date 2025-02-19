package skyshop.product;

public class SimpleProduct extends Product{
    int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
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
