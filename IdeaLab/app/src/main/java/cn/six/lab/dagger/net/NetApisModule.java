package cn.six.lab.dagger.net;

import android.app.Application;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import cn.six.lab.dagger.net.NetApis;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by songzhw on 2016/3/21.
 */
@Module
public class NetApisModule {

    @Provides
    @Singleton
    NetApis provideNetApis(){
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        return retrofit.create(NetApis.class);
    }

}
