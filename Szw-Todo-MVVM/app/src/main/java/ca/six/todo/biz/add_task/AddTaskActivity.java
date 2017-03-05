package ca.six.todo.biz.add_task;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ca.six.todo.R;
import ca.six.todo.biz.tasks.TasksActivity;
import ca.six.todo.core.BaseActivity;
import ca.six.todo.databinding.ActivityAddTaskBinding;

/**
 * Created by songzhw on 2017-03-05
 */

public class AddTaskActivity extends BaseActivity implements IAddTaskView {

    private ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_task);

        AddTaskViewModel vm = new AddTaskViewModel(this);
        binding.setVm(vm);
    }

    @Override
    public void addedTask(String name, String desp) {
        Intent it = new Intent();
        it.putExtra("name", name);
        it.putExtra("desp", desp);
        setResult(RESULT_OK, it);
        this.finish();
    }
}
