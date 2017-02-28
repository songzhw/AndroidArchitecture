package ca.six.bindingdemo.tmp.iv;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * Created by songzhw on 2017-02-27
 */

public class DataBindingAdapters {
    @BindingAdapter("android:src")
    public static void setImage(ImageView iv, @DrawableRes int res){
        iv.setImageResource(res);
    }
}
