package cn.six.lab.decopuled_base.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.six.lab.decopuled_base.ZBaseActivity;
import cn.six.lab.decopuled_base.delegate.GetPhotoActivityDelegate;
import cn.six.lab.decopuled_base.delegate.IRefreshActionListener;
import cn.six.lab.decopuled_base.delegate.NetworkActivityDelegate;
import cn.six.lab.decopuled_base.delegate.RefreshActivityDelegate;
import cn.six.lab.decopuled_base.model.HttpCallback;

/**
 * Created by songzhw on 2017-01-28
 */

public class ZActivityDemo02 extends ZBaseActivity implements View.OnClickListener, HttpCallback, IRefreshActionListener {
    private Button btn;
    private NetworkActivityDelegate http;
    private GetPhotoActivityDelegate getPhotoActivityDelegate;
    private RefreshActivityDelegate refreshActivityDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn = new Button(this);
        btn.setText("Http Call");
        btn.setOnClickListener(this);
        setContentView(btn);
    }

    @Override
    public void initDelegater() {
        http = new NetworkActivityDelegate(this);
        getPhotoActivityDelegate = new GetPhotoActivityDelegate(this, null);
        refreshActivityDelegate = new RefreshActivityDelegate(this, this);
        delegater.put(http);
        delegater.put(getPhotoActivityDelegate);
        delegater.put(refreshActivityDelegate);
    }

    @Override
    public void onClick(View v) {
        http.request("ok", this);
    }

    @Override
    public void onResponse(String response) {
        // show the UI when response is successful
    }

    @Override
    public void onRefresh() {

    }
}