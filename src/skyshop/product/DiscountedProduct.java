package skyshop.product;

public class DiscountedProduct extends Product{
    int basePrice;
    int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) throws IllegalArgumentException{
        super(nameProduct);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100%");
        }
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
