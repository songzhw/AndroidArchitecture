package ca.six.todo.utils;

import android.app.Activity;
import android.content.Intent;

import ca.six.todo.core.TodoApp;

/**
 * Created by songzhw on 2017-03-04
 */

public class ToUtils {
    public static void jump(Activity actv, Class clz){
        Intent it = new Intent(actv, clz);
        actv.startActivity(it);//光是Context， 如Application， 可能会crash (AndroidRuntimeException)
    }
}
