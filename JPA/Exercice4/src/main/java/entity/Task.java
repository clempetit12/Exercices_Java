package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "taskList")
    private List<Category> categoryList = new ArrayList<>();

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "taskinfo_id", referencedColumnName = "taskInfo_id")
    private TaskInfo taskInfo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Task(String title, boolean completeed) {
        this.title = title;
        this.completeed = completeed;
    }

    public Task(String title, TaskInfo taskInfo) {
        this.title = title;
        this.taskInfo = taskInfo;
        this.completeed = false;
    }

    public Task(String title, boolean completeed, TaskInfo taskInfo, User user) {
        this.title = title;
        this.completeed = completeed;
        this.taskInfo = taskInfo;
        this.user = user;
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

    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.getTaskList().add(this);
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
