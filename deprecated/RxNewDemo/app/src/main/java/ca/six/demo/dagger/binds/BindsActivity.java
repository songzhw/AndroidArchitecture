package ca.six.demo.dagger.binds;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

public class BindsActivity extends Activity {

    @Inject
    IBindsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerBindsComponent.builder()
                .build()
                .inject(this);

        presenter.init();
    }

}