package ca.six.todo.add_task;

import ca.six.todo.Injection;
import ca.six.todo.model.ITaskManager;
import ca.six.todo.model.TaskManager;
import ca.six.util.L;

/**
 * Created by songzhw on 2016-05-13.
 */
public class AddTaskPresenter {
    public AddTaskActivity view;
    public ITaskManager model;

    public AddTaskPresenter(AddTaskActivity view) {
        this.view = view;
//        this.model = TaskManager.getInstance(view);
        this.model = Injection.getModel(view);
    }

    public void addTask(String text){
        L.d("add");
        model.saveTask(text);
        view.finishAdd();
    }
}
