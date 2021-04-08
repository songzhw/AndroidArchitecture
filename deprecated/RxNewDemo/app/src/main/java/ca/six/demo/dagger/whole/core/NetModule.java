package ca.six.demo.dagger.whole.core;

import javax.inject.Singleton;

import ca.six.demo.dagger.whole.dagger.PerApplication;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class NetModule {

    @Provides  @PerApplication
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }
}
