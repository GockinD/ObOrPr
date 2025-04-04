package skyshop.basket;

import skyshop.product.Product;
import skyshop.search.Searchable;

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

    public double calculateAmount() {
        int sum = 0;
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return sum;
        }
        return basket.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void printContent() {
        basket.forEach((name, products) ->
                System.out.println(products));

        System.out.println("Сумма покупки: " + calculateAmount());
        if (getSpecialCount() != 0) {
            System.out.println("Специальных товаров: " + getSpecialCount());
        }
    }

    private int getSpecialCount() {
        return (int) basket.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
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

