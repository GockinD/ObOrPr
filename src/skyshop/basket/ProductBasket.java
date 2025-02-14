package skyshop.basket;

import skyshop.product.Product;

public class ProductBasket {
    private Product[] basket = new Product[5];
    private int counter;

    public void addProduct(Product product) {
        if (counter > 4) {
            System.out.println("Невозможно добавить продукт");
        } else
            basket[counter] = product;
        counter++;
    }

    public int calculateAmount() {
        boolean emptyBasket = true;
        int sum = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                emptyBasket = false;
                sum = sum + basket[i].getPrice();
            }
        }
        if (emptyBasket) {
            System.out.println("В корзине пусто");
        }
        return sum;
    }

    public void printContent() {
        boolean emptyBasket = true;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                emptyBasket = false;
                System.out.println(basket[i].toString());
            }
        }
        if (emptyBasket) {
            System.out.println("В корзине пусто");
        }else {
            System.out.println("Итого: " + calculateAmount());
        }
    }

    public boolean searchProduct(String name) {
        boolean emptyBasket = true;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null && basket[i].getNameProduct().equals(name)) {
                emptyBasket = false;
                return true;
            }
        }
        if (emptyBasket) {
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
