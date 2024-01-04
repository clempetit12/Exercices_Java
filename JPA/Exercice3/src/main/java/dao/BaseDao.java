package dao;

import entity.Task;
import entity.TaskInfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public abstract class BaseDao<T> {

    public abstract boolean add(T element);
    public abstract List<Task> display();
    public abstract boolean taskCompleteed(Long id);


    public abstract boolean remove(Long id);
    public abstract boolean update(Long id, String title, String description, Date endingDate, Integer priority);

    public abstract boolean addTaskInfo(TaskInfo element);


}
