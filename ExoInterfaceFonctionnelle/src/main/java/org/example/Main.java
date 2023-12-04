package org.example;

import org.example.classes.Filter;
import org.example.classes.Product;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("lavabo", 50, "entretien");
        Product product2 = new Product("aspirateur", 60, "entretien");
        Product product3 = new Product("chaise", 50, "mobilier");
        Product product4 = new Product("table", 50, "mobilier");

        ArrayList<Product> listProduct = new ArrayList<>();
        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);
        listProduct.add(product4);

        System.out.println("Produit qui appartiennent à la catégorie entretien");
       Filter.filterProducts(listProduct,produit -> produit.getCategory().equals("entretien"));

        System.out.println();

        System.out.println("Produit dont le prix est inférieur à 50€");
       Filter.filterProducts(listProduct, product -> product.getPrice() < 59);

        System.out.println();
        System.out.println("Produits qui contiennent les lettres la");
       Filter.filterProducts(listProduct,product -> product.getName().contains("la") );

        System.out.println();
        System.out.println("Produits qui ont un prix inférieur à 58€ et qui appartiennent à la categorie mobilier");
        Filter.filterProducts(listProduct, product -> product.getPrice() <58 && product.getCategory().equals("mobilier"));

    }
}