package cn.six.lab.dagger.net;

import java.util.List;

import cn.six.lab.dagger.data.Repo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by songzhw on 2016/3/21.
 */
public interface NetApis {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
