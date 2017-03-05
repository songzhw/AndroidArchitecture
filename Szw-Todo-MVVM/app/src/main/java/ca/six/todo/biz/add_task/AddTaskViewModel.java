package ca.six.todo.biz.add_task;

import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by songzhw on 2017-03-05
 */

public class AddTaskViewModel {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> desp = new ObservableField<>();

    public void addedNewTask(View v) {
    }

}
