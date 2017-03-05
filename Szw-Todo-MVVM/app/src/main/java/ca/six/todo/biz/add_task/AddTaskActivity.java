package ca.six.todo.biz.add_task;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ca.six.todo.R;
import ca.six.todo.core.BaseActivity;
import ca.six.todo.databinding.ActivityAddTaskBinding;

/**
 * Created by songzhw on 2017-03-05
 */

public class AddTaskActivity extends BaseActivity {

    private ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_task);

        AddTaskViewModel vm = new AddTaskViewModel();
        binding.setVm(vm);
    }
}
