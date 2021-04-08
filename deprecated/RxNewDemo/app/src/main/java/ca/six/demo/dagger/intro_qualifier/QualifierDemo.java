package ca.six.demo.dagger.intro_qualifier;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Named;

import ca.six.demo.dagger.intro_qualifier.ctx.MyContext;

public class QualifierDemo extends Activity {
    @Inject @Named("app") MyContext ctx;
    @Inject @Named("activity") MyContext ctx2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
