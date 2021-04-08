package ca.six.demo.dagger.whole.core;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import ca.six.demo.dagger.whole.dagger.PerApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides @PerApplication
    Context provideAppContext(){
        return app;
    }

    @Provides @PerApplication
    Resources provideResources(){
        return app.getResources();
    }
}
