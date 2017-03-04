package ca.six.todo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// 本页不宜用android:noHistory. 因为要防止press home key
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    }


}
