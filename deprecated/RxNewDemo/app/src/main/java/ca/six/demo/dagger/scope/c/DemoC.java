package ca.six.demo.dagger.scope.c;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import ca.six.demo.dagger.scope.User;

public class DemoC extends Activity {
    @Inject User king;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerCUserComponent.builder()
                .cUserModel(new CUserModel())
                .build()
                .inject(this);

        System.out.println("szw DemoA : king = " + king);
    }

}
