package cn.six.lab.decopuled_base.model;

import android.app.Activity;

/**
 * Created by songzhw on 2017-01-29
 *
 * 1. pre: showProgressDialog();
 * 2. do the http call, get the response
 * 3. parse the json
 * 4. if error, show the error (view? fragment?)
 */

public class HttpEngine {

    // a mock method to send request
    public void request(String args, HttpCallback callback){
        System.out.println("szw request --> response");
    }

}
