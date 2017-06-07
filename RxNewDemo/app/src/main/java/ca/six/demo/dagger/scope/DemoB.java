package ca.six.demo.dagger.scope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import javax.inject.Inject;

public class DemoB extends Activity {
    @Inject
    User lucy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerScopeComponent.builder()
                .build()
                .inject(this);

        System.out.println("szw DemoB : lucy = " + lucy);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}