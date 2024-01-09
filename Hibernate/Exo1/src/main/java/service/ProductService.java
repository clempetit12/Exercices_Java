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
return productDao.create(product);
    }

    public Product getProductById(Long id) {
        return productDao.getById(id);
    }

    public void deleteProduct(Long id) {
        productDao.delete(id);
    }

    public boolean updateProduct(Long id, Product product){
       return productDao.update(id,product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }
    public List<Product> getProductsByPrice(Double price) {
        return productDao.getByPrice(price);
    }
    public List<Product> getProductsByDate(Date date1, Date date2) {
        return productDao.getByDate(date1,date2);
    }

    public void close() {
        productDao.close();
    }

    public List<Product> getProductsByStock(int stock) {
        return  productDao.getByStock(stock);
    }

    public List<Integer> getStockBrand(String brand) {
        return productDao.getStockBrand(brand);
    }

    public Double getAveragePrice() {
        return productDao.getAveragePrice();
    }

    public List<Product> getProductsFromBrand(String brand) {
        return productDao.getProductsFromBrand(brand);
    }

    public void deleteProductFromBrand(String brand) {
        productDao.deleteProductBrand(brand);
    }

}
