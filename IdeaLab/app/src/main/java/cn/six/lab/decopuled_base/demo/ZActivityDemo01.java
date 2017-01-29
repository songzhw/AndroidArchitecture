package cn.six.lab.decopuled_base.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.six.lab.decopuled_base.ZBaseActivity;
import cn.six.lab.decopuled_base.delegate.GetPhotoActivityDelegate;

/**
 * Created by songzhw on 2017-01-28
 */

public class ZActivityDemo01 extends ZBaseActivity implements View.OnClickListener,
        GetPhotoActivityDelegate.IGetPhoteResult {

    private GetPhotoActivityDelegate getPhotoActivityDelegate;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn = new Button(this);
        btn.setText("Get Photo");
        btn.setOnClickListener(this);
        setContentView(btn);
    }

    @Override
    public void initDelegater() {
        getPhotoActivityDelegate = new GetPhotoActivityDelegate(this, this);
        delegater.put(getPhotoActivityDelegate);
    }

    @Override
    public void onClick(View v) {
        getPhotoActivityDelegate.goGetPhoto();
    }

    @Override
    public void onGotPhoto(String uri) {
        System.out.println("szw onGotPhoto uri = " + uri);
        // Bitmap photo = FileUtils.getCompressedBitmap(uri); //原图太大，要经过inSampleSize才行
    }
}
