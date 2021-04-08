package cn.six.lab.dagger.core;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import cn.six.lab.dagger.net.NetApisModule;
import cn.six.lab.utils.StethoUtils;

/**
 * Created by songzhw on 2016/3/21.
 */
public class MyApp extends Application{


    public AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        // init Dagger
        this.component = DaggerAppComponent.builder()
                .netApisModule(new NetApisModule())
                .build();

        // init Stetho
        StethoUtils.initStetho(this);
    }

    public static MyApp get(Context ctx){
        return (MyApp)ctx.getApplicationContext();
    }

}
