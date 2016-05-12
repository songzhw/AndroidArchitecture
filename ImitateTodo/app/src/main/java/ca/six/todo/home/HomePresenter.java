package ca.six.todo.home;

import java.util.List;

import ca.six.todo.model.ITaskManager;
import ca.six.todo.model.Task;
import ca.six.todo.model.TaskManager;

/**
 * Created by songzhw on 2016-05-12.
 */
public class HomePresenter {
    private ITaskManager model;
    private HomeActivity view;

    public HomePresenter(HomeActivity view) {
        this.view = view;
        model = TaskManager.getInstance(view);
    }


    public void getTasks() {
        List<Task> tasks = model.getTasks();
        view.showTasks(tasks);
    }
}
