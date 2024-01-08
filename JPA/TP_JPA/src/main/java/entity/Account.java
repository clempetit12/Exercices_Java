package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    private String wording;

    @Column(nullable = false, length = 27)
    private String Iban;

    @Column(precision = 10, scale = 2)
    private BigDecimal sold;

    @ManyToMany(mappedBy = "accountList", cascade = {CascadeType.MERGE, CascadeType.PERSIST} )
    private List<Customer> customerList = new ArrayList<>();
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    public Account(String wording, String iban, BigDecimal sold, Agency agency) {
        this.wording = wording;
        Iban = iban;
        this.sold = sold;
        this.agency = agency;
    }

    public Account(String wording, String iban, Agency agency) {
        this.wording = wording;
        Iban = iban;
        this.agency = agency;
    }

    public Account() {
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }

    public BigDecimal getSold() {
        return sold;
    }

    public void setSold(BigDecimal sold) {
        this.sold = sold;
    }


    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", wording='" + wording + '\'' +
                ", Iban='" + Iban + '\'' +
                ", sold=" + sold +
                '}';
    }
}
