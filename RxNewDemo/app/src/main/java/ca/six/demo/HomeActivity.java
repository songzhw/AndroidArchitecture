package ca.six.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import ca.six.demo.rx.binding.Binds;
import io.reactivex.functions.Consumer;

public class HomeActivity extends AppCompatActivity {

    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvMessage = (TextView) findViewById(R.id.message);
        Button btn = (Button)findViewById(R.id.btnHome);

        Binds.clicks(btn)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe( (obj) -> {
                        System.out.println("szw click btn1 "+ System.currentTimeMillis());
                });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tvMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    tvMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    tvMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };


}
