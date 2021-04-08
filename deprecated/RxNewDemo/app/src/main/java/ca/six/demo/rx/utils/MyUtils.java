package ca.six.demo.rx.utils;

import android.os.Looper;

public class MyUtils {
    public static boolean isMainThread(){
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
