package ca.six.demo.dagger.cf_args;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

public class ForthActivity extends Activity implements IForthView {

//    @Inject
    ForthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaggerForthPresenterComponent.builder()
//                .forthViewModule(new ForthViewModule(this))
//                .build()
//                .inject(this);
    }

    @Override
    public void viewReady() {
        System.out.println("szw viewReady()");
    }
}