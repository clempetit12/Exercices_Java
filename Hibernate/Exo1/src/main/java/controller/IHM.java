package controller;

import dao.*;
import entity.*;
import entity.Orders;
import org.hibernate.Hibernate;
import service.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class IHM {

    private Scanner scanner = new Scanner(System.in);
    private int choix;
    private static ProductService productService;
    private static ProductDao productDao;

    private static ImageService imageService;
    private static ImageDao imageDao;
    private static CommentService commentService;
    private static CommentDao commentDao;
    private static OrdersService ordersService;
    private static OrdersDao ordersDao;
    private static AdressService adressService;
    private static AdressDao adressDao;

    public IHM() {
        productDao = new ProductDao();
        productService = new ProductService(productDao);
        imageDao = new ImageDao();
        imageService = new ImageService(imageDao);
        commentDao = new CommentDao();
        commentService = new CommentService(commentDao);
        ordersDao=new OrdersDao();
        ordersService=new OrdersService(ordersDao);
        adressDao=new AdressDao();
        adressService=new AdressService(adressDao);
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
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProduct();
                    break;
                case 5:
                    displayAllProducts();
                    break;
                case 6:
                    displayProductsByPrice();
                    break;
                case 7:
                    displayProductsByDate();
                    break;
                case 8:
                    displayProductsByStock();
                    break;
                case 9:
                    displayValueStockBrand();
                    break;
                case 10:
                    displayAveragePriceProducts();
                    break;
                case 11:
                    displayProductsFromBrand();
                    break;
                case 12:
                    deleteProductsFromBrand();
                    break;
                case 13:
                    displayProductsByGrade();
                    break;
                case 14:
                    createorders();
                    break;
                case 15:
                    displayAllOrders();
                    break;
                case 0:
                    closeAll();
                    break;
                default:
                    System.out.println("choix invalide !");
            }

        } while (choix != 0);
    }

    private void displayAllOrders() {
        List<Orders> ordersList = ordersService.displayAllOrderss();
        for (Orders o : ordersList) {

            System.out.println("Elements de la commande : " + o);

        }
    }

    private void createorders() {
        Date date = new Date();

        try {
            System.out.println("Combien de produits souhaitez vous ajouter à la commande ");
            int nombreProduit = scanner.nextInt();
            scanner.nextLine();
            List<Product> productList = new ArrayList<>();
            Double total = 1.0;
            for (int i = 0; i < nombreProduit; i++) {
                System.out.println("Veuillez indiquer l'id des produits que vous souhaitez ajouter à la commande : ");
                Long idProduct = scanner.nextLong();
                System.out.println("Veuillez indiquer la quantité à ajouter : ");
                int quantity = scanner.nextInt();
                Product product = productService.getProductById(idProduct);
                product.setStock(product.getStock()-quantity);
                productService.updateProduct(idProduct,product);
                Double price = product.getPrice();
                productList.add(product);
                total += quantity*price;
            }
            System.out.println("Adresse de la commande");
            System.out.println("Veuillez saisir la ville de la commande");
            String city = scanner.next();
            System.out.println("Veuillez saisir la rue");
            String street = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Veuillez saisir le codePostal");
            int codePostal = scanner.nextInt();
            scanner.nextLine();
            Adress adress1 = new Adress(street,city,codePostal);
            adressService.createAdress(adress1);
            Orders order = new Orders(date,adress1,productList,total);
            order.setAdress(adress1);
            ordersService.updateOrder(order.getIdOrder(),order);
            for (Product p: order.getProductList()
                 ) { p.setOrder(order);
            }
            System.out.println(order);
            ordersService.createOrders(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayProductsByGrade() {
        System.out.println("Veuillez saisir la note dont vous voulez voir les produits qui ont une note supérieure : ");
        int grade = scanner.nextInt();
        scanner.nextLine();
        List<Product> productList = productService.displayProductsByGrade(grade);
        for (Product p : productList) {
            System.out.println("Voici les produits qui ont une note supérieure à " + grade + " : " + p);
        }
    }

    private Image createImage() {
        System.out.println("Veuillez saisir le lien url de l'image : ");
        String url = scanner.next();
        Image image = new Image(url);
        imageService.createImage(image);
        return image;
    }

    private Comments createComment() {
        try {
            System.out.println("Veuillez saisir un commentaire : ");
            String content = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Veuillez saisir la date du commentaire (format dd-MM-yyyy) ? :");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);
            System.out.println("Veuillez donner une note au commentaire");
            int grade = scanner.nextInt();
            scanner.nextLine();
            Comments comments = new Comments(content, date, grade);
            return comments;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void createProduct() {
        try {
            System.out.println("Combien de produits souhaitez vous ajouter ");
            int nombreProduit = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < nombreProduit; i++) {
                Product product = productInfo();
                productService.createProduct(product);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProduct() {
        try {
            System.out.println("Quel est l'id du produit que vous voulez modifier' ? :");
            Long id = scanner.nextLong();
            Product product = productService.getProductById(id);
            if (product != null) {
                Product product1 = productInfo();
                productService.updateProduct(id, product1);
            } else {
                System.out.println("Aucune produit avec id " + id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Product productInfo() {
        try {

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
            List<Image> imageList = new ArrayList<>();
            Image image = createImage();
            imageList.add(image);
            Comments comments = createComment();
            List<Comments> commentsList = new ArrayList<>();
            commentsList.add(comments);
            Product product = new Product(brand, reference, date, price, stock, imageList, commentsList);
            product.addToImageList(image);
            product.addToCommentList(comments);
            product.setCommentsList(commentsList);
            return product;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void deleteProduct() {
        try {
            System.out.println("Quel est l'id du produit que vous voulez supprimer' ? :");
            Long id = scanner.nextLong();
            Product product = productService.getProductById(id);
            if (product != null) {
                productService.deleteProduct(id);
            } else {
                System.out.println("Aucun produit avec id " + id);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayProduct() {
        try {
            System.out.println("Quel est l'id du produit que vous voulez afficher' ? :");
            Long id = scanner.nextLong();
            Product product = productService.getProductById(id);
            if (product != null) {
                System.out.println(product);
            } else {
                System.out.println("Aucun produit avec id " + id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayAllProducts() {
        List<Product> productList = productService.getAllProducts();
        if (productList != null) {
            for (Product p : productList
            ) {
                System.out.println(p);

            }
        } else {
            System.out.println("Il n'y a pas de liste de produits");
        }

    }

    private void displayProductsByPrice() {
        try {
            System.out.println("Renseigner le prix pour afficher les produits dont le prix est supérieur : ");
            Double price = scanner.nextDouble();
            List<Product> productList = productService.getProductsByPrice(price);
            if (productList != null && !productList.isEmpty()) {
                for (Product p : productList
                ) {
                    System.out.println("Les produits dont le prix est supérieur à " + price + " sont :" + p);
                }
            } else {
                System.out.println("Pas de produits dont le prix est inférieur à " + price);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayProductsByDate() {
        try {
            System.out.println("Indiquer la première date (format dd-MM-yyyy) ? :");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = formatter.parse(date_string);
            System.out.println("Indiquer la première date (format dd-MM-yyyy) ? :");
            String date_string2 = scanner.next();
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
            Date date2 = formatter2.parse(date_string2);
            if (date1.after(date2)) {
                System.out.println("Erreur : La première date doit être avant la deuxième date. Veuillez réessayer.");
            }
            List<Product> productList = productService.getProductsByDate(date1, date2);
            if (productList != null && !productList.isEmpty()) {
                for (Product p : productList
                ) {
                    System.out.println("Les produits dont l'achat est compris entre les date " + date1 + " et " + date2 + " sont " + p);
                }
            } else {
                System.out.println("Pas de produits dont l'achat est compris entre "
                        + date1 + " et " + date2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayProductsByStock() {
        try {
            System.out.println("Indiquez le stock référent pour afficher les produits dont le stock est inférieur : ");
            int stock = scanner.nextInt();
            scanner.nextLine();
            List<Product> productList = productService.getProductsByStock(stock);
            if (productList != null && !productList.isEmpty()) {
                for (Product p : productList
                ) {
                    System.out.println("L'id du produit est " + p.getIdProduct() + " et sa référence est : " + p.getReference()
                            + "le stock est de " + p.getStock());

                }
            } else {
                System.out.println("Pas de produits dont le stock est inférieur à " + stock);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayValueStockBrand() {
        try {
            System.out.println("Précisez la marque dont vous souhaitez afficher la valeur des stocks");
            String brand = scanner.next();
            List<Double> productList = productService.getValueStockBrand(brand);
            if (productList != null && !productList.isEmpty()) {
                for (Double i : productList
                ) {
                    System.out.println("La valeur du stock pour le produit de la marque  " + brand + " est : " + i + " €");

                }
                Double totalValueStock = productService.getTotalValueStock(brand);
                System.out.println("La valeur totale du stock est de " + totalValueStock + " €");
            } else {
                System.out.println("Pas de produits correspondants");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayAveragePriceProducts() {
        try {
            Double averagePrice = productService.getAveragePrice();
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formatedPrice = decimalFormat.format(averagePrice);
            System.out.println("Le prix moyen des produits est de " + formatedPrice + " € ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void displayProductsFromBrand() {
        try {
            System.out.println("Précisez la marque dont vous souhaitez afficher les produits : ");
            String brand = scanner.next();
            List<Product> productList = productService.getProductsFromBrand(brand);
            if (productList != null && !productList.isEmpty()) {
                for (Product p : productList
                ) {
                    System.out.println("Le produit de la marque " + brand + " est le suivant " + p);
                }
            } else {
                System.out.println("Aucun produit correspondant à la marque "
                        + brand);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteProductsFromBrand() {
        try {
            System.out.println("Précisez la marque dont vous souhaitez supprimer les produits : ");
            String brand = scanner.next();
            productService.deleteProductFromBrand(brand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void closeAll() {
        scanner.close();
        productService.close();
    }

    private void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Créer produits");
        System.out.println("2. Modifier les informations d'un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher informations d'un produit");
        System.out.println("5. Afficher la totalité des produits");
        System.out.println("6. Afficher les produits dont le prix est supérieur au montant précisé");
        System.out.println("7. Afficher les produits achetés entre deux dates");
        System.out.println("8. Afficher les produits dont le stock est inférieur au montant précisé");
        System.out.println("9. Afficher la valeur du stock d'une marque");
        System.out.println("10. Afficher le prix moyen des produits");
        System.out.println("11. Afficher la liste des produits d'une marque choisie");
        System.out.println("12. Supprimer les produits d'une marque choisie");
        System.out.println("13. Afficher produits avec note supérieur à la note renseignée");
        System.out.println("14. Créer une ou plusieurs commandes");
        System.out.println("15. Afficher toutes les commandes");

        System.out.println("0. Quitter");
        System.out.println("Saisissez votre choix :");

    }
}
