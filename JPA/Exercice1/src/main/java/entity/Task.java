package entity;

import javax.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Transient
    private boolean completeed;
    @Column(name = "completeed")
    private String completeedString;

    public Task(String title, boolean completeed) {
        this.title = title;
        this.completeed = completeed;
    }

    public Task() {
    }

    public Task(String title) {
        this.title = title;
        this.completeed = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleteed() {
        return completeed;
    }

    public void setCompleteed(boolean completeed) {
        this.completeed = completeed;
    }

    public void setCompleteedString(String completedString) {
        this.completeedString = completedString;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completeed=" + completeedString +
                '}';
    }
}
