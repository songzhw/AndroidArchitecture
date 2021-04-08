package ca.six.bindingdemo.tmp;

import android.view.View;

import ca.six.bindingdemo.R;
import ca.six.bindingdemo.databinding.ActivityBindingDemoSimpleBinding;
import ca.six.bindingdemo.tmp.custom.ICustomListener;

/**
 * Created by songzhw on 2017-02-18
 */

public class Binding01ViewModel implements ICustomListener{

    private final ActivityBindingDemoSimpleBinding binding;
    private User user;

    public Binding01ViewModel(ActivityBindingDemoSimpleBinding binding) {
        user = new User("name2", "desp2", true, R.drawable.ic_face);
        this.binding = binding;
        binding.setUser(user);
        binding.setHandler(this);
    }


    public void click01(View v) {
        System.out.println("szw click01 : " + user);
    }

    /*
    how to make UI change when I update the model
       : 01. binding.invalidateAll()
       : 02. Make TmepUser class a subclass of BaseObservable
          (but when you check isMale, only show tvWonderWoman. The name is still the same)
          (you may have to use setName(), not just user.name(). Then the name will change too)
    */
    public void onChecked(boolean isChecked) {
        user.name.set(user.name.get() + (isChecked ? " Y ": " N "));
//        binding.invalidateAll(); // show/disappear tvWonderWoman, and update the tvName
//        binding.notifyPropertyChanged(BR.user); // does not work
        System.out.println("szw click02 : " + user);
    }

    @Override
    public void onChange(View v) {
        System.out.println("szw ======  [vm.onChanged: " + v + "]  ======");
    }
}
