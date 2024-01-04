package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tâcheInfo")
public class TaskInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskInfo_id")
    private Long id;

    @Column(name = "date_butoire")
    private Date finishDate;

    @Column(name = "priorité")
    private Integer priorityTask;

    @OneToOne(mappedBy = "taskInfo")
    private Task task;

    @Column(name = "description")
    private String description;


    public TaskInfo() {
    }

    public TaskInfo(Date finishDate, Integer priorityTask, Task task, String description) {
        this.finishDate = finishDate;
        this.priorityTask = priorityTask;
        this.task = task;
        this.description = description;
    }



    public Long getTaskInfo_id() {
        return id;
    }

    public void setTaskInfo_id(Long taskInfo_id) {
        this.id = id;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getPriorityTask() {
        return priorityTask;
    }

    public void setPriorityTask(Integer priorityTask) {
        this.priorityTask = priorityTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "id=" + id +
                ", finishDate=" + finishDate +
                ", priorityTask=" + priorityTask +
                ", description='" + description + '\'' +
                '}';
    }
}
