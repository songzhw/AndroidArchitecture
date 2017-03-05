package ca.six.todo.biz.add_task;

/**
 * Created by songzhw on 2017-03-05
 */

public interface IAddTaskView {
    void addedTask(String name, String desp);
    void addedFailed();
}
