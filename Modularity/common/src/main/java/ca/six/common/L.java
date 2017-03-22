package ca.six.common;

/**
 * Created by songzhw on 2017-03-18
 */

public class L {
    public static void d(String msg){
        if(BuildConfig.DEBUG){
            System.out.println("szw "+msg);
        }
    }
}
