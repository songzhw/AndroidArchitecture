package ca.six.todo.biz.tasks;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import ca.six.todo.databinding.ActivityTasksBinding;
import ca.six.todo.data.Task;

/**
 * Created by songzhw on 2017-03-04
 */

public class TasksViewModel extends BaseObservable {
    public ObservableList<Task> tasks = new ObservableArrayList<>();

    private ITasksView view;

    public TasksViewModel(ActivityTasksBinding binding, ITasksView view){
        binding.setVm(this);
        this.view = view;
    }

    public void addNewTask(View v){
        view.gotoAddTask();
    }

    public void getNewTaskInfo(String name, String desp) {
        Task task = new Task(name, desp, false);
        tasks.add(task);
        view.refresh(tasks.subList(0, tasks.size()));
    }
}
