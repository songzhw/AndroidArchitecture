package ca.six.demo.dagger.whole.core;

import android.app.Activity;

import ca.six.demo.dagger.whole.biz.ActivityComponent;
import ca.six.demo.dagger.whole.biz.DaggerActivityComponent;

public class BaseActivity extends Activity {

    protected ActivityComponent getActivityComponent(){
        WholeApp app = (WholeApp) getApplication();
        return DaggerActivityComponent.builder()
                .appComponent(app.getAppComponent())
                .build();
    }
}
