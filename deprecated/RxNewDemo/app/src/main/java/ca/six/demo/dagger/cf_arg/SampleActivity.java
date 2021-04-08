package ca.six.demo.dagger.cf_arg;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

public class SampleActivity extends Activity implements ISampleView {

    @Inject
    SamplePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSamplePresenterComponent.builder()
                .sampleViewModule(new SampleViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void viewReady() {
        System.out.println("szw viewReady()");
    }
}