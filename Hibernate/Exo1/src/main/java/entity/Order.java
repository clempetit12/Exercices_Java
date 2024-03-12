package entity;

import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

    private Date orderPurchase;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "id_adress", referencedColumnName = "id_adress")
    private Adress adress;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_Product")
    )
    List<Product> productList;
    private Double total;

    public Order() {

    }


    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }


    public Order(Date orderPurchase, Adress adress, List<Product> productList, Double total) {
        this.orderPurchase = orderPurchase;
        this.adress = adress;
        this.productList = productList;
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Orders{");
        result.append("idOrder=").append(idOrder);
        result.append(", orderPurchase=").append(orderPurchase);
        result.append(", productList=");
        Hibernate.initialize(productList);

        result.append(productList);
        result.append(", total=").append(total);
        result.append('}');
        return result.toString();
    }

}
