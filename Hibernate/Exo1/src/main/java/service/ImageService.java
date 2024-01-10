package service;

import dao.ImageDao;
import dao.ProductDao;
import entity.Image;
import entity.Product;

import java.util.Date;
import java.util.List;

public class ImageService {

    private ImageDao imageDao;

    public ImageService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public boolean createImage(Image image) {
        return imageDao.create(image);
    }

    public Image getImageById(Long id) {
        return imageDao.getById(id);
    }
    public boolean updateImage(Long id,Product product) {
        return imageDao.updateImage(id,product);
    }

}
