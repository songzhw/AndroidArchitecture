package cn.six.lab.dagger;

import android.app.Activity;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;

import cn.six.lab.dagger.core.AppComponent;
import cn.six.lab.dagger.core.MyApp;
import cn.six.lab.dagger.data.Repo;
import cn.six.lab.dagger.net.NetApis;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by songzhw on 2016/3/21.
 */
public class GithubRepoDemo extends Activity {

    private NetApis apis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppComponent component = MyApp.get(this).component;
        this.apis = component.getNetApis();

        new Thread(runnable).start();

    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            try {
                Call<List<Repo>> call = apis.listRepos("songzhw");
                Response<List<Repo>> resp = call.execute();
                List<Repo> repos = resp.body();
                for (Repo repo : repos) {
                    System.out.println("szw : " + repo);
                }
            }catch (IOException e){
                System.out.println("szw error "+e);
            }
        }
    };
}

/*
szw : Repo{id=42987127, name='groovy-android-gradle-plugin', size=231}
szw : Repo{id=50723416, name='infinity-loading', size=1462}
szw : Repo{id=40647821, name='Kotlin-Java-Demo', size=15432}
szw : Repo{id=53929937, name='Learn-Google-API', size=60}
szw : Repo{id=53385756, name='Python-Practice', size=17}
... ...
 */