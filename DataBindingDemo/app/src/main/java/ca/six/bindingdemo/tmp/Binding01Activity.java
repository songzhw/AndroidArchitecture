package ca.six.bindingdemo.tmp;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import ca.six.bindingdemo.R;
import ca.six.bindingdemo.databinding.ActivityBindingDemoSimpleBinding;

/**
 * Created by songzhw on 2017-02-18
 */

public class Binding01Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingDemoSimpleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_demo_simple);

        Binding01ViewModel vm = new Binding01ViewModel(binding);
    }

}
