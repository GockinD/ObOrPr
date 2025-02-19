package skyshop;

import skyshop.product.DiscountedProduct;
import skyshop.product.FixPriceProduct;
import skyshop.product.Product;

import skyshop.basket.ProductBasket;
import skyshop.product.SimpleProduct;

class App {
    public static void main(String[] args) {
        SimpleProduct tomato = new SimpleProduct("Помидор", 120);
        FixPriceProduct cucumber = new FixPriceProduct("Огурец");
        DiscountedProduct bread = new DiscountedProduct("Хлеб", 30, 5);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 30, 5);
        SimpleProduct sausage = new SimpleProduct("Колбаса", 270);
        FixPriceProduct aceCream = new FixPriceProduct("Мороженое");

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