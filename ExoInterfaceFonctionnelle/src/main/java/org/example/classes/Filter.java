package org.example.classes;

import java.util.ArrayList;

public class Filter {

    public ArrayList<Product> listproducts = new ArrayList<>();


    public static void  filterProducts (ArrayList<Product> listProducts, InterfaceFonctionnelleFiltrage  methode) {
        for (Product product: listProducts) {
           if( methode.filterProduct(product)){
               System.out.println(product);
           }
        }

    }
}
