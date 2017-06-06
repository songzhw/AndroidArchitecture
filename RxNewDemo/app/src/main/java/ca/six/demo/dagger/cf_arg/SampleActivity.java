package ca.six.demo.dagger.cf_arg;

import android.app.Activity;
import android.os.Bundle;

public class SampleActivity extends Activity implements ISampleView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new SamplePresenter(this);
    }

    @Override
    public void viewReady() {

    }
}
