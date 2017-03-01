package ca.six.bindingdemo.tmp.iv;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import ca.six.bindingdemo.tmp.Binding01ViewModel;
import ca.six.bindingdemo.tmp.custom.ICustomListener;
import ca.six.bindingdemo.tmp.custom.MyTextView;

/**
 * Created by songzhw on 2017-02-27
 */

public class DataBindingAdapters {
    @BindingAdapter("android:src")
    public static void setImage(ImageView iv, @DrawableRes int res) {
        iv.setImageResource(res);
    }

    @BindingAdapter("android:onMyChange")
    public static void setChangeListener(MyTextView view, ICustomListener model) {
        view.setListener(model);
    }
}
