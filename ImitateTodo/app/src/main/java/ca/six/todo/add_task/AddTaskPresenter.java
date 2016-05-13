package ca.six.todo.add_task;

import ca.six.todo.model.TaskManager;

/**
 * Created by songzhw on 2016-05-13.
 */
public class AddTaskPresenter {
    public AddTaskActivity view;
    public TaskManager model;

    public AddTaskPresenter(AddTaskActivity view) {
        this.view = view;
        this.model = TaskManager.getInstance(view);
    }

    public void addTask(String text){
        model.saveTask(text);
        view.finishAdd();
    }
}
