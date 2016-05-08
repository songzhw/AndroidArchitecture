package cn.six.lab.http;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.six.lab.R;
import cn.six.lab.http.SimpleInterceptor;
import cn.six.lab.utils.StethoUtils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpAsyncTask task = new HttpAsyncTask();
                task.execute();
            }
        });


    }

    private class HttpAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                startHttp();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    private void startHttp() throws IOException {
        File cachedDir =  new File(this.getApplication().getExternalCacheDir(), "HttpCache");
        Cache cache = new Cache(cachedDir, 10240);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new SimpleInterceptor())
                .cache(cache);
        StethoUtils.addStethoInterceptor(builder);
        OkHttpClient okhttp = builder.build();
        Request req = new Request.Builder()
                .cacheControl(new CacheControl.Builder().maxStale(30, TimeUnit.DAYS).build())
                .url("http://www.publicobject.com/helloworld.txt")
                .header("User-Agent", "OkHttp Example")
                .build();


        Response resp = okhttp.newCall(req)
                .execute();
        if (resp.code() != 504){
            // resource was cached. Show it
            Log.d("szw", "cached!");
        } else{
            // resource was not cached.
            Log.d("szw", "not cached!");
        }
        resp.body().close();
    }


}
