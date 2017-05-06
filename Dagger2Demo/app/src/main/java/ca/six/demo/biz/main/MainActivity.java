package ca.six.demo.biz.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ca.six.demo.R;
import ca.six.demo.domain.entity.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tvMain);

        User user = new User("test");
        tv.setText(user.toString());
    }
}
