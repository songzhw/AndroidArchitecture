package six.ca.demo.dagger2.simple;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import six.ca.demo.R;

public class SimpleDemo extends Activity {
    @Inject Apple apple;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DaggerSimpleComponent.builder()
                .build()
                .inject(this);

        TextView tv = (TextView) findViewById(R.id.tvHome);
        tv.setText(apple.toString());

    }
}
