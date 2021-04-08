package ca.six.common.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by songzhw on 2016-10-13
 */

public class JumpUtils {

    public static void jump2(Activity from, Class to){
        Intent it = new Intent(from, to);
        from.startActivity(it);
    }

    public static void jump2(Activity from, String to){
        try {
            Class toClass = Class.forName(to);
            jump2(from, toClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void jump2(Activity from, String toPakcage, String toClassName){
        jump2(from, toPakcage+"."+toClassName);
    }

    public static void jumpImplicit2 (Activity from, String action){
        Intent it = new Intent(action);
        from.startActivity(it);
    }

}
