package cn.six.lab.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by songzhw on 2016-05-08.
 */
public class SimpleInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request req = chain.request();
        Log.d("szw", "[intercept] req = "+req.url());

        Response resp = chain.proceed(req);
        Log.d("szw", "[intercept] resp = "+resp.request().url()+"\n");

        return resp;
    }
}
