package ca.six.todo.biz.add_task;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ca.six.todo.R;
import ca.six.todo.core.BaseActivity;

/**
 * Created by songzhw on 2017-03-05
 */

public class AddTaskActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }
}
