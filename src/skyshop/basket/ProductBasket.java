package skyshop.basket;

import skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    LinkedList<Product> basket = new LinkedList<>();
    private int counter = 0;

    public void addProduct(Product product) {
        basket.add(product);
        counter++;
    }

    public int calculateAmount() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum = sum + product.getPrice();
            }
        }
        if (counter == 0) {
            System.out.println("В корзине пусто");
        }
        return sum;
    }

    public void printContent() {
        int special = 0;
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Содержимое корзины: \n" + basket.toString());
            System.out.println("Итого: " + calculateAmount());
        }
        for (Product products : basket) {
            if (products.isSpecial()) {
                special++;
            }
        }
        System.out.println("Специальных товаров: " + special);
    }

    public boolean searchProduct(String name) {
        for (Product product : basket) {
            if (product != null && product.getNameProduct().equals(name)) {
                return true;
            }
        }
        if (counter == 0) {
            System.out.println("В корзине пусто");
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> removeProduct(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getNameProduct().contains(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}

