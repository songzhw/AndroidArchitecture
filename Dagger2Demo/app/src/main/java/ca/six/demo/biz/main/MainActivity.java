package ca.six.demo.biz.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import ca.six.demo.R;
import ca.six.demo.domain.entity.User;

public class MainActivity extends AppCompatActivity {

    @Inject User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tvMain);

        // 先build下， DaggerActivitiesComponent这个类才会出来
        ActivitiesComponent component = DaggerActivitiesComponent.builder()
                .activitiesModule(new ActivitiesModule("CF Inject"))
                .build();
        component.injectMain(this);

        tv.setText(user.toString());
    }
}
