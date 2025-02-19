package skyshop.product;

public abstract class Product {
    private String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return nameProduct;
    }

    public abstract boolean isSpecial();
}

