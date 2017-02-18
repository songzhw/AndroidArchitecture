package ca.six.bindingdemo.tmp;

import android.view.View;

import ca.six.bindingdemo.databinding.ActivityBindingDemoSimpleBinding;

/**
 * Created by songzhw on 2017-02-18
 */

public class Binding01ViewModel {

    private TmpUser user;

    public Binding01ViewModel(ActivityBindingDemoSimpleBinding binding) {
        user = new TmpUser("name2", "desp2", true);
        binding.setUser(user);
        binding.setHandler(this);
    }

    public void click01(View v) {
        System.out.println("szw click01 : " + user);
    }

}
