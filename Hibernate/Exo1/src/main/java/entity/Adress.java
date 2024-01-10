package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adress", nullable = false)
    private Long idAdress;

    private String street;
    private String city;
    private int postalCode;

    @OneToOne(mappedBy = "adress")
    private Orders orders;

    public Long getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(Long idAdress) {
        this.idAdress = idAdress;
    }

    public Adress(String street, String city, int postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Adress() {
    }

    @Override
    public String toString() {
        return "Adress{" +
                "idAdress=" + idAdress +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
