package ca.six.todo.utils;

import android.content.Intent;

import ca.six.todo.core.TodoApp;

/**
 * Created by songzhw on 2017-03-04
 */

public class ToUtils {
    public static void jump(Class clz){
        Intent it = new Intent(TodoApp.ctx, clz);
        TodoApp.ctx.startActivity(it);
    }
}
