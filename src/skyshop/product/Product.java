package skyshop.product;

import skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String nameProduct) throws IllegalArgumentException {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Имя продукта указано неверно");
        }
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

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    public abstract boolean isSpecial();
}


