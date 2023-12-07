package org.example;

import org.example.classes.Product;
import org.example.classes.StockManager;
import org.example.classes.Supplier;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();
        product.registerObserver(stockManager);
        product.registerObserver(supplier);

        product.randomStock();
        product.removeObserver(stockManager);
        product.randomStock();
        

    }
}