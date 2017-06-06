package ca.six.demo.dagger.cf_args;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import ca.six.demo.dagger.cf_arg.DaggerSamplePresenterComponent;

public class ForthActivity extends Activity implements IForthView {

    @Inject
    ForthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaggerSamplePresenterComponent.builder()
//                .sampleViewModule(new SampleViewModule(this))
//                .build()
//                .inject(this);
    }

    @Override
    public void viewReady() {
        System.out.println("szw viewReady()");
    }
}