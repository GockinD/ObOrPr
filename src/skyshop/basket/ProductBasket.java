package skyshop.basket;

import skyshop.product.Product;

public class ProductBasket {
    private Product[] basket = new Product[5];
    private int counter;

    public void addProduct(Product product) {
        if (counter == basket.length) {
            System.out.println("Невозможно добавить продукт");
        } else
            basket[counter] = product;
        counter++;
    }

    public int calculateAmount() {
        int sum = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                sum = sum + basket[i].getPrice();
            }
        }
        if (counter == 0) {
            System.out.println("В корзине пусто");
        }
        return sum;
    }

    public void printContent() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                System.out.println(basket[i].toString());
            }
        }
        if (counter == 0) {
            System.out.println("В корзине пусто");
        }else {
            System.out.println("Итого: " + calculateAmount());
        }
    }

    public boolean searchProduct(String name) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null && basket[i].getNameProduct().equals(name)) {
                return true;
            }
        }
        if (counter == 0) {
            System.out.println("В корзине пусто");
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
            counter = 0;
        }
    }
}
