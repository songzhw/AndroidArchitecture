package ca.six.todo.biz.tasks;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import ca.six.todo.model.Task;

/**
 * Created by songzhw on 2017-03-04
 */

public class TasksViewModel extends BaseObservable {
    public ObservableList<Task> tasks = new ObservableArrayList<>();

}
