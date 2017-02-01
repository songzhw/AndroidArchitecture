package ca.six.biz1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ca.six.common.utils.JumpUtils;

// option 1: check login here
// option 2: check login in the AppHomeActivity.
// AppHomeActivity.onActivityResult() will jump to StockActivity again.
// I think option2 is a better idea.
public class StockActivity extends Activity implements View.OnClickListener {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        tv = (TextView) findViewById(R.id.tvStock);
        tv.setOnClickListener(this);

        String value = getIntent().getStringExtra("key");
        System.out.println("szw StockActivity : value = " + value);
    }


    @Override
    public void onClick(View v) {
        EventBus.getDefault().post("from stock " + System.currentTimeMillis());
        this.finish();
    }
}
