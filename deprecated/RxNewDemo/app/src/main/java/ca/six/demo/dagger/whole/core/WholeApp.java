package ca.six.demo.dagger.whole.core;

import android.app.Application;

public class WholeApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
