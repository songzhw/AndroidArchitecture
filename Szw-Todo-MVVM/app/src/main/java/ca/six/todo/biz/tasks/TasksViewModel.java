package ca.six.todo.biz.tasks;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;

import ca.six.todo.databinding.ActivityTasksBinding;
import ca.six.todo.model.Task;

/**
 * Created by songzhw on 2017-03-04
 */

public class TasksViewModel extends BaseObservable {
    public ObservableList<Task> tasks = new ObservableArrayList<>();

    public TasksViewModel(ActivityTasksBinding binding){
        binding.setVm(this);
    }

    public void addNewTask(View v){
        System.out.println("szw Add New Task");
    }
}
