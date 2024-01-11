package entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Product")
    private Long idProduct;

    private String brand;

    private String reference;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    private Double price;

    private int stock;

    @ManyToMany(mappedBy = "productList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> ordersList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> imageList ;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Comments> commentsList ;
    public Product(String brand, String reference, Date purchaseDate, Double price, int stock) {
        this.brand = brand;
        this.reference = reference;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.stock = stock;
        this.imageList = new ArrayList<>();
   this.commentsList = new ArrayList<>();
    }

    public Product(String brand, String reference, Date purchaseDate, Double price, int stock, List<Image> imageList, List<Comments> commentsList) {
        this.brand = brand;
        this.reference = reference;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.stock = stock;
        this.imageList = imageList;
        this.commentsList = commentsList;
    }

    public Product() {
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void addToImageList( Image image) {
        imageList.add(image);
        image.setProduct(this);
    }

    public void addToCommentList( Comments comments) {
        commentsList.add(comments);
        comments.setProduct(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", brand='" + brand + '\'' +
                ", reference='" + reference + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", stock=" + stock +
                ", imageList=" + imageList +
                ", commentsList=" + commentsList +
                '}';
    }
}
