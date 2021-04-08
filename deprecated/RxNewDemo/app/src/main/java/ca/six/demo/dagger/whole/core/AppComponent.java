package ca.six.demo.dagger.whole.core;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import ca.six.demo.dagger.whole.dagger.PerApplication;
import dagger.Component;
import okhttp3.OkHttpClient;

@PerApplication
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    Context context();
    Resources resources();
    OkHttpClient okHttpClient();
}
