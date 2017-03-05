package ca.six.todo.biz.tasks;

import android.content.Intent;
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
    public static final int REQ = 11;
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
        ToUtils.jumpForResult(this, AddTaskActivity.class, REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

        }
    }
}
