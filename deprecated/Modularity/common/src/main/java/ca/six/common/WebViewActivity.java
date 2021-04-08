package ca.six.common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by songzhw on 2017-01-31
 */

public class WebViewActivity extends BaseActivity {
    private WebView wv;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pd = new ProgressDialog(this);
        wv = new WebView(this);
        wv.setWebViewClient(webViewClient);
    }

    protected WebViewClient webViewClient = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            // the default action
            System.out.println("log");
            pd.show();

            // the action that only children have
            boolean ret = overrideUrlLoading(view, request);
            return ret;
        }
    };

    protected boolean overrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }


    protected WebChromeClient webChromeClient = new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // show a progessDialog
            pd.setProgress(newProgress);
            notifyProgress(newProgress);
        }
    };

    protected void notifyProgress(int newProgress) {

    }
}
