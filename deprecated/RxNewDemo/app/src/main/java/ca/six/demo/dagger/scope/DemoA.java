package ca.six.demo.dagger.scope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import javax.inject.Inject;

public class DemoA extends Activity {
    @Inject User bob;
    @Inject User jim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((ScopeApp)getApplication()).getScopeComponent().inject(this);

        System.out.println("szw DemoA : bob  = " + bob);
        System.out.println("szw DemoA : jim  = " + jim);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(MotionEvent.ACTION_UP == event.getAction()) {
            Intent it = new Intent(this, DemoB.class);
            startActivity(it);
        }
        return super.onTouchEvent(event);
    }

}
