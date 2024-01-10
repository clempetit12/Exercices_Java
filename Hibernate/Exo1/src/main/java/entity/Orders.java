package entity;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

    private Date orderPurchase;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "id_adress", referencedColumnName = "id_adress")
    private Adress adress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Product> productList;
    private Double total;

    public Orders() {

    }


    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }


    public Orders(Date orderPurchase, Adress adress, List<Product> productList, Double total) {
        this.orderPurchase = orderPurchase;
        this.adress = adress;
        this.productList = productList;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", orderPurchase=" + orderPurchase +
                ", productList=" +  productList +
                ", total=" + total +
                '}';
    }
}
