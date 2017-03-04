package ca.six.todo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import ca.six.todo.biz.tasks.TasksActivity;
import ca.six.todo.utils.ToUtils;

// 本页不宜用android:noHistory. 因为要防止press home key
// TODO apply an expansion to iv
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.sendEmptyMessageDelayed(11, 2000);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            ToUtils.jump(TasksActivity.class);
        }
    };
}
