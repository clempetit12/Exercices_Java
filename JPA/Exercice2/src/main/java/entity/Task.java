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
    @Column(name = "completeed")
    private boolean completeed;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "task_id", referencedColumnName = "taskInfo_id")
    private TaskInfo taskInfo;

    public Task(String title, boolean completeed) {
        this.title = title;
        this.completeed = completeed;
    }

    public Task(String title, TaskInfo taskInfo) {
        this.title = title;
        this.taskInfo = taskInfo;
        this.completeed = false;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completeed=" + completeed +
                ", taskInfo=" + taskInfo +
                '}';
    }
}
