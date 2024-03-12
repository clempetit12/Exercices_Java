package entity;

import lombok.Data;

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
    private List<Order> orderList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> imageList ;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Comment> commentList;
    public Product(String brand, String reference, Date purchaseDate, Double price, int stock) {
        this.brand = brand;
        this.reference = reference;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.stock = stock;
        this.imageList = new ArrayList<>();
   this.commentList = new ArrayList<>();
    }

    public Product(String brand, String reference, Date purchaseDate, Double price, int stock, List<Image> imageList, List<Comment> commentList) {
        this.brand = brand;
        this.reference = reference;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.stock = stock;
        this.imageList = imageList;
        this.commentList = commentList;
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

    public void addToCommentList( Comment comment) {
        commentList.add(comment);
        comment.setProduct(this);
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
                ", commentsList=" + commentList +
                '}';
    }
}
