package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;


    @Column(name = "user_name")
    private String userName;

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Task> taskList;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
        this.taskList = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void add(Task task) {
        taskList.add(task);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
