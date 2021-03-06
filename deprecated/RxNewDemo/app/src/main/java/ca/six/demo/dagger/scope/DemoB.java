package ca.six.demo.dagger.scope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import javax.inject.Inject;

import ca.six.demo.dagger.scope.c.DemoC;

public class DemoB extends Activity {
    @Inject User lucy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((ScopeApp)getApplication()).getScopeComponent().inject(this);

        System.out.println("szw DemoB : lucy = " + lucy);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(MotionEvent.ACTION_UP == event.getAction()) {
            Intent it = new Intent(this, DemoC.class);
            startActivity(it);
        }
        return super.onTouchEvent(event);
    }
}