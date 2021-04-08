package cn.six.lab.utils;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

/**
 * Created by songzhw on 2016-05-08.
 */
public class StethoUtils {
    public static void initStetho(Application app){
        // init Stetho in the debug version
        Stetho.initializeWithDefaults(app);
    }

    public static void addStethoInterceptor(OkHttpClient.Builder builder){
        builder.addNetworkInterceptor(new StethoInterceptor());
    }

}
