package skyshop.product;

public class Product {
    private String nameProduct;
    private int price;

    public Product(String nameProduct, int price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return nameProduct + ": " + price;
    }
}
