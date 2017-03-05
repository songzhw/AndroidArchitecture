package ca.six.todo.biz.tasks;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ca.six.todo.R;
import ca.six.todo.biz.add_task.AddTaskActivity;
import ca.six.todo.biz.add_task.AddTaskViewModel;
import ca.six.todo.core.BaseActivity;
import ca.six.todo.databinding.ActivityTasksBinding;
import ca.six.todo.utils.ToUtils;

/**
 * Created by songzhw on 2017-03-04
 */

// TODO: 2017-03-04 add switch animation for swithcing all/complete/activie
public class TasksActivity extends BaseActivity implements ITasksView {
    private ActivityTasksBinding binding;
    private TasksViewModel vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tasks);
        vm = new TasksViewModel(binding, this);
    }

    @Override
    public void addNewTask() {
        ToUtils.jump(this, AddTaskActivity.class);
    }
}
