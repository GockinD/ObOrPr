package skyshop;

import skyshop.product.Product;

import skyshop.basket.ProductBasket;

class App {
    public static void main(String[] args) {
        Product tomato = new Product("Помидор", 120);
        Product cucumber = new Product("Огурец", 100);
        Product bread = new Product("Хлеб", 30);
        Product milk = new Product("Молоко", 30);
        Product sausage = new Product("Колбаса", 270);
        Product aceCream = new Product("Мороженое", 270);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(tomato);
        basket.addProduct(sausage);
        basket.addProduct(cucumber);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(aceCream);

        basket.printContent();

        System.out.println(basket.calculateAmount());

        System.out.println(basket.searchProduct("Молоко"));
        System.out.println(basket.searchProduct("Мороженое"));

        basket.clearBasket();
        basket.printContent();
        System.out.println(basket.calculateAmount());
        System.out.println(basket.searchProduct("Молоко"));
    }
}