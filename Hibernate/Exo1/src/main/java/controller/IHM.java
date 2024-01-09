package controller;

import dao.ProductDao;
import entity.Product;
import service.ProductService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private Scanner scanner = new Scanner(System.in);
    private int choix;
    private static ProductService productService;
    private static ProductDao productDao;

    public IHM() {
        productDao = new ProductDao();
        productService = new ProductService(productDao);


    }


    public void start() {
        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    displayAllProducts();
                    break;
                case 6:
                    displayProductsPrice();
                    break;
                case 7:
                    displayProductsDate();
                    break;
                case 0:
                    scanner.close();
                    break;
                default:
                    System.out.println("choix invalide !");
            }

        } while (choix != 0);
    }

    private void displayAllProducts() {
        for (Product p: productService.getAllProducts()
             ) {
            System.out.println(p);

        }
    }

    private void displayProductsPrice() {
        System.out.println("Renseigner le prix  : ");
        Double price = scanner.nextDouble();
        List<Product> productList = productService.getProductsByPrice(price);
        for (Product p: productList
             ) {
            System.out.println("Les produits dont le prix est supérieur à " + price + " sont :"+ p);
        }
    }

    private void displayProductsDate() {
        try {
            System.out.println("Indiquer la première date (format dd-MM-yyyy) ? :");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = formatter.parse(date_string);
            System.out.println("Indiquer la première date (format dd-MM-yyyy) ? :");
            String date_string2 = scanner.next();
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
            Date date2 = formatter2.parse(date_string2);
            List<Product> productList= productService.getProductsByDate(date1,date2);
            for (Product p: productList
            ) {
                System.out.println("Les produits dont l'achat est compris entre les date " + date1 + " et " + date2 + " sont " + p);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createProduct() {
        try {
            System.out.println("Combien de produits souhaitez vous ajouter ");
            int nombreProduit = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < nombreProduit; i++) {
                System.out.println("Quelle est la marque de votre produit ? :");
                String brand = scanner.next();
                System.out.println("Quelle est la référence de votre produit ? :");
                String reference = scanner.next();
                System.out.println("Quelle est la date d'achat de votre produit (format dd-MM-yyyy) ? :");
                String date_string = scanner.next();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(date_string);
                System.out.println("Quel est le prix de votre produit ? :");
                Double price = scanner.nextDouble();
                System.out.println("Quel est le stock de votre produit ? :");
                int stock = scanner.nextInt();
                scanner.nextLine();
                Product product = new Product(brand, reference, date, price, stock);
                productService.createProduct(product);


            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private void displayProduct() {
        System.out.println("Quel est l'id du produit que vous voulez afficher' ? :");
        Long id = scanner.nextLong();
        Product product = productService.getProductById(id);
        System.out.println(product);

    }


    public void deleteProduct() {
        System.out.println("Quel est l'id du produit que vous voulez supprimer' ? :");
        Long id = scanner.nextLong();
        productService.deleteProduct(id);

    }

    public void updateProduct() {
        try {
            System.out.println("Quel est l'id du produit que vous voulez modifier' ? :");
            Long id = scanner.nextLong();
            System.out.println("Quelle est la marque de votre produit ? :");
            String brand = scanner.next();
            System.out.println("Quelle est la référence de votre produit ? :");
            String reference = scanner.next();
            System.out.println("Quelle est la date d'achat de votre produit (format dd-MM-yyyy) ? :");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);
            System.out.println("Quel est le prix de votre produit ? :");
            Double price = scanner.nextDouble();
            System.out.println("Quel est le stock de votre produit ? :");
            int stock = scanner.nextInt();
            scanner.nextLine();
            productService.updateProduct(id, brand, reference, date, price, stock);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void printMenu() {
        System.out.println("=== Test ===");
        System.out.println("1. Créer produits");
        System.out.println("2. Afficher informations d'un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Modifier les informations d'un produit");
        System.out.println("5. Afficher la totalité des produits");
        System.out.println("6. Afficher les produits dont le prix est supérieur au montant précisé");
        System.out.println("7. Afficher les produits achetés entre deux dates");
        System.out.println("0. Quitter");
        System.out.println("Saisissez votre choix :");

    }
}
