package ca.six.biz1;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import ca.six.common.WebViewActivity;

/**
 * Created by songzhw on 2017-01-31
 */

public class Biz1WebViewActivity extends WebViewActivity {

    @Override
    protected void notifyProgress(int newProgress) {
        super.notifyProgress(newProgress);
        // biz1-specified logic
    }

    @Override
    protected boolean overrideUrlLoading(WebView view, WebResourceRequest request) {
        // biz1-specified logic
        return super.overrideUrlLoading(view, request);
    }
}