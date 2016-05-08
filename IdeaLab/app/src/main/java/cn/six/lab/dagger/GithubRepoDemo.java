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
