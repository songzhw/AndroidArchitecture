package ca.six.todo.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songzhw on 2016-05-11.
 */
public class TaskManager implements ITaskManager {
    private static TaskManager instance;
    private TaskDbHelper dbHelper;

    private TaskManager(Context ctx) {
        dbHelper = new TaskDbHelper(ctx);
    }

    public static TaskManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new TaskManager(ctx);
        }
        return instance;
    }


    @Override
    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("task", new String[]{"content", "completed"}, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                boolean isCompleted = cursor.getInt(cursor.getColumnIndexOrThrow("completed")) == 1;
                Task task = new Task(content, isCompleted);
                tasks.add(task);
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return tasks;
    }


}
