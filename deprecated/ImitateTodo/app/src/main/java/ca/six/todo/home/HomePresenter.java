package ca.six.todo.home;

import java.util.List;

import ca.six.todo.Injection;
import ca.six.todo.model.ITaskManager;
import ca.six.todo.model.Task;
import ca.six.todo.model.TaskManager;
import ca.six.util.L;

/**
 * Created by songzhw on 2016-05-12.
 */
public class HomePresenter {
    public ITaskManager model;
    private HomeActivity view;

    public HomePresenter(HomeActivity view) {
        this.view = view;

//        model = TaskManager.getInstance(view);
        model = Injection.getModel(view);
    }


    public void getTasks() {
        L.d("home");
        List<Task> tasks = model.getTasks();
        view.showTasks(tasks);
    }
}
