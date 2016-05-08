package cn.six.lab.dagger.core;

import android.app.Application;
import android.content.Context;

import cn.six.lab.dagger.net.NetApisModule;

/**
 * Created by songzhw on 2016/3/21.
 */
public class MyApp extends Application{


    public AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        this.component = DaggerAppComponent.builder()
                .netApisModule(new NetApisModule())
                .build();
    }

    public static MyApp get(Context ctx){
        return (MyApp)ctx.getApplicationContext();
    }

}
