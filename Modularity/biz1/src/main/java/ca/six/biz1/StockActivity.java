package ca.six.biz1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// option 1: check login here
// option 2: check login in the AppHomeActivity.
    // AppHomeActivity.onActivityResult() will jump to StockActivity again.
// I think option2 is a better idea.
public class StockActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        String value = getIntent().getStringExtra("key");
        System.out.println("szw StockActivity : value = " + value);
    }
}
