package ca.six.todo.biz.tasks;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ca.six.todo.BR;
import ca.six.todo.R;
import ca.six.todo.biz.add_task.AddTaskActivity;
import ca.six.todo.core.BaseActivity;
import ca.six.todo.data.Task;
import ca.six.todo.databinding.ActivityTasksBinding;
import ca.six.todo.utils.ToUtils;
import ca.six.todo.view.rv.OneBindingAdapter;

/**
 * Created by songzhw on 2017-03-04
 */

// TODO: 2017-03-04 add switch animation for swithcing all/complete/activie
public class TasksActivity extends BaseActivity implements ITasksView {
    public static final int REQ_ADD_TASK = 11;
    private ActivityTasksBinding binding;
    private TasksViewModel vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tasks);
        vm = new TasksViewModel(binding, this);
    }

    @Override
    public void gotoAddTask() {
        ToUtils.jumpForResult(this, AddTaskActivity.class, REQ_ADD_TASK);
    }

    @Override
    public void refresh(List<Task> tasks) {
        OneBindingAdapter<Task> adapter = new OneBindingAdapter<>(this, R.layout.item_tasks, BR.task, tasks);
        RecyclerView rv = binding.rvTasks;
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String desp = data.getStringExtra("desp");
            System.out.println("szw TasksActivity.onResult() name = "+name+" ; desp = "+desp);
            vm.getNewTaskInfo(name, desp);
        }
    }
}
