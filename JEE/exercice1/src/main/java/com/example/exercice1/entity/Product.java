package entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Product")
    private Long idProduct;

    private String brand;

    private String reference;

    private Date purchaseDate;

    private Double price;

    private int stock;

    public Product(String brand, String reference, Date purchaseDate, Double price, int stock) {
        this.brand = brand;
        this.reference = reference;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.stock = stock;
    }



    public Product() {
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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
                '}';
    }
}