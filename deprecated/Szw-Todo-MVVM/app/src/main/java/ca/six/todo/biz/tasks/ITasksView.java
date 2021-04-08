package ca.six.todo.biz.tasks;

import java.util.List;

import ca.six.todo.data.Task;

/**
 * Created by songzhw on 2017-03-05
 */

public interface ITasksView {
    void gotoAddTask();
    void refresh(List<Task> tasks);
}
