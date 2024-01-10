package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image", nullable = false)
    private Long idImage;

    private String url;

    @ManyToOne
    @JoinColumn(name = "id_Product")
    private Product product;

    public Image() {
    }

    public Image(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", url='" + url + '\'' +
                '}';
    }
}
