package cn.six.lab.decopuled_base.delegate;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import cn.six.lab.decopuled_base.ActivityDelegate;
import cn.six.lab.decopuled_base.model.ErrorHttpCallback;
import cn.six.lab.decopuled_base.model.HttpCallback;
import cn.six.lab.decopuled_base.model.HttpEngine;

/**
 * Created by songzhw on 2017-01-29
 */

public class NetworkActivityDelegate extends ActivityDelegate {
    public HttpEngine httpEngine;
    private ErrorHttpCallback errorHttpCallback;
    private ProgressDialog progress;

    public NetworkActivityDelegate(Activity activity) {
        super(activity);
        httpEngine = new HttpEngine();
        errorHttpCallback = new ErrorHttpCallback(activity);
    }

    public void request(String args, HttpCallback callback) {
        // before request, show loading progress dialog
        showLoadingProgress(activity);

        // send the request. Now mock the response
        boolean isError = args.equals("ok");

        if (isError) {
            errorHttpCallback.showError();
        } else {
            callback.onResponse("response <-- request( " + args + " )");
        }

        // after request, dismiss the progress dialog
        dismissLoadingProgress();

    }

    private void dismissLoadingProgress() {
        if (progress != null) {
            progress.dismiss();
        }
    }

    private void showLoadingProgress(Activity activity) {
        // show Progress Dialog
        progress = new ProgressDialog(activity);
        progress.setTitle("Please wait ...");
        progress.show();
    }


}
