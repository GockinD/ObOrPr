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

import java.util.*;

class App {
    public static void main(String[] args) {
        SimpleProduct tomato = new SimpleProduct("Помидор120", 120);
        SimpleProduct tomato1 = new SimpleProduct("Помидор130", 130);
        SimpleProduct tomato2 = new SimpleProduct("Помидор90", 90);
        SimpleProduct tomato3 = new SimpleProduct("Помидор80", 80);
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
        System.out.println();

        ProductBasket basket = new ProductBasket();

        basket.addProduct(tomato);
        basket.addProduct(tomato1);
        basket.addProduct(tomato2);
        basket.addProduct(tomato3);
        basket.addProduct(sausage);
        basket.addProduct(cucumber);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.printContent();
        System.out.println();

        SearchEngine searchEngines = new SearchEngine(10);
        searchEngines.add(tomato);
        searchEngines.add(tomato1);
        searchEngines.add(tomato2);
        searchEngines.add(tomato3);
        searchEngines.add(cucumber);
        searchEngines.add(bread);
        searchEngines.add(milk);
        searchEngines.add(sausage);
        searchEngines.add(aceCream);

        Article tomatoes = new Article("Помидоры", "Помидоры в большинстве случаев красные");
        Article cucumbers = new Article("Огурцы", "Огурцы всега зеленые");
        Article breads = new Article("Хлебы", "Хлебы всега сытные");

        searchEngines.add(tomatoes);
        searchEngines.add(cucumbers);
        searchEngines.add(breads);

        System.out.println(searchEngines.search("Помидор"));
        System.out.println();
        System.out.println(searchEngines.search("Огурец"));
        System.out.println();
        System.out.println(searchEngines.search("Огурцы"));
        System.out.println();

        try {
            Set<String> bestMatch = searchEngines.findBestMatch("Помидор");
            System.out.println(bestMatch);
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }

        try {
            Set<String> bestMatch = searchEngines.findBestMatch("апель");
            System.out.println(bestMatch);
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        try {
            Set<String> bestMatch = searchEngines.findBestMatch("");
            System.out.println(bestMatch);
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
        System.out.println();

        basket.printContent();
        basket.removeProduct("Огурец");
        System.out.println();
        basket.printContent();
        System.out.println();
        basket.removeProduct("апельсин");
        basket.printContent();
        System.out.println();

        System.out.println(searchEngines.search("Помидор"));

        basket.clearBasket();
        basket.printContent();
    }
}