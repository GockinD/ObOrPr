package skyshop.product;

public class DiscountedProduct extends Product{
    int basePrice;
    int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public double getDiscountedPrice() {
        double price;
        return price = basePrice * (1 - discount / 100.0);
    }

    @Override
    public int getPrice() {
        return (int)getDiscountedPrice();
    }

    @Override
    public String toString() {
        return super.toString() + " со скидкой: " + getDiscountedPrice() + " (скидка " + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
