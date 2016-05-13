package ca.six.todo.model;

import android.content.ContentValues;
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
    private SQLiteDatabase db;

    private TaskManager(Context ctx) {
        TaskDbHelper dbHelper = new TaskDbHelper(ctx);
        db = dbHelper.getWritableDatabase();
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
        return tasks;
    }

    @Override
    public void saveTask(String text) {
        ContentValues insertedValue = new ContentValues();
        insertedValue.put("content", text);
        insertedValue.put("completed", 0);// 1 isCompleted ; 0 other
        db.insert("task", null, insertedValue);
    }


}
