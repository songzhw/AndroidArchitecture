package ca.six.todo.biz.tasks;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ca.six.todo.R;
import ca.six.todo.databinding.ActivityTasksBinding;

/**
 * Created by songzhw on 2017-03-04
 */

// TODO: 2017-03-04 add switch animation for swithcing all/complete/activie
public class TasksActivity extends Activity {
    private ActivityTasksBinding binding;
    private TasksViewModel vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tasks);
        vm = new TasksViewModel(binding);
    }
}
