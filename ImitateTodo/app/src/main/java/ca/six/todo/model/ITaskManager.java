package ca.six.todo.model;

import java.util.List;

/**
 * Created by songzhw on 2016-05-11.
 */
public interface ITaskManager {
    List<Task> getTasks();

    void saveTask(String text);
}
