package cn.six.lab.decopuled_base.model;

import android.app.Activity;

/**
 * Created by songzhw on 2017-01-29
 */

public class ErrorHttpCallback {
    private Activity activity;

    public ErrorHttpCallback(Activity activity) {
        this.activity = activity;

    }

    public void showError() {
        // show Dialog, FloatingWindow, Toast, or Fragment
    }
}
