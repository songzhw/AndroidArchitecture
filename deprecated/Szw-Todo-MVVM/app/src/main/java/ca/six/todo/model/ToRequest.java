package ca.six.todo.model;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by songzhw on 2017-03-05
 *
 * Uses the Mock API
 */

public class ToRequest {
    public static final String ADD_TASK_URL = "58bc38f61000005118109ec8";

    private HashMap<String, String> params;
    public static final String URL = "http://www.mocky.io/v2/";

    public ToRequest(){
        params = new HashMap<>();
    }

    public void sendRequest(String endPoint, Callback callback){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(URL +endPoint)
                .build();
        // can add params here
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public void addParam(String key, String value){
        params.put(key, value);
    }
}
