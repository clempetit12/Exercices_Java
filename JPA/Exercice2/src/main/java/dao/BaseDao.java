package dao;

import entity.Task;
import entity.TaskInfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public abstract class BaseDao<T> {

    public abstract boolean addTask(T element);
    public abstract List<Task> displayTasks();
    public abstract boolean taskCompleteed(Long id);


    public abstract boolean removeTask(Long id);
    public abstract boolean update(Long id, String title, String description, Date endingDate, Integer priority);

    public abstract boolean addTaskInfo(TaskInfo element);


}
