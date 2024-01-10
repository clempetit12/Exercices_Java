package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comments", nullable = false)
    private Long idComments;

    private String content;
    private Date date;
    private int grade;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Comments(String content, Date date, int grade) {
        this.content = content;
        this.date = date;
        this.grade = grade;

    }

    public Comments() {
    }

    @Override
    public String toString() {
        return "Comments{" +
                "idComments=" + idComments +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", grade=" + grade +
                '}';
    }
}
