package ca.six.biz2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ca.six.common.utils.JumpUtils;

public class OptionActivity extends Activity implements View.OnClickListener {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        tv = (TextView) findViewById(R.id.tvHomeOption);
        tv.setOnClickListener(this);

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        JumpUtils.jump2(this, "ca.six.biz1","StockActivity");
    }

    // get the value from StockActivity
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(String msg) {
        tv.setText(msg);
    }

}
