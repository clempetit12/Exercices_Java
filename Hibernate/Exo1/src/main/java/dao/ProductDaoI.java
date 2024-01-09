package dao;

import entity.Product;

import java.util.Date;
import java.util.List;

public interface ProductDaoI {

    public boolean createProduct (Product product);
    public Product getProductById(Long id);

    public void deleteProduct(Long id);

    public boolean updateProduct(Long id, String brand, String reference, Date purchaseDate, Double price, int stock);

    public List<Product> getAllProducts();
    public List<Product> getProductsByPrice(Double price);
    public List<Product> getproductsByDate(Date date1, Date date2);

}
