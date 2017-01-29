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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

}
