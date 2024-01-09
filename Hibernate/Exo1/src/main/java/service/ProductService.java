package service;

import dao.ProductDao;
import entity.Product;

import java.util.Date;
import java.util.List;

public class ProductService {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public boolean createProduct(Product product) {
return productDao.createProduct(product);
    }

    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }

    public boolean updateProduct(Long id, String brand, String reference, Date purchaseDate, Double price, int stock){
       return productDao.updateProduct(id,brand,reference,purchaseDate,price,stock);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
    public List<Product> getProductsByPrice(Double price) {
        return productDao.getProductsByPrice(price);
    }
    public List<Product> getProductsByDate(Date date1, Date date2) {
        return productDao.getproductsByDate(date1,date2);
    }

}
