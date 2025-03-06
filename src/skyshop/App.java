package skyshop;

import skyshop.article.Article;
import skyshop.product.DiscountedProduct;
import skyshop.product.FixPriceProduct;
import skyshop.product.Product;

import skyshop.basket.ProductBasket;
import skyshop.product.SimpleProduct;
import skyshop.search.SearchEngine;
import skyshop.search.BestResultNotFound;
import skyshop.search.Searchable;

import java.util.Arrays;

class App {
    public static void main(String[] args) {
        SimpleProduct tomato = new SimpleProduct("Помидор", 120);
        FixPriceProduct cucumber = new FixPriceProduct("Огурец");
        DiscountedProduct bread = new DiscountedProduct("Хлеб", 30, 5);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 30, 5);
        SimpleProduct sausage = new SimpleProduct("Колбаса", 270);
        FixPriceProduct aceCream = new FixPriceProduct("Мороженое");
        try {
            SimpleProduct potato = new SimpleProduct("Картофель", -120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            SimpleProduct apple = new SimpleProduct("", 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct banana = new DiscountedProduct("Банан", 70, 120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

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

        SearchEngine searchEngines = new SearchEngine(10);
        searchEngines.add(tomato);
        searchEngines.add(cucumber);
        searchEngines.add(bread);
        searchEngines.add(milk);
        searchEngines.add(sausage);
        searchEngines.add(aceCream);

        Article tomatoes = new Article("Томаты", "Томаты в большинстве случаев красные");
        Article cucumbers = new Article("Огурцы", "Огурцы всега зеленые");
        Article breads = new Article("Хлебы", "Хлебы всега сытные");

        searchEngines.add(tomatoes);
        searchEngines.add(cucumbers);
        searchEngines.add(breads);

        System.out.println(Arrays.toString(searchEngines.search("Помидор")));
        System.out.println(Arrays.toString(searchEngines.search("Огурец")));
        System.out.println(Arrays.toString(searchEngines.search("Огурцы")));

        try {
            Searchable bestMatch = searchEngines.findBestMatch("Помидор");
            System.out.println(bestMatch);
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        try {
            Searchable bestMatch = searchEngines.findBestMatch("апель");
            System.out.println(bestMatch);
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        try {
            Searchable bestMatch = searchEngines.findBestMatch("");
            System.out.println(bestMatch);
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }

    }




}