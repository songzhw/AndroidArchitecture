package ca.six.todo.core;

import android.app.Application;
import android.content.Context;

/**
 * Created by songzhw on 2017-03-04
 */

public class TodoApp extends Application {
    public static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
    }

}
