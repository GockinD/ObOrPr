package skyshop.product;

public class SimpleProduct extends Product{
    int price;

    public SimpleProduct(int price) {
        super();
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
