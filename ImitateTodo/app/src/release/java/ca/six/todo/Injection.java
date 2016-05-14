package ca.six.todo;

import android.content.Context;

import ca.six.todo.add_task.AddTaskActivity;
import ca.six.todo.model.ITaskManager;
import ca.six.todo.model.TaskManager;

/**
 * Created by songzhw on 2016-05-14.
 */
public class Injection {
    public static ITaskManager getModel(Context ctx) {
        return TaskManager.getInstance(ctx);
    }
}
