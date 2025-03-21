package skyshop.basket;

import skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> basket = new TreeMap<>();
    private int counter = 0;

    public void addProduct(Product product) {
        List<Product> products = new ArrayList<>();
        products.add(product);
        basket.put(product.getNameProduct(), products);
        counter++;
    }

    public int calculateAmount() {
        int sum = 0;

        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return sum;
        }
        for (Map.Entry<String, List<Product>> product : basket.entrySet()) {
            List<Product> products = product.getValue();
            for (Product product1 : products)
                sum = sum + product1.getPrice();
        }
        return sum;
    }

    public void printContent() {
        int special = 0;
        List<Product> allProducts = new ArrayList<>();
        for (List<Product> products : basket.values()) {
            allProducts.addAll(products);
        }
        for (Product product : allProducts) {
            if (product.isSpecial()) {
                special++;
            }
        }
        System.out.println(allProducts);
        System.out.println("Сумма покупок: " + calculateAmount());
        if (special != 0) {
            System.out.println("Специальных товаров: " + special);
        }
    }

    public void clearBasket() {
        basket.clear();
    }

    public void removeProduct(String name) {
        if (name == null) {
            System.out.println("Запрос на удаление пуст");
        }
        if (counter == 0) {
            System.out.println("Корзина пуста");
        }else {
            basket.remove(name);
            counter--;
        }
    }
}

