package ca.six.demo.dagger.intro_inject_component;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

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
