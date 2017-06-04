package ca.six.demo.dagger.simple;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import javax.inject.Inject;

import ca.six.demo.R;


public class SimpleDemo extends Activity {
    @Inject
    Apple apple;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSimpleComponent.builder()
                .build()
                .inject(this);

        System.out.println("szw : apple = " + apple.toString());

    }
}
