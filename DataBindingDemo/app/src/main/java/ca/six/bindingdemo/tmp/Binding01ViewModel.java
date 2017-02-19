package ca.six.bindingdemo.tmp;

import android.view.View;

import ca.six.bindingdemo.BR;
import ca.six.bindingdemo.databinding.ActivityBindingDemoSimpleBinding;

/**
 * Created by songzhw on 2017-02-18
 */

public class Binding01ViewModel {

    private final ActivityBindingDemoSimpleBinding binding;
    private TmpUser user;

    public Binding01ViewModel(ActivityBindingDemoSimpleBinding binding) {
        user = new TmpUser("name2", "desp2", true);
        this.binding = binding;
        binding.setUser(user);
        binding.setHandler(this);
    }

    public void click01(View v) {
        System.out.println("szw click01 : " + user);
    }

    // how to make UI change when I update the model
    //      : 01. binding.invalidateAll()
    //      : 02. Make TmepUser class a subclass of BaseObservable
                  // (but when you check isMale, only show tvWonderWoman. The name is still the same)
                  // (you may have to use setName(), not just user.name(). Then the name will change too)
    public void onChecked(boolean isChecked){
        user.setName(user.name + (isChecked?" Y ":" N "));
//        binding.invalidateAll(); // show/disappear tvWonderWoman, and update the tvName
//        binding.notifyPropertyChanged(BR.user); // does not work
        System.out.println("szw click02 : " + user);
    }

}
