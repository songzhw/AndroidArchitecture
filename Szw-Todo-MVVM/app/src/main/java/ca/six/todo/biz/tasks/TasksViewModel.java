package ca.six.todo.biz.tasks;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import ca.six.todo.biz.add_task.AddTaskViewModel;
import ca.six.todo.databinding.ActivityTasksBinding;
import ca.six.todo.data.Task;
import ca.six.todo.utils.ToUtils;

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
        view.addNewTask();
    }
}
