package skyshop.product;

import skyshop.search.Searchable;

import java.util.Objects;

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

    public abstract double getPrice();

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameProduct);
    }
}


