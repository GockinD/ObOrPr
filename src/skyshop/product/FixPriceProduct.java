package skyshop.product;

public class FixPriceProduct extends Product{
    private static final int PRICE = 49;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return super.toString() + " с фиксированной ценой: Фиксированная цена " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
