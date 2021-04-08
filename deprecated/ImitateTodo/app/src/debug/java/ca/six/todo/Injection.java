package ca.six.todo;

import android.content.Context;

import ca.six.todo.model.FakeTaskManager;
import ca.six.todo.model.ITaskManager;
import ca.six.todo.model.TaskManager;

/**
 * Created by songzhw on 2016-05-14.
 */
public class Injection {
    public static ITaskManager getModel(Context ctx) {
        // TODO: 2016-05-14 : switch to FakeManager !!!
        return FakeTaskManager.getInstance();
    }
}
