package ca.six.todo.biz.tasks;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import ca.six.todo.R;

/**
 * Created by songzhw on 2017-03-04
 */

// TODO: 2017-03-04 add switch animation for swithcing all/complete/activie
public class TasksActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
    }
}
