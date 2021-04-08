package cn.six.lab.decopuled_base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by songzhw on 2017-01-28
 */

public class ActivityDelegate {
    public Activity activity;

    public ActivityDelegate(Activity activity) {
        this.activity = activity;
    }

    protected void onCreate(Bundle savedInstanceState) {
    }

    protected void onPostCreate(){

    }

    protected void onStart() {
    }

    protected void onResume() {
    }

    protected void onStop() {
    }

    protected void onPause() {
    }

    protected void onDestroy() {
    }

    /*
      不是每个页面的onActivityResult()都要写入ActivityDelegate
      是公共组件，即有多个Activity要用的onActivityResult()特性，才写入delegate
    */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

}
