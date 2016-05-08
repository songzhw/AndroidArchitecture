package cn.six.lab.utils;

import android.app.Application;

import okhttp3.OkHttpClient;

/**
 * Created by songzhw on 2016-05-08.
 */
public class StethoUtils {
    public static void initStetho(Application app){
        // do nothing in the release version
    }

    public static void addStethoInterceptor(OkHttpClient.Builder builder){
        // do nothing in the release version
    }
}
